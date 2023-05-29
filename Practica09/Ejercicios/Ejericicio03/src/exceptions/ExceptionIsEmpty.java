package exceptions;

public class ExceptionIsEmpty extends Exception{
	public ExceptionIsEmpty() {
		super();
	}
	
	public ExceptionIsEmpty(String args) {
		super(args);
	}
}