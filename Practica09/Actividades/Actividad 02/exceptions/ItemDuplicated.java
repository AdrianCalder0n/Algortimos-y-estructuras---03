package exceptions;

public class ItemDuplicated extends Exception{
	public ItemDuplicated(String args) {
		super(args);
	}
	public ItemDuplicated() {
		super();
	}
}