public class ArbolB {

    NodoArbolB root;
    int t;

    //Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }

    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            temp.imprimir();
        }
    }

    //Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;//se empieza a buscar siempre en la primera posicion

        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        //Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        //Si llegamos hasta aqui, entonces hay que buscar los hijos
        //Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            //Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

    public void insertar(int key) {
        NodoArbolB r = root;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }

    // Caso cuando la raiz se divide
    // x =          | | | | | |
    //             /
    //      |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z      // z = |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        //nuevo tamanio de y                                                    // x =            | | | | | |
        y.n = (t - 1);                                                          //               /   \
        //  |10|20|30| | |   |40|50| | |   // y = |10|20|30| | |
        for (int j = (x.n + 1); j > (i + 1); j--) {                              // x.child[0]      x.child[1]     x.child[2]
            x.child[j] = x.child[(j - 1)];
        }

        //Agrega el nuevo hijo z en el indice i + 1 de x
        x.child[(i + 1)] = z;

        //Agrega la clave que esta en medio de y a x                                // x =         |30| | | | |
        for (int j = x.n; j > i; j--) {                                            //         /   |   \
            x.key[j] = x.key[(j - 1)];                                             // y = |10|20| | | |  |40|50| | |
        }                                                                           //      x.child[0]  x.child[1]  x.child[2]

        x.key[i] = y.key[(t - 1)];
        x.n = (x.n + 1);
    }

    //Inserta el valor en un nodo no lleno
    private void nonFullInsert(NodoArbolB x, int k) {
        int i = x.n;

        if (x.leaf) {
            while (i >= 1 && k < x.key[(i - 1)]) {
                x.key[i] = x.key[(i - 1)];
                i--;
            }
            x.key[i] = k;
            x.n = (x.n + 1);
        } else {
            while (i >= 1 && k < x.key[(i - 1)]) {
                i--;
            }
            i++;

            if (x.child[i - 1].n == ((2 * t) - 1)) {
                split(x, (i - 1), x.child[(i - 1)]);

                if (k > x.key[(i - 1)]) {
                    i++;
                }
            }
            nonFullInsert(x.child[(i - 1)], k);
        }
    }

    public void imprimirArbol() {
        print(root);
    }

    private void print(NodoArbolB n) {
        n.imprimir();

        if (!n.leaf) {
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }
}
