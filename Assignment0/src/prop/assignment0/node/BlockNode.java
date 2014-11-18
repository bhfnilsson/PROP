package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class BlockNode implements INode{

	private Lexeme leftCurly;
	private Lexeme rightCurly;
	private StatementsNode statements;
	
	public BlockNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		leftCurly = tokenizer.current();
		tokenizer.moveNext();
		statements = new StatementsNode(tokenizer);
		
		rightCurly = tokenizer.current();
		tokenizer.moveNext();
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
		builder.append("BlockNode\n");
		
		builder.append(leftCurly + "\n");
		
		tabs++;
		
		statements.buildString(builder, tabs);
		
		builder.append(rightCurly + "\n");
		
	}

}
