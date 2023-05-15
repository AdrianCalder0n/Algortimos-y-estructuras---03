package actividad2;

import exceptions.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
	private Node<E> first;
	private Node<E> last;
	
	public QueueLink() {
		this.first = null;
		this.last = null;
	}
	public void enqueue(E x) {
		Node<E> aux = new Node<E>(x);
		if (isEmpty()) {
			this.first = aux;
		}
		else {
			this.last.setNext(aux);
		}
		this.last = aux;
	}
	//precondition: Queue is not empty
	public E dequeue() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Queue is empty...");
		}
		else {
			E aux = this.first.getData();
			this.first = this.first.getNext();
			return aux;
		}
	}
	//precondition: Queue is not empty
	public E front() throws ExceptionIsEmpty {
		if (isEmpty())
			throw new ExceptionIsEmpty("Queue is empty...");
		return this.first.getData();
	}
	//precondition: Queue is not empty
	public E back() throws ExceptionIsEmpty { 
		if (isEmpty())
			throw new ExceptionIsEmpty("Queue is empty...");
		return this.last.getData();
	}
	public boolean isEmpty() {
		return this.first == null;
	}
	@Override
	public String toString() {
		String str = "";
		for (Node <E> aux = this.first; aux != null; aux = aux.getNext()) {
			str += aux.toString() + ",";
		}
		return str;
	}
}
