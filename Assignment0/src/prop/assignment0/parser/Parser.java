package prop.assignment0.parser;

import java.io.IOException;

import prop.assignment0.node.AssignNode;
import prop.assignment0.node.INode;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class Parser implements IParser{

	private Tokenizer tokenizer = new Tokenizer();
	
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		tokenizer.open(fileName);
		
	}

	@Override
	public INode parse() throws IOException, TokenizerException,
			ParserException {
		
		tokenizer.moveNext();
		return new AssignNode(tokenizer);
	}

	@Override
	public void close() throws IOException {
		tokenizer.close();
	}

}
