
package Ejercicio02;

import exceptions.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> cola = new QueueArray<>(5);

        try {
            System.out.println("La cola esta vacia: " + cola.isEmpty()); // true

            cola.enqueue(1);
            cola.enqueue(2);
            cola.enqueue(3);
            cola.enqueue(4);
            cola.enqueue(5);

            System.out.println("El primer elemento de la cola es: " + cola.front()); // 1
            System.out.println("El ultimo elemento de la cola es: " + cola.back()); // 5

            System.out.println("Se saca de la cola: " + cola.dequeue()); // 1
            System.out.println("El primer elemento de la cola es: " + cola.front()); // 2

            cola.enqueue(6); // Esto deberia fallar ya que la cola esta llena
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: La cola esta vacia");
        }
    }
}
