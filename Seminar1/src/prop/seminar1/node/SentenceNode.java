package prop.seminar1.node;

import java.io.IOException;

import prop.seminar1.lexeme.Lexeme;
import prop.seminar1.token.Tokenizer;
import prop.seminar1.token.TokenizerException;

public class SentenceNode implements INode{

	private NounPhraseNode nounPhrase;
	private VerbPhraseNode verbPhrase;
	private Lexeme endOfSentence;
	
	public SentenceNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		nounPhrase = new NounPhraseNode(tokenizer);
		verbPhrase = new VerbPhraseNode(tokenizer, nounPhrase.isPlural());
		endOfSentence = tokenizer.current();
		tokenizer.moveNext();
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
		
		builder.append("SENTENCE\r\n");
		
		tabs++;
		nounPhrase.buildString(builder, tabs);
		verbPhrase.buildString(builder, tabs);
		
		for(int i = 0; i < tabs ; i++) {
			builder.append("\t");
		}
		
		builder.append("END OF SENTENCE\r\n");
		
		tabs++;
		for(int i = 0; i < tabs ; i++) {
			builder.append("\t");
		}
		
		builder.append(endOfSentence + "\r\n");
		
	}

}
