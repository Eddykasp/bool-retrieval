package query;

public interface Operator<T extends BooleanOperable> {
	
	public T evaluate(T booleanOperable, T booleanOperable2);

}
