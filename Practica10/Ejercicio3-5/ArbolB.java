/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad_3_Ejercicios_3y5;

/**
 *
 * @author Acer
 */
public class ArbolB {
    NodoArbolB root;
    int t;

    // Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }

    // Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);
        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    // Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0; // se empieza a buscar siempre en la primera posicion
        // Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }
        // Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }
        // Si llegamos hasta aqui, entonces hay que buscar los hijos
        // Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            // Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

    public void insertar(int key) {
        NodoArbolB r = root;
        // Si el nodo esta lleno, debe separarlo antes de insertar
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

    private void split(NodoArbolB x, int i, NodoArbolB y) {
        NodoArbolB z = new NodoArbolB(t); // Nodo temporal que será el hijo i + 1 de x
        z.leaf = y.leaf;
        z.n = (t - 1);
        // Copia las últimas (t - 1) claves del nodo y al inicio del nodo z
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }
        // Si no es hoja, hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }
        // Nuevo tamaño de y
        y.n = (t - 1);
        // Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
        // Reasigna el hijo (i+1) de x
        x.child[(i + 1)] = z;
        // Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }
        // Agrega la clave situada en la mediana
        x.key[i] = y.key[(t - 1)];
        x.n++;
    }

    private void nonFullInsert(NodoArbolB x, int key) {
        // Si es una hoja
        if (x.leaf) {
            int i = x.n; // cantidad de valores del nodo
            // Busca la posición i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1]; // Desplaza los valores mayores a key
                i--;
            }
            x.key[i] = key; // Asigna el valor al nodo
            x.n++; // Aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            // Busca la posición del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }
            // Si el nodo hijo está lleno, lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);
                if (key > x.key[j]) {
                    j++;
                }
            }
            nonFullInsert(x.child[j], key);
        }
    }

    public void showBTree() {
        print(root);
    }

    // Print in preorder
    private void print(NodoArbolB n) {
        n.imprimir();
        // Si no es hoja
        if (!n.leaf) {
            // Recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }
        public int[] obtenerClavesNodoPorValor(int valor) {
        NodoArbolB nodo = search(root, valor);
        if (nodo != null) {
            int[] claves = new int[nodo.n];
            for (int i = 0; i < nodo.n; i++) {
                claves[i] = nodo.key[i];
            }
            return claves;
        } else {
            return null;
        }
    }
        public NodoArbolB obtenerNodoMinimoRaiz() {
        if (root != null) {
            NodoArbolB nodo = root;
            while (!nodo.leaf) {
                nodo = nodo.child[0];
            }
            return nodo;
        }
        return null;
    }
}


