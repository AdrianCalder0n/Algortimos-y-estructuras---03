package Actividades;

public class Test {
    public static void main(String[] args) {
        // Prueba con BST de enteros
        BSTree<Integer> bstInt = new BSTree<>();
        try {
            bstInt.insert(5);
            bstInt.insert(3);
            bstInt.insert(8);
            bstInt.insert(1);
            bstInt.insert(4);
            bstInt.insert(7);
            bstInt.insert(9);

            System.out.println("BST de enteros:");
            System.out.println("InOrden: " + bstInt.toString());
            System.out.println("Buscar : " + bstInt.search(7));
            System.out.println("Buscar 10: " + bstInt.search(10));

            bstInt.remove(5);
            bstInt.remove(9);

            System.out.println("InOrden después de eliminar 5 y 9: " + bstInt.toString());
        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar elemento duplicado: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.out.println("Error al buscar/eliminar elemento no encontrado: " + e.getMessage());
        }
        
        System.out.println();
        
        // Prueba con BST de cadenas
        BSTree<String> bstString = new BSTree<>();
        try {
            bstString.insert("banana");
            bstString.insert("apple");
            bstString.insert("orange");
            bstString.insert("grape");
            bstString.insert("cherry");
            bstString.insert("mango");

            System.out.println("BST de cadenas:");
            System.out.println("InOrden: " + bstString.toString());
            System.out.println("Buscar 'orange': " + bstString.search("orange"));
            System.out.println("Buscar 'watermelon': " + bstString.search("watermelon"));

            bstString.remove("banana");
            bstString.remove("grape");

            System.out.println("InOrden después de eliminar 'banana' y 'grape': " + bstString.toString());
        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar elemento duplicado: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.out.println("Error al buscar/eliminar elemento no encontrado: " + e.getMessage());
        }
    }
}

