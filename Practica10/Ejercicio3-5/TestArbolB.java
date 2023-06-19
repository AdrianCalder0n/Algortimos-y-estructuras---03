/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad_3_Ejercicios_3y5;

/**
 *
 * @author Acer
 */
public class TestArbolB {
    public static void main(String[] args) {
        // Grado mínimo del Arbol B es t=3
        // Cada nodo soporta 2t hijos y 2t-1 claves
        int t = 3;
        
        // Se crea el arbol B según t
        ArbolB arbolB = new ArbolB(t);

        // Valores a ingresar en la primera ronda
        int[] valoresUno = {20, 10, 50, 30, 40};
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for(int i=0; i<valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }

        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar en la segunda ronda
        System.out.println("Insertando... valor 60");
        arbolB.insertar(60);
        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar en la tercera ronda
        System.out.println("Insertando... valor 80");
        arbolB.insertar(80);
        System.out.println("Insertando... valor 70");
        arbolB.insertar(70);
        System.out.println("Insertando... valor 90");
        arbolB.insertar(90);
        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Buscar
        System.out.println("\nBuscando el nodo con el valor 80 en el arbol B:");
        arbolB.buscarNodoPorClave(80);

        System.out.println("");
        System.out.println("-- FIN --");
        
        // Buscar y mostrar las claves del nodo que contiene el valor 80
        int[] clavesNodo80 = arbolB.obtenerClavesNodoPorValor(80);
        if (clavesNodo80 != null) {
            System.out.print("Claves del nodo con valor 80: ");
            for (int i = 0; i < clavesNodo80.length; i++) {
                System.out.print(clavesNodo80[i]);
                if (i < clavesNodo80.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No se encontró un nodo con el valor 80");
        }
        // Obtener y mostrar el nodo mínimo de la raíz
        NodoArbolB nodoMinimoRaiz = arbolB.obtenerNodoMinimoRaiz();
        if (nodoMinimoRaiz != null) {
            System.out.print("Nodo mínimo de la raíz: ");
            nodoMinimoRaiz.imprimir();
            System.out.println();
        } else {
            System.out.println("El árbol está vacío");
        }
    }
}

