import java.util.Stack;

import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class BSTree<E extends Comparable<E>> {
    class Node {
        protected E data;
        protected Node left, right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    protected Node root;

    public BSTree() {
        this.root = null;
    }

    public void insert(E x) throws ItemDuplicated {
        root = insertRec(root, x);
    }

    private Node insertRec(Node node, E x) throws ItemDuplicated {
        if (node == null) {
            return new Node(x);
        }

        int cmp = x.compareTo(node.data);

        if (cmp < 0) {
            node.left = insertRec(node.left, x);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, x);
        } else {
            throw new ItemDuplicated("Item already exists in the BST.");
        }

        return node;
    }

    public E search(E x) throws ItemNotFound {
        Node result = searchRec(root, x);
        if (result == null) {
            throw new ItemNotFound("Item not found in the BST.");
        }
        return result.data;
    }

    private Node searchRec(Node node, E x) {
        if (node == null || x.equals(node.data)) {
            return node;
        }

        int cmp = x.compareTo(node.data);

        if (cmp < 0) {
            return searchRec(node.left, x);
        } else {
            return searchRec(node.right, x);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderToString(root, sb);
        return sb.toString();
    }

    private void inOrderToString(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        inOrderToString(node.left, sb);
        sb.append(node.data).append(" ");
        inOrderToString(node.right, sb);
    }

    public void remove(E x) throws ItemNotFound {
        root = removeRec(root, x);
    }

    private Node removeRec(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Item not found in the BST.");
        }

        int cmp = x.compareTo(node.data);

        if (cmp < 0) {
            node.left = removeRec(node.left, x);
        } else if (cmp > 0) {
            node.right = removeRec(node.right, x);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                E minValue = findMin(node.right);
                node.data = minValue;
                node.right = removeRec(node.right, minValue);
            }
        }

        return node;
    }

    private E findMin(Node node) {
        if (node.left == null) {
            return node.data;
        }

        return findMin(node.left);
    }

    public void inOrden() {
    }

    public void inOrden(Node actual) {
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    // Se ha agregado el método countNonLeafNodes, el cual utiliza un enfoque
    // recursivo para contar los nodos no hojas en el árbol BTS.
    // La función countNonLeafNodes se llama inicialmente en el nodo raíz del árbol
    // (root), y luego se realiza un recorrido recursivo para contar
    // los nodos no hojas en cada subárbol.
    // se ha agregado un método privado isLeaf para verificar si un nodo es una hoja
    // (es decir, si no tiene hijos).
    // se puede utilizar el método countNonLeafNodes en el código para obtener el
    // número de nodos no hojas en un árbol BTS.

    public int getNodeHeight(E x) {
        Node node = findNode(root, x);
        if (node == null) {
            return -1; // El nodo x no existe en el árbol
        }
        return calculateHeight(node);
    }

    private Node findNode(Node node, E x) {
        if (node == null || node.data.equals(x)) {
            return node;
        }

        if (x.compareTo(node.data) < 0) {
            return findNode(node.left, x);
        } else {
            return findNode(node.right, x);
        }
    }

    // Se ha agregado el método getNodeHeight, que acepta un elemento x y devuelve
    // la altura del nodo correspondiente en el árbol BTS.
    // El método utiliza un enfoque recursivo para encontrar el nodo x y luego
    // calcula la altura del nodo utilizando la función privada
    // getNodeHeight.

    // El método findNode se utiliza para encontrar el nodo correspondiente al
    // elemento x en el árbol BTS.
    // luego se llama al método getNodeHeight en ese nodo para calcular su altura.

    // Si el nodo x no existe en el árbol, el método getNodeHeight devuelve -1 como
    // indicador de que el nodo no se encuentra en el árbol.
    // Se puede utilizar el método getNodeHeight en el código para obtener la altura
    // de un nodo específico en el árbol BTS.

    public void preOrderIterative() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // Se ha agregado el método preOrderIterative que utiliza una pila (Stack) para
    // realizar el recorrido en preorden de manera iterativa.
    // El método comienza empujando el nodo raíz a la pila. Luego, mientras la pila
    // no esté vacía, se extrae un nodo de la pila
    // se muestra su valor y se empujan sus hijos derecho e izquierdo a la pila (en
    // ese orden).

    // El resultado es que los nodos se visitan en el orden de preorden, es decir,
    // se muestra el nodo actual
    // luego se visitan los hijos izquierdo y derecho.
    // Se puede utulizar al método preOrderIterative en el código para recorrer los
    // nodos de un árbol BTS en preorden de manera iterativa.

    public int calculateArea() {
        int leafCount = countLeaves(root);
        int treeHeight = calculateHeight(root);
        return leafCount * treeHeight;
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int leftLeaves = countLeaves(node.left);
        int rightLeaves = countLeaves(node.right);

        return leftLeaves + rightLeaves;
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    // Se ha agregado el método calculateArea que utiliza los métodos countLeaves y
    // calculateHeight para calcular el área de un árbol
    // binario de búsqueda. El método countLeaves cuenta el número de nodos hojas en
    // el árbol, y el método calculateHeight calcula
    // la altura del árbol. Luego, el área se calcula multiplicando el número de
    // nodos hojas por la altura del árbol.

    // El método countLeaves utiliza un enfoque recursivo para contar las hojas en
    // el árbol, mientras que el método calculateHeight
    // también utiliza un enfoque recursivo para calcular la altura del árbol.

    // se puede llamar al método calculateArea en el código para obtener el área del
    // árbol binario de búsqueda.

    public Node getMinNode() {
        if (root == null) {
            return null; // Si el árbol está vacío, no hay mínimo
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Se ha agregado el método getMinNode que devuelve el nodo con el valor más
    // bajo (mínimo) en un árbol binario de búsqueda.
    // El método recorre el árbol siguiendo los enlaces de los nodos izquierdos
    // hasta llegar al nodo más a la izquierda, que será el nodo
    // con el valor más bajo.

    // Se puede llamar al método getMinNode en el código para obtener el nodo con el
    // valor más bajo en el árbol binario de búsqueda.

    public Node getMaxNode() {
        if (root == null) {
            return null; // Si el árbol está vacío, no hay máximo
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    // Se ha agregado el método getMaxNode que devuelve el nodo con el valor más
    // alto (máximo) en un árbol binario de búsqueda.
    // El método recorre el árbol siguiendo los enlaces de los nodos derechos hasta
    // llegar al nodo más a la derecha,
    // que será el nodo con el valor más alto.

    // Se puede llamar al método getMaxNode en el código para obtener el nodo con el
    // valor más alto en el árbol binario de búsqueda.

    public void parenthesize() {
        parenthesize(root);
    }

    private void parenthesize(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print("(" + current.data);

            if (current.right != null) {
                stack.push(current.right);
                System.out.print(" ");
            }

            if (current.left != null) {
                stack.push(current.left);
                System.out.print(" ");
            }

            System.out.print(")");
        }

        System.out.println();
    }
}