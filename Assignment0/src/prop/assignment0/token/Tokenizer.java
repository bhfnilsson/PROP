package prop.assignment0.token;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.scanner.Scanner;

public class Tokenizer implements ITokenizer{

	private Scanner scanner = new Scanner();
	
	private char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
	private char[] letters = {'a','b','c','d','e','f','g','h','i','j',
	                          'k','l','m','n','o','p','q','r','s','t','u',
	                          'v','w','x','y','z'};
	private Map<Character, Token> symbols = new HashMap<Character, Token>();
	
	public Tokenizer() {
		symbols.put('+', Token.ADD_OP);
		symbols.put('-', Token.SUB_OP);
		symbols.put('/', Token.DIV_OP);
		symbols.put('*', Token.MULT_OP);
		symbols.put('(', Token.LEFT_PAREN);
		symbols.put(')', Token.RIGHT_PAREN);
		symbols.put('=', Token.ASSIGN_OP);
		symbols.put(';', Token.SEMICOLON);
		symbols.put('{', Token.LEFT_CURLY);
		symbols.put('}', Token.RIGHT_CURLY);
//		symbols.put('\r', Token.SEMICOLON);
//		symbols.put('\n', Token.SEMICOLON);
	}
	
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		scanner.open(fileName);
		
	}

	@Override
	public Lexeme current() throws IOException, TokenizerException {
		
		char current = scanner.current();
		if(current == Scanner.EOF) {
			return new Lexeme(current, Token.EOF);
		}
		
		for (int i = 0; i < letters.length; i++) {
			if(current == letters[i]) {
				return new Lexeme(current, Token.IDENT);
			}
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if(current == numbers[i]) {
				return new Lexeme(current, Token.INT_LIT);
			}
		}
		
//		builder = new StringBuilder();
//		
//		if(buildCharacterSet(builder, current, numbers)) {
//			scanner.moveNext();
//			while(buildCharacterSet(builder, scanner.current(), numbers)){
//				scanner.moveNext();
//			}
//			return new Lexeme(Double.parseDouble(builder.toString()), Token.INT_LIT);
//		}
		
//		StringBuilder builder = new StringBuilder();
//		
//		if(buildCharacterSet(builder, current, letters)) {
//			scanner.moveNext();
//			while(buildCharacterSet(builder, scanner.current(), letters)){
//				scanner.moveNext();
//			}
//			return new Lexeme(builder.toString(), Token.IDENT);
//		}
		
		for(Map.Entry<Character, Token> symbol : symbols.entrySet()) {
			if(current == symbol.getKey()) {
				return new Lexeme(symbol.getKey(), symbol.getValue());
			}
		}
		
		return null;
	}
	
	private boolean buildCharacterSet(StringBuilder builder, char current, char[] list) throws IOException {
		
		for (int i = 0; i < list.length; i++) {
			if(current == list[i]) {
				builder.append(current);
				return true;
			}
		}
		return false;
	}

	@Override
	public void moveNext() throws IOException, TokenizerException {

		do {
			scanner.moveNext();
		} while(scanner.current() == ' ' || scanner.current() == '\r' || scanner.current() == '\n');
	}
	
	@Override
	public void close() throws IOException {
		scanner.close();
		
	}

}
