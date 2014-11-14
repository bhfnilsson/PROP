package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class ExpressionNode implements INode{

	private TermNode term;
	private Lexeme operator;
	private ExpressionNode expression;
	
	public ExpressionNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		
		term = new TermNode(tokenizer);
		Lexeme lexeme = tokenizer.current();
		
		if(lexeme.value().equals("+") || lexeme.value().equals(("-"))) {
			
			operator = lexeme;
			tokenizer.moveNext();
			expression = new ExpressionNode(tokenizer);
		}
		
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		// TODO Auto-generated method stub
		
	}

}
