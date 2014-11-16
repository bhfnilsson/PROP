package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Token;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class TermNode implements INode{

	private FactorNode factor;
	private Lexeme operator;
	private TermNode term;
	
	public TermNode(Tokenizer tokenizer) throws IOException, TokenizerException {

		factor = new FactorNode(tokenizer);
		Lexeme lexeme = tokenizer.current();

		if(lexeme.token().equals(Token.MULT_OP) || lexeme.token().equals(Token.DIV_OP)) {
			operator = lexeme;
			tokenizer.moveNext();
			term = new TermNode(tokenizer);
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
