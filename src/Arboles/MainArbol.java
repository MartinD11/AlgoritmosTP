package Arboles;

public class MainArbol {

    public static void main(String[] args) {
        Tree arbol = new Tree();

        // 1. Armamos el árbol insertando los valores
        // El primer valor ingresado (50) será la raíz
        arbol.add(50);

        arbol.add(30);
        arbol.add(70);

        arbol.add(20);
        arbol.add(40);
        arbol.add(60);
        arbol.add(80);

        System.out.println("--- PRUEBAS DEL MÉTODO sumarConRestriccion ---");

        // PRUEBA 1: Rango en el medio del árbol
        // Nodos que entran: 40, 50, 60. Suma esperada: 150.
        int inf1 = 35;
        int sup1 = 65;
        int resultado1 = arbol.sumarConRestriccion(inf1, sup1);
        System.out.println("Suma en rango [" + inf1 + ", " + sup1 + "] -> Esperado: 150 | Obtenido: " + resultado1);

    }
}