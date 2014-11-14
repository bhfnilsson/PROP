package prop.seminar1.node;

public interface INode {
	/**
	 * The argument array 'args' is only needed for the requirements for grade A and B.
	 * When not needed just call evaluate with null as the actual parameter.
	 */
	Object evaluate(Object[] args) throws Exception;
	
	/**
	 * ENG	determiner	a		a		the		the		the			the
	 * 		noun		cat		mouse	cat		mouse	cats		mice
	 * 
	 * SWE	determiner	en		en		katten	musen	katterna	mössen
	 *  	noun		katt	mus		katten	musen	katterna	mössen
	 */
	
	void translate(StringBuilder builder, int tabs);
	
	void buildString(StringBuilder builder, int tabs);
}