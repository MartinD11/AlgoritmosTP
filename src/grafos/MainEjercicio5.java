package grafos;

import java.util.List;

public class MainEjercicio5 {

    public static void main(String[] args) {
        // 1. Creamos el grafo y cargamos datos
        GrafoDirigido<String> mapa = new GrafoDirigido<>();

        // Vértices
        mapa.agregarVertice(1); // Olavarría
        mapa.agregarVertice(2); // Azul
        mapa.agregarVertice(3); // Tandil
        mapa.agregarVertice(4); // Rauch (Quedará aislado para probar)

        // Arcos: 1 -> 2 -> 3
        mapa.agregarArco(1, 2, "Ruta 226");
        mapa.agregarArco(2, 3, "Ruta 226");

        // 2. Instanciamos tu lógica
        Ejercicio5<String> solucion = new Ejercicio5<>();

        Integer meta = 3; // Queremos ver quiénes llegan a Tandil
        System.out.println("Buscando vértices que tengan un camino hacia el nodo: " + meta);

        List<Integer> resultados = solucion.caminosPosibles(mapa, meta);

        // 3. Mostramos resultados
        System.out.println("Los vértices que llegan a " + meta + " son: " + resultados);

        /* * Explicación de la recursión para el vértice 1:
         * caminos(1, 3) llama a -> caminos(2, 3)
         * caminos(2, 3) tiene como adyacente a 3.
         * caminos(2, 3) llama a -> caminos(3, 3)
         * caminos(3, 3) detecta que actual == destino y devuelve TRUE.
         * El TRUE vuelve a caminos(2, 3), que a su vez lo devuelve a caminos(1, 3).
         * Finalmente, 1 se agrega a la lista de válidos.
         */
    }
}
