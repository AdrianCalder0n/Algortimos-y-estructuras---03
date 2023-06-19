public class ArbolB {
    private NodoArbolB root;
    private int t;
    private StringBuilder caminoRecorrido;

    // Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
        caminoRecorrido = new StringBuilder();
    }

    // Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num) {
        caminoRecorrido.setLength(0); // Limpiar el camino recorrido
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    // Método privado para la búsqueda en el árbol
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0; // Se empieza a buscar siempre en la primera posición

        // Incrementa el índice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            caminoRecorrido.append(actual.key[i]).append(" -> ");
            i++;
        }

        // Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            caminoRecorrido.append(actual.key[i]).append(" (encontrado)");
            return actual;
        }

        // Si llegamos hasta aquí, entonces hay que buscar en los hijos
        // Se revisa primero si tiene hijos
        if (actual.leaf) {
            caminoRecorrido.append("(no hay más hijos)");
            return null;
        } else {
            // Si tiene hijos, se hace una llamada recursiva
            caminoRecorrido.append(actual.key[i]).append(" -> ");
            return search(actual.child[i], key);
        }
    }

    // Inserta un valor en el árbol B
    public void insertar(int key) {
        caminoRecorrido.setLength(0); // Limpiar el camino recorrido
        NodoArbolB r = root;

        // Si el nodo está lleno, se debe separar antes de insertar
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
    // Retorna el camino recorrido durante la inserción o búsqueda
    public String getCaminoRecorrido() {
        return caminoRecorrido.toString();
    }
}
