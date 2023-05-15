
package Ejercicio02;

import exceptions.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int max_size;
    private int size;
    private int first;
    private int last;

    @SuppressWarnings("unchecked")
    public QueueArray(int max_size) {
        this.max_size = max_size;
        this.size = 0;
        this.first = 0;
        this.last = 0;
        this.array = (E[]) new Object[max_size];
    }

    public void enqueue(E x) {
        if (size == max_size) {
            throw new IllegalStateException("La cola esta llena.");
        }
        array[last] = x;
        last = (last + 1) % max_size;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta vacia.");
        }
        E x = array[first];
        array[first] = null;
        first = (first + 1) % max_size;
        size--;
        return x;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta vacia.");
        }
        return array[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta vacia.");
        }
        return array[(last - 1 + max_size) % max_size];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
