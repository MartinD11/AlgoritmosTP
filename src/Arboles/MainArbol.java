package Arboles;

public class MainArbol {

    public static void main(String[] args) {
        Tree arbol = new Tree();

        // Armamos un árbol simétrico perfecto
        //        50
        //      /    \
        //    30      70
        //   /  \    /  \
        // 20   40  60   80

        arbol.add(50);
        arbol.add(30);
        arbol.add(70);
        arbol.add(20);
        arbol.add(40);
        arbol.add(60);
        arbol.add(80);

        System.out.println("--- PRUEBA DE RECORRIDOS ---");

        // 1. Pre-Orden: Ideal para copiar el árbol.
        // Primero se imprime la raíz (50), luego toda la rama izquierda, luego la derecha.
        arbol.imprimirPreOrden();
        // Salida esperada: 50 30 20 40 70 60 80

        // 2. In-Orden: El rey de la búsqueda.
        // Como es un Árbol Binario de Búsqueda, SIEMPRE imprime de menor a mayor.
        //arbol.imprimirInOrden();
        // Salida esperada: 20 30 40 50 60 70 80

        // 3. Post-Orden: Ideal para borrar o sumar.
        // La raíz (50) es la ÚLTIMA en imprimirse porque espera a que terminen sus hijos.
        //arbol.imprimirPostOrden();
        // Salida esperada: 20 40 30 60 80 70 50
    }

    }
