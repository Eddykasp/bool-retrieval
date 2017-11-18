package query;

public class Expression<T extends BooleanOperable> {
	
	private Expression<T> leftOperand;
	private Expression<T> rightOperand;
	private Operator<T> operator;
	
	protected Expression() {
		
	}
	
	public Expression(Expression<T> leftOperand, Expression<T> rightOperand, Operator<T> operator) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
	}
	
	public T evaluate() {
		return operator.evaluate(leftOperand.evaluate(), rightOperand.evaluate());
	}
	
	public String toString() {
		return new String("(" + leftOperand.toString() + " " + operator.toString() + " " + rightOperand.toString() + ")");
	}

}
