package query;

public class AndOperator<T extends BooleanOperable> implements Operator<T> {

	@Override
	public T evaluate(T operandA, T operandB) {
		return (T) operandA.booleanAnd(operandB);
	}

}
