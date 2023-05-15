package Ejercicio04;

public class StackList<E> implements Stack<E> {
	private Node<E> array;
	private int tope;
	private int cant;
	

	public StackList(int n) {
		this.array = null;
		this.tope = n;
		this.cant = 0;
		
	}

	@Override
	public void push(E x) throws ExceptionIsFull {
		if(cant < tope) {
			Node<E> newNode = new Node<E>(x, this.array);
			this.array = newNode;
			this.cant++;
		}
		else {
			throw new ExceptionIsFull(); 
		}
	}

	@Override
	public E pop() throws ExceptionIsEmpty {
		if (isEmpty())
			throw new ExceptionIsEmpty();
		E aux = this.array.getData();
		this.array = this.array.getNext();
		this.cant--;
		return aux;
	}

	@Override
	public E top() throws ExceptionIsEmpty {
		if (isEmpty())
			throw new ExceptionIsEmpty();
		return this.array.getData();
	}

	@Override
	public boolean isEmpty() {
		return (this.array == null);
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    Node<E> current = array;
	    while (current != null) {
	        sb.append(current.getData().toString()).append(" ");
	        current = current.getNext();
	    }
	    return sb.toString();
	}


}
