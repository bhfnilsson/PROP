package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Token;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class ExpressionNode implements INode{

	private TermNode term;
	private Lexeme operator;
	private ExpressionNode expression;

	public ExpressionNode(Tokenizer tokenizer) throws IOException, TokenizerException {

		term = new TermNode(tokenizer);
		Lexeme lexeme = tokenizer.current();
		if(lexeme.token().equals(Token.ADD_OP) || lexeme.token().equals(Token.SUB_OP)) {

			operator = lexeme;
			tokenizer.moveNext();
			expression = new ExpressionNode(tokenizer);
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		if(expression != null) {
			if(operator.token().equals(Token.ADD_OP)) {
				return (double)term.evaluate(args) + (double)expression.evaluate(args);
			} else if(operator.token().equals(Token.SUB_OP)) {
				return (double)term.evaluate(args) - 
						(double)expression.term.evaluate(args) * 2 + 
						(double)expression.evaluate(args);
			} else {
				return null;
			}
		} else {
			return term.evaluate(args);
		}
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {

		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}

		builder.append("ExpressionNode\n");

		tabs++;

		term.buildString(builder, tabs);

		if(expression != null) {

			for (int i = 0; i < tabs; i++) {
				builder.append("\t");
			}

			builder.append(operator + "\n");

			expression.buildString(builder, tabs);
		}

	}
}
