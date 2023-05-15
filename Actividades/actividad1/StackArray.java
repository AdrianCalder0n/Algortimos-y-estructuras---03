package actividad1;
import exceptions.ExceptionIsEmpty;

public class StackArray<E> implements Stack<E> {
	private E[] array;
	private int tope;
	public StackArray(int n) {
		this.array = (E[]) new Object[n];
		this.tope = -1;
	}
	
	public void push(E x) {
		if (!isFull()) {
			this.array[++this.tope] = x;
		}
		else {
			System.out.println("There is not space...");
		}
	}
	//precondition: stack is not empty
	public E pop() throws ExceptionIsEmpty{
		if (isEmpty()) 
			throw new ExceptionIsEmpty("Stack is empty ...");
		E temp = this.array[this.tope--];
		return temp;
	}
	//precondition: stack is not empty
	public E top() throws ExceptionIsEmpty {
		if (isEmpty()) 
			throw new ExceptionIsEmpty("Stack is empty ...");
		return this.array[this.tope];
		
	}
	public boolean isEmpty() {
		return this.tope == -1;
	}
	public boolean isFull() {
		return this.tope == this.array.length-1;
	}
	
	public String toString() {
		String str = "";
		for (int i = tope; i >= 0; i--)
			str += this.array[i] + ", ";
		return str;
	}
}
