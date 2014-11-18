package prop.assignment0.node;

import java.io.IOException;
import prop.assignment0.node.*;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Token;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class FactorNode implements INode{

	private Lexeme value;
	private Lexeme leftParenthesis;
	private Lexeme rightParenthesis;
	private ExpressionNode expression;
	
	public FactorNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		Lexeme lexeme = tokenizer.current();
		tokenizer.moveNext();
		if(!lexeme.token().equals(Token.LEFT_PAREN)) {
			value = lexeme;
		} else {
			leftParenthesis = lexeme;
			expression = new ExpressionNode(tokenizer);
			rightParenthesis = tokenizer.current();
			tokenizer.moveNext();
		}
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
//		if(value == null) {
//			return expression.evaluate(null);
//		} else {
//			if(value.token().equals(Token.INT_LIT) {
//				return Double.parseDouble("" + value.value());
//			} else {
//				for (int i = 0; i < args.length; i++) {
//					if(value.token().equals((AssignNode)args[i].getValue())) {
//						
//					}
//				}
//			}
//		}
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append("FactorNode\n");
		
		tabs++;
		
		if(value == null) {
			for (int i = 0; i < tabs; i++) {
				builder.append("\t");
			}
			
			builder.append(leftParenthesis + "\n");
			
			expression.buildString(builder, tabs);

			for (int i = 0; i < tabs; i++) {
				builder.append("\t");
			}
			
			builder.append(rightParenthesis + "\n");
		} else {

			for (int i = 0; i < tabs; i++) {
				builder.append("\t");
			}
			
			if(value.token().equals(Token.INT_LIT)) {
			
				builder.append("" + value.token() + " " + Double.parseDouble("" + value.value()) + "\n");
			} else {
				
				builder.append(value + "\n");
			}
		}
	}

}
