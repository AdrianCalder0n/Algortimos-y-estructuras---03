package Ejercicio02;


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

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E x) throws ItemDuplicated {
        root = insert(root, x);
    }

    private Node insert(Node node, E x) throws ItemDuplicated {
        if (node == null) {
            node = new Node(x);
        } else if (x.compareTo(node.data) < 0) {
            node.left = insert(node.left, x);
        } else if (x.compareTo(node.data) > 0) {
            node.right = insert(node.right, x);
        } else {
            throw new ItemDuplicated("El elemento " + x.toString() + " ya existe en el árbol");
        }
        return node;
    }

    public E search(E x) throws ItemNotFound {
        Node node = search(root, x);
        if (node == null) {
            throw new ItemNotFound("El elemento " + x.toString() + " no se encuentra en el árbol");
        }
        return node.data;
    }

    private Node search(Node node, E x) {
        if (node == null || x.compareTo(node.data) == 0) {
            return node;
        } else if (x.compareTo(node.data) < 0) {
            return search(node.left, x);
        } else {
            return search(node.right, x);
        }
    }

    public void remove(E x) throws ItemNotFound {
        root = remove(root, x);
    }

    private Node remove(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento " + x.toString() + " no se encuentra en el árbol");
        } else if (x.compareTo(node.data) < 0) {
            node.left = remove(node.left, x);
        } else if (x.compareTo(node.data) > 0) {
            node.right = remove(node.right, x);
        } else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = remove(node.right, node.data);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }

    private void toString(Node node, StringBuilder sb) {
        if (node != null) {
            toString(node.left, sb);
            sb.append(node.data.toString()).append(", ");
            toString(node.right, sb);
        }
    }
}
