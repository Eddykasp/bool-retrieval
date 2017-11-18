package query;

public class AtomicExpression<T extends BooleanOperable> extends Expression {
	
	private T atom;
	
	public AtomicExpression(T atom) {
		this.atom = atom;
	}
	
	public T evaluate() {
		return atom;
	}
	
	public String toString() {
		return atom.toString();
	}

}
