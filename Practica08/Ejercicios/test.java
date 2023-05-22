package Ejercicios;

public class test {
    public static void main(String[] args) {
    // Ejemplo de uso con enteros
        BSTree<Integer> intTree = new BSTree<>();
        
        try {
            intTree.insert(50);
            intTree.insert(30);
            intTree.insert(20);
            intTree.insert(40);
            intTree.insert(70);
            intTree.insert(60);
            intTree.insert(80);
            
            System.out.println("Inorder traversal of the BST (Integers):");
            intTree.inOrden();
            
            int searchKey = 40;
            Integer foundInt = intTree.search(searchKey);
            if (foundInt != null) {
                System.out.println("Found " + searchKey + " in the BST.");
            } else {
                System.out.println(searchKey + " not found in the BST.");
            }
            
            int removeKey = 30;
            Integer searchResult = intTree.search(removeKey);
            if (searchResult != null) {
                System.out.println("Found " + removeKey + " in the BST.");
                intTree.remove(removeKey);
                System.out.println("Inorder traversal after removing " + removeKey + ":");
                intTree.inOrden();
            } else {
                System.out.println(removeKey + " not found in the BST.");
            }
            
            
            
            
            System.out.println("BST (Integers) as a string: " + intTree.toString());
        } catch (ItemDuplicated e) {
            System.out.println("Duplicate item found: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.out.println("Item not found: " + e.getMessage());
        }
        
        System.out.println("-----------------------");
        
        // Ejemplo de uso con cadenas de texto
        BSTree<String> stringTree = new BSTree<>();
        
        try {
            stringTree.insert("apple");
            stringTree.insert("banana");
            stringTree.insert("cherry");
            stringTree.insert("date");
            
            System.out.println("Inorder traversal of the BST (Strings):");
            stringTree.inOrden();
            
            String searchString = "banana";
            String foundString = stringTree.search(searchString);
            if (foundString != null) {
                System.out.println("Found " + searchString + " in the BST.");
            } else {
                System.out.println(searchString + " not found in the BST.");
            }
            
            String removeString = "cherry";
            stringTree.remove(removeString);
            System.out.println("Inorder traversal after removing " + removeString + ":");
            stringTree.inOrden();
            
            System.out.println("BST (Strings) as a string: " + stringTree.toString());
        } catch (ItemDuplicated e) {
            System.out.println("Duplicate item found: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.out.println("Item not found: " + e.getMessage());
        }
        
        /////////////////////////////////////////////////////////////////////////
        //ejercicio test 05
        
        // Crear los dos árboles binarios diferentes
        BSTree<Integer> tree1 = new BSTree<>();
        BSTree<Integer> tree2 = new BSTree<>();

        // Insertar elementos en los árboles (omitido para mayor claridad)

        // Verificar si los dos árboles tienen la misma área
        boolean sameArea = haveSameArea(tree1, tree2);

        if (sameArea) {
            System.out.println("Los dos árboles tienen la misma área.");
        } else {
            System.out.println("Los dos árboles no tienen la misma área.");
            }
    }

        public static <E extends Comparable<E>> boolean haveSameArea(BSTree<E> tree1, BSTree<E> tree2) {
            int area1 = tree1.calculateArea();
            int area2 = tree2.calculateArea();

            return area1 == area2;
        }

}
