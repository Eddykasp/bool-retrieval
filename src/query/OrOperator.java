package query;

public class OrOperator<T extends BooleanOperable> implements Operator<T> {

	@Override
	public T evaluate(T operandA, T operandB) {
		return (T) operandA.booleanOr(operandB);
	}
	
	@Override
	public String toString() {
		return "OR";
	}

}
