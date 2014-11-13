package prop.seminar1;

import java.io.IOException;

public class Tokenizer implements ITokenizer{
	private Scanner scanner = new Scanner();
	
	/**
	 * Opens a file for tokenizing.
	 */
	public void open(String fileName) throws IOException, TokenizerException {
		scanner.open(fileName);
	}
	
	public char showCurrent() {
		return scanner.current();
	}
	
	public Lexeme current() throws IOException, TokenizerException {
		
		StringBuilder build = new StringBuilder();
		if(scanner.current() == '.') {
			build.append(scanner.current());
			String word = build.toString();
			moveNext();
			moveNext();
			return new Lexeme(word, Token.EOS);
		}
		
		while(scanner.current() != ' ' && scanner.current() != Scanner.EOF && scanner.current() != '.') {
			build.append(scanner.current());
			moveNext();
		}
		
		String word = build.toString();

		if(word.equals("a") || word.equals("the")) {
			return new Lexeme(word, Token.DETERMINER);
			
		} else if(word.equals("cat") || word.equals("mouse") ||
				word.equals("cats") || word.equals("mice")) {
			
			return new Lexeme(word, Token.NOUN);
			
		}  else if(word.equals("scares") || word.equals("hates") ||
				word.equals("scare") || word.equals("hate")) {
			
			return new Lexeme(word, Token.VERB);
		}

		return null;
	}

	/**
	 * Moves current to the next token in the stream.
	 */
	public void moveNext() throws IOException, TokenizerException {
		scanner.moveNext();
		
	}

	/**
	 * Closes the file and releases any system resources associated with it.
	 */
	public void close() throws IOException {
		scanner.close();
	}
}