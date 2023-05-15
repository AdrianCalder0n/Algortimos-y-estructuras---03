package Ejercicio01;

public class Test {

    public static void main(String[] args) {
        
        Stack<Integer> stackInt = new StackLink<>();
        Stack<String> stackString = new StackLink<>();
        
        // Agrega elementos a los stacks
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        
        stackString.push("Hola");
        stackString.push("Mundo");
        
        // Obtiene el elemento en la cima del stack sin eliminarlo
        try {
            System.out.println(stackInt.top()); // Debería imprimir "3"
            System.out.println(stackString.top()); // Debería imprimir "Mundo"
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        
        // Elimina el elemento en la cima del stack y lo retorna
        try {
            System.out.println(stackInt.pop()); // Debería imprimir "3"
            System.out.println(stackString.pop()); // Debería imprimir "Mundo"
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        
        // Verifica si el stack está vacío
        System.out.println(stackInt.isEmpty()); // Debería imprimir "false"
        System.out.println(stackString.isEmpty()); // Debería imprimir "false"
        
        // Verifica si el stack está vacío nuevamente
        System.out.println(stackInt.isEmpty()); // Debería imprimir "true"
        System.out.println(stackString.isEmpty()); // Debería imprimir "true"
        
    }

}