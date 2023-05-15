package Ejercicio04;

public class StackArray<E> implements Stack<E> {
	private E[] array;
	private int tope;

	public StackArray(int n) {
		this.array = (E[]) new Object[n];
		tope = -1;
	}

	public void push(E x) throws ExceptionIsFull {
		if (isFull()) {
		    throw new ExceptionIsFull();
		}
		tope++;
		array[tope] = x;
	}

	public E pop() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty();
		}
		E elem = array[tope];
		array[tope] = null; 
		tope--;
		return elem;
	}


	public E top() throws ExceptionIsEmpty {
		if (isEmpty()) {
		    throw new ExceptionIsEmpty();
		}
		return array[tope];
	}


	public boolean isEmpty() {
		return this.tope == -1;
	}

	public boolean isFull() {
		
		return tope == array.length - 1;
	}


	public String toString() {
		  if (isEmpty()) {
		    return "[]";
		  } else {
		    StringBuilder sb = new StringBuilder();
		    sb.append("Pila [");
		    for (int i = 0; i <= tope; i++) {
		      sb.append(array[i]);
		      if (i != tope) {
		        sb.append(", ");
		      }
		    }
		    sb.append("]");
		    return sb.toString();
		  }
		}
}

