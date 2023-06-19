public class TestArbolB {

    public static void main(String[] args) {
        int t = 3;
        ArbolB arbolB = new ArbolB(t);

        int[] valoresUno = {20, 10, 50, 30, 40};
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for(int i=0; i<valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }

        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        System.out.println("Insertando... valor 60");
        arbolB.insertar(60);
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        System.out.println("Insertando... valor 80");
        arbolB.insertar(80);
        System.out.println("Insertando... valor 70");
        arbolB.insertar(70);
        System.out.println("Insertando... valor 90");
        arbolB.insertar(90);

        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        System.out.println("\nBuscando el nodo con el valor 80 en el arbol B:");
        arbolB.buscarNodoPorClave(80);

        System.out.println("\nRecorrido realizado:");
        System.out.println(arbolB.getCaminoRecorrido());

        System.out.println("");
        System.out.println("-- FIN --");
    }
}
