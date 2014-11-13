package prop.seminar1.node;

import java.io.IOException;

import prop.seminar1.Lexeme;
import prop.seminar1.Tokenizer;
import prop.seminar1.TokenizerException;

public class NounPhraseNode implements INode{

	private Lexeme determiner;
	private Lexeme noun;
	private boolean plural = false;
	
	public NounPhraseNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		determiner = tokenizer.current();
		tokenizer.moveNext();
		noun = tokenizer.current();
		if(noun.value().equals("cats") || noun.value().equals("mice")) {
			plural = true;
		} 
	}
	
	public boolean isPlural() {
		return plural;
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
		for(int i = 0; i < tabs ; i++) {
			builder.append("\t");
		}
		
		builder.append("NOUN PHRASE\r\n");
		
		tabs++;
		
		for(int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append(determiner + "\r\n");
		
		for(int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append(noun + "\r\n");
	}

}
