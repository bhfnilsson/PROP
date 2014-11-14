package prop.seminar1.node;

import java.io.IOException;

import prop.seminar1.lexeme.Lexeme;
import prop.seminar1.token.Token;
import prop.seminar1.token.Tokenizer;
import prop.seminar1.token.TokenizerException;

public class NounPhraseNode implements INode{

	private Lexeme determiner;
	private Lexeme noun;
	private Lexeme nounPhrase;
	private boolean plural = false;
	
	public NounPhraseNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		determiner = tokenizer.current();
		tokenizer.moveNext();
		noun = tokenizer.current();
		tokenizer.moveNext();
		if(noun.value().equals("cats") || noun.value().equals("mice")) {
			plural = true;
			if(!determiner.value().equals("the")) {
				throw new IllegalArgumentException("Verb and noun needs to be of same number category");
			}
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
		
		builder.append("NOUN PHRASE\n");
		
		tabs++;
		
		for(int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append(determiner + "\n");
		
		for(int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append(noun + "\n");
	}

	@Override
	public void translate(StringBuilder builder, int tabs) {
		
		for(int i = 0; i < tabs ; i++) {
			builder.append("\t");
		}
		
		builder.append("NOUN PHRASE\n");
		
		tabs++;
		
		if(determiner.value().equals("a")) {
			determiner = new Lexeme("en", Token.DETERMINER);
			
			if(noun.value().equals("cat")) {
				noun = new Lexeme("katt", Token.NOUN);
				
			} else if(noun.value().equals("mouse")) {
				noun = new Lexeme("mus", Token.NOUN);
			}
			
			for(int i = 0; i < tabs; i++) {
				builder.append("\t");
			}
			
			builder.append(determiner + "\n");
			
			for(int i = 0; i < tabs; i++) {
				builder.append("\t");
			}
			
			builder.append(noun + "\n");
			
		} else {
			if(determiner.value().equals("the") && plural) {
				
				if(noun.value().equals("cats")) {
					nounPhrase = new Lexeme("katterna", Token.NOUNPHRASE);
					
				} else if(noun.value().equals("mice")) {
					nounPhrase = new Lexeme("mössen", Token.NOUNPHRASE);
				}
			} else if(determiner.value().equals("the") && !plural) {
				
				if(noun.value().equals("cat")) {
					nounPhrase = new Lexeme("katten", Token.NOUNPHRASE);
					
				} else if(noun.value().equals("mouse")) {
					nounPhrase = new Lexeme("musen", Token.NOUNPHRASE);
				}
			}
			
			for(int i = 0; i < tabs; i++) {
				builder.append("\t");
			}
			
			builder.append(nounPhrase + "\n");
		}
	}
}
