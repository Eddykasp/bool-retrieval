package query;

public interface BooleanOperable {
	
	public BooleanOperable booleanAnd(BooleanOperable operandB);
	public BooleanOperable booleanOr(BooleanOperable operandB);
	public BooleanOperable booleanAndNot(BooleanOperable operandB);

}
