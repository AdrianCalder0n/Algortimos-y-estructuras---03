package Ejercicios;

public class test2 {
    public static void main(String[] args) throws ItemDuplicated {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);

        System.out.println("Árbol binario de búsqueda:");
        tree.parenthesize();
    }
}
