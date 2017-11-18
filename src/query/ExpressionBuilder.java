package query;

public class ExpressionBuilder<T extends BooleanOperable> {
	
	private Expression<T> currentExpression;
	
	public Expression<T> getExpression() {
		return currentExpression;
	}
	
	/**
	 * Appends an operator and operand to the overall expression.
	 * Expressions built using this method will end up having the following structure:
	 * (((A OP B) OP C) OP D)
	 * @param operator
	 * @param operand
	 */
	public void append(Operator<T> operator, T operand) {
		if(currentExpression == null) {
			currentExpression = new AtomicExpression<T>(operand);
		} else {
			currentExpression = new Expression<T>(currentExpression, new AtomicExpression<T>(operand), operator);
		}
	}

}
