package prop.assignment0.node;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import prop.assignment0.token.Token;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class StatementsNode implements INode{
	
	private AssignNode assign;
	private StatementsNode statements;
	
	public StatementsNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		
		if(!tokenizer.current().token().equals(Token.RIGHT_CURLY)) {
			assign = new AssignNode(tokenizer);
			statements = new StatementsNode(tokenizer);
		}
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append("StatementsNode\n");
		
		tabs++;
		
		if(assign != null) {
			assign.buildString(builder, tabs);
			statements.buildString(builder, tabs);
		} 
	}
}
