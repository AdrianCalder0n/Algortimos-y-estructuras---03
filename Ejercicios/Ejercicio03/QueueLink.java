package Ejercicio03;

public class QueueLink<E> implements Queue<E> {
	private Node<E> primero;
	private Node<E> ultimo;

	public QueueLink() {
		this.primero = null;
		this.ultimo = null;
	}
	
	public void enqueue(E x) {
		Node<E> aux = new Node<E>(x);
		if (this.isEmpty()) {
			this.primero = aux;
		}
		else
			this.ultimo.setNext(aux);
		this.ultimo = aux;
	}

	public E dequeue() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    E removedValue = primero.getData();
	    primero = primero.getNext();
	    if (primero == null) {
	        ultimo = null;
	    }
	    return removedValue;
	}


	public E front() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    return primero.getData();
	}

	public E back() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    return ultimo.getData();
	}

	public boolean isEmpty() {
		return (primero == null);
	}

	public String toString() {
	    if (isEmpty()) {
	        return "[]";
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    Node<E> current = primero;
	    while (current != null) {
	        sb.append(current.getData());
	        if (current.getNext() != null) {
	            sb.append(", ");
	        }
	        current = current.getNext();
	    }
	    sb.append("]");
	    return sb.toString();
	}

	public Node<E> getPrimero() {
		return primero;
	}

	public void setPrimero(Node<E> primero) {
		this.primero = primero;
	}

	public Node<E> getUltimo() {
		return ultimo;
	}

	public void setUltimo(Node<E> ultimo) {
		this.ultimo = ultimo;
	}
}