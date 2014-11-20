package prop.assignment0.node;

import java.io.IOException;
import java.math.BigDecimal;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class AssignNode implements INode{

	private Lexeme id;
	private double value;
	private Lexeme assignOperator;
	private ExpressionNode expression;
	private Lexeme semicolon;
	
	public AssignNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		
		id = tokenizer.current();
		tokenizer.moveNext();
		
		assignOperator = tokenizer.current();
		tokenizer.moveNext();
		
		expression = new ExpressionNode(tokenizer);
		
		semicolon = tokenizer.current();
		tokenizer.moveNext();
	}
	
	public Lexeme getId() {
		return id;
	}
	
	public double getValue() {
		return value;
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		value = (double) expression.evaluate(args);

		BigDecimal doubleValue = new BigDecimal(value);  
	    doubleValue = doubleValue.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		return "" + id.value() + " " + assignOperator.value() + " " + doubleValue.doubleValue() + "\n";
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append("AssignmentNode\n");
		
		tabs++;
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append(id + "\n");
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}

		builder.append(assignOperator + "\n");
		
		expression.buildString(builder, tabs);
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}

		builder.append(semicolon + "\n");
	}
}
