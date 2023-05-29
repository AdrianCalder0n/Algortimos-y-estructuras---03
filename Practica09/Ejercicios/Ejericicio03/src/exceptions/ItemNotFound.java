package exceptions;

public class ItemNotFound extends Exception{
	public ItemNotFound() {
		super();
	}
	
	public ItemNotFound(String args) {
		super(args);
	}
}