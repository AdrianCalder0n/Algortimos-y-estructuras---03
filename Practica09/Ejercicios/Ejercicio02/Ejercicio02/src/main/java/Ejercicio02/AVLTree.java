package Ejercicio02;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    class NodeAVL extends Node {

        protected int bf;

        public NodeAVL(E data) {
            super(data);
            bf = 0;
        }

        public String toString() {
            return super.toString() + " (BF: " + bf + ")";
        }
    }

    private boolean height;

    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);
    }

    protected NodeAVL insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;
        if (node == null) {
            this.height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0) {
                throw new ItemDuplicated(x + " ya se encuentra en el arbol...");
            }
            if (resC < 0) {
                fat.right = insert(x, (NodeAVL) node.right);
                if (this.height) {
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            this.height = true;
                            break;
                        case 1: // bf = 2
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
                }
            } else {
                fat.left = insert(x, (NodeAVL) node.left);
                if (this.height) {
                    switch (fat.bf) {
                        case -1: // bf = -2
                            fat = balanceToRight(fat);
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = -1;
                            this.height = true;
                            break;
                        case 1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                    }
                }
            }
        }
        return fat;
    }
    
// Ejercicio 2
    
    @Override
    public void remove(E x) throws ItemNotFound {
        this.height = false;
        root = remove((NodeAVL) root, x);
    }

    private NodeAVL remove(NodeAVL node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento " + x.toString() + " no se encuentra en el árbol");
        } else if (x.compareTo(node.data) < 0) {
            node.left = remove((NodeAVL) node.left, x);
            if (this.height) {
                node = balanceToRight(node);
            }
        } else if (x.compareTo(node.data) > 0) {
            node.right = remove((NodeAVL) node.right, x);
            if (this.height) {
                node = balanceToLeft(node);
            }
        } else if (node.left != null && node.right != null) {
            node.data = findMin((NodeAVL) node.right).data;
            node.right = remove((NodeAVL) node.right, node.data);
            if (this.height) {
                node = balanceToLeft(node);
            }
        } else {
            node = (node.left != null) ? (NodeAVL) node.left : (NodeAVL) node.right;
            this.height = true;
        }
        return node;
    }

    private NodeAVL findMin(NodeAVL node) {
        while (node.left != null) {
            node = (NodeAVL) node.left;
        }
        return node;
    }
    
// FIN Ejercicio 2
    
    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case -1:
                        node.bf = -1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }
}
