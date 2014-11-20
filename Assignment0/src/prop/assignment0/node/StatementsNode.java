package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class StatementsNode implements INode{
	
	private AssignNode assign;
	private StatementsNode statements;
	
	public StatementsNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		
		if(tokenizer.peek() != '}') {
			assign = new AssignNode(tokenizer);
			statements = new StatementsNode(tokenizer);
		}
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		if(assign != null) {

			Object[] temp = new Object[args.length + 1];

			int i;
			for (i = 0; i < args.length; i++) {
				temp[i] = args[i];
			}

			temp[i] = assign;

			return "" + assign.evaluate(temp) + statements.evaluate(temp);
		}
		
		return "";
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
