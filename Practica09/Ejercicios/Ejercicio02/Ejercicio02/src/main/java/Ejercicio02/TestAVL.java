package Ejercicio02;

public class TestAVL {
    public static void main(String[] args) throws ItemDuplicated, ItemNotFound {
        AVLTree<Integer> avlTree = new AVLTree<>();
        AVLTree<Integer> avlTree2 = new AVLTree<>();
        AVLTree<Integer> avlTree3 = new AVLTree<>();
        AVLTree<Integer> avlTree5 = new AVLTree<>();
        AVLTree<Integer> avlTree6 = new AVLTree<>();
        AVLTree<Integer> avlTree7 = new AVLTree<>();
        AVLTree<Integer> avlTree8 = new AVLTree<>();

        try {
            // Caso 1: Inserción de elementos en orden ascendente
            avlTree.insert(1);
            avlTree.insert(2);
            avlTree.insert(3);
            avlTree.insert(4);
            avlTree.insert(5);
            avlTree.insert(6);
            avlTree.insert(7);
            avlTree.insert(8);
            System.out.println("AVL Tree 1:");
            System.out.println(avlTree);

            // Caso 2: Inserción de elementos en orden descendente
            avlTree2.insert(8);
            avlTree2.insert(7);
            avlTree2.insert(6);
            avlTree2.insert(5);
            avlTree2.insert(4);
            avlTree2.insert(3);
            avlTree2.insert(2);
            avlTree2.insert(1);
            System.out.println("AVL Tree 2:");
            System.out.println(avlTree2);

            // Caso 3: Inserción de elementos en orden mixto
            avlTree3.insert(5);
            avlTree3.insert(3);
            avlTree3.insert(7);
            avlTree3.insert(2);
            avlTree3.insert(4);
            avlTree3.insert(6);
            avlTree3.insert(1);
            avlTree3.insert(8);
            System.out.println("AVL Tree 3:");
            System.out.println(avlTree3);

            // Caso 4: Inserción de elementos duplicados
            try {
                avlTree3.insert(5);
            } catch (ItemDuplicated e) {
                System.out.println(e.getMessage());
            }

            // Caso 5: Inserción de elementos que requieren RSR
            avlTree5.insert(5);
            avlTree5.insert(3);
            avlTree5.insert(7);
            avlTree5.insert(2);
            avlTree5.insert(4);
            avlTree5.insert(1);
            avlTree5.insert(6);
            avlTree5.insert(8);
            System.out.println("AVL Tree 5:");
            System.out.println(avlTree5);

            // Caso 6: Inserción de elementos que requieren RSL
            avlTree6.insert(5);
            avlTree6.insert(2);
            avlTree6.insert(7);
            avlTree6.insert(1);
            avlTree6.insert(4);
            avlTree6.insert(3);
            avlTree6.insert(6);
            avlTree6.insert(8);
            System.out.println("AVL Tree 6:");
            System.out.println(avlTree6);

            // Caso 7: Inserción de elementos que requieren RDR
            avlTree7.insert(6);
            avlTree7.insert(4);
            avlTree7.insert(8);
            avlTree7.insert(2);
            avlTree7.insert(5);
            avlTree7.insert(3);
            avlTree7.insert(7);
            avlTree7.insert(1);
            System.out.println("AVL Tree 7:");
            System.out.println(avlTree7);

            // Caso 8: Inserción de elementos que requieren RDL
            avlTree8.insert(4);
            avlTree8.insert(2);
            avlTree8.insert(7);
            avlTree8.insert(1);
            avlTree8.insert(3);
            avlTree8.insert(6);
            avlTree8.insert(5);
            avlTree8.insert(8);
            System.out.println("AVL Tree 8:");
            System.out.println(avlTree8);

            // Ejercicio 2
            
            // Caso 9: Eliminar un elemento existente
            avlTree.remove(6);
            System.out.println("AVL Tree 1 (después de eliminar 6):");
            System.out.println(avlTree);

            // Caso 10: Eliminar un elemento inexistente
            try {
                avlTree.remove(9);
            } catch (ItemNotFound e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
