package prop.seminar1.node;

import java.io.IOException;

import prop.seminar1.Lexeme;
import prop.seminar1.Tokenizer;
import prop.seminar1.TokenizerException;

public class VerbPhraseNode implements INode{

	private Lexeme verb;
	private NounPhraseNode nounPhrase;
	
	public VerbPhraseNode(Tokenizer tokenizer, boolean plural) throws IOException, TokenizerException {
		tokenizer.moveNext();
		verb = tokenizer.current();
		if(((verb.value().equals("scares") || verb.value().equals("hates")) && plural) ||
			(verb.value().equals("scare") || verb.value().equals("hate")) && !plural) {
			throw new IllegalArgumentException("Verb and noun needs to be of same number category");
		}
		
		tokenizer.moveNext();
		nounPhrase = new NounPhraseNode(tokenizer);
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
		for(int i = 0; i < tabs ; i++) {
			builder.append("\t");
		}
		
		builder.append("VERB PHRASE\r\n");

		for(int i = 0; i < tabs + 1 ; i++) {
			builder.append("\t");
		}
		
		builder.append(verb + "\r\n");
		nounPhrase.buildString(builder, ++tabs);
	}

}
