package Ejercicio01;

public class StackLink<E> implements Stack<E> {

    private Node<E> top;
    private int size;

    public StackLink() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x, top); // Crea un nuevo nodo con el elemento a agregar y lo enlaza con el nodo anterior en la cima del stack
        top = newNode; // Actualiza la referencia al nodo en la cima del stack para que apunte al nuevo nodo agregado
        size++; // Incrementa el contador de elementos en el stack
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) { // Verifica si el stack está vacío
            throw new ExceptionIsEmpty("Stack is empty."); // Lanza una excepción personalizada si el stack está vacío
        }
        E data = top.getData(); // Obtiene el elemento en la cima del stack
        top = top.getNext(); // Actualiza la referencia al nodo en la cima del stack para que apunte al siguiente nodo en la lista enlazada
        size--; // Decrementa el contador de elementos en el stack
        return data; // Retorna el elemento eliminado del stack
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) { // Verifica si el stack está vacío
            throw new ExceptionIsEmpty("Stack is empty."); // Lanza una excepción personalizada si el stack está vacío
        }
        return top.getData(); // Retorna el elemento en la cima del stack sin eliminarlo
    }

    @Override
    public boolean isEmpty() {
        return (top == null); // Retorna true si el stack está vacío (es decir, si la referencia a la cima del stack es null)
    }

}
