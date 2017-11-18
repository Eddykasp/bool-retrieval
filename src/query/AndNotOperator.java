package query;

public class AndNotOperator<T extends BooleanOperable> implements Operator<T> {

	@Override
	public T evaluate(T operandA, T operandB) {
		return (T) operandA.booleanAndNot(operandB);
	}
	
	@Override
	public String toString() {
		return "ANDNOT";
	}

}
