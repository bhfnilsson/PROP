package prop.seminar1;

import java.io.IOException;

import prop.seminar1.node.INode;
import prop.seminar1.node.TextNode;

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
		return new TextNode(tokenizer);
	}

	@Override
	public void close() throws IOException {
		tokenizer.close();
		
	}
}
