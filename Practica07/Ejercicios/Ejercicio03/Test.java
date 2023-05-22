package Ejercicio03;

public class Test {
    public static void main(String[] args) {
        PriorityQueueLinked<String, Integer> queue = new PriorityQueueLinked<>(4);
        try {
            queue.enqueue("Manzana", 2);
            queue.enqueue("Banana", 3);
            queue.enqueue("Naranja", 1);
            queue.enqueue("Melocotón", 4);

            System.out.println(queue.toString());
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}
