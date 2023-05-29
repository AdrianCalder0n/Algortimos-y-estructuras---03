import exceptions.ItemDuplicated;

public class TestAVL {
    public static void main(String[] args) {
        BSTree<Integer> bstTree = new BSTree<>();
        AVLTree<Integer> avlTree2 = new AVLTree<>();

        AVLTree<Integer> avlTree8 = new AVLTree<>();

        try {/*
              * // Caso 1: bst
              * bstTree.insert(1);
              * bstTree.insert(2);
              * bstTree.insert(3);
              * bstTree.insert(4);
              * bstTree.insert(5);
              * 
              * System.out.println(bstTree);
              * System.out.println(bstTree.getNodeHeight(1));
              * 
              * // Caso 1: bst
              * avlTree2.insert(1);
              * avlTree2.insert(2);
              * avlTree2.insert(3);
              * avlTree2.insert(4);
              * avlTree2.insert(5);
              * 
              * System.out.println(avlTree2);
              * System.out.println(avlTree2.getNodeHeight(2));
              */

            // Caso 2: avl
            bstTree.insert(4);
            bstTree.insert(2);
            bstTree.insert(6);
            bstTree.insert(1);
            bstTree.insert(3);
            bstTree.insert(5);

            System.out.println(bstTree);
            System.out.println(bstTree.getNodeHeight(4));

            // Caso 2: avl
            avlTree2.insert(4);
            avlTree2.insert(2);
            avlTree2.insert(6);
            avlTree2.insert(1);
            avlTree2.insert(3);
            avlTree2.insert(5);

            System.out.println(avlTree2);
            System.out.println(avlTree2.getNodeHeight(2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
