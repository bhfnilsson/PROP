package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class AssignNode implements INode{

	private Lexeme id;
	private ExpressionNode expression;
	
	public AssignNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		
		id = tokenizer.current();
		tokenizer.moveNext();
		
		expression = new ExpressionNode(tokenizer);
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
