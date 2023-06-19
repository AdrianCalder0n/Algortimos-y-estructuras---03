public class NodoArbolB {

    int n;
    int[] key;
    NodoArbolB[] child;
    boolean leaf;

    //Constructor
    public NodoArbolB(int t) {
        n = 0;
        key = new int[(2 * t) - 1];
        child = new NodoArbolB[2 * t];
        leaf = true;
    }

    public void imprimir() {
        for (int i = 0; i < n; i++) {
            System.out.print(key[i] + " ");
        }
        System.out.println();
    }
}
