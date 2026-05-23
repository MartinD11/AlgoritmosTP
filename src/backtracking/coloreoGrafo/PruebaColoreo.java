package backtracking.coloreoGrafo;

import grafos.GrafoNoDirigido;
import java.util.HashMap;
import java.util.Map;

public class PruebaColoreo {

    public static void main(String[] args) {
        // 1. Instanciamos el grafo (asumo que tenés un constructor vacío o similar)
        GrafoNoDirigido grafo = new GrafoNoDirigido();

        // 2. Agregamos los 4 vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        // 3. Agregamos las aristas (conexiones)
        // El 1, 2 y 3 forman un triángulo
        grafo.agregarArco(1, 2,"");
        grafo.agregarArco(1, 3,"");
        grafo.agregarArco(2, 3,"");

        // El 4 solo se conecta como "cola" del 3
        grafo.agregarArco(3, 4,"");

        // 4. Instanciamos tu clase resolutora
        MainColoreo resolutor = new MainColoreo();

        // 5. Disparamos el algoritmo
        HashMap<Integer, Integer> resultado = resolutor.getVerticesPintados(grafo);

        // 6. Mostramos los resultados por consola
        System.out.println("--- RESULTADO DEL COLOREO ---");
        if (resultado == null || resultado.isEmpty()) {
            System.out.println("No se encontró ninguna solución.");
        } else {
            int maxColorUsado = 0;
            System.out.println("Asignación de colores por vértice:");

            for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
                System.out.println("Vértice " + entry.getKey() + " -> Color " + entry.getValue());

                // Buscamos cuál fue el número de color más alto que quedó en el mapa
                if (entry.getValue() > maxColorUsado) {
                    maxColorUsado = entry.getValue();
                }
            }

            System.out.println("-----------------------------");
            System.out.println("Cantidad MÍNIMA de colores utilizados: " + maxColorUsado);
            // El resultado esperado de maxColorUsado debe ser sí o sí 3.
        }
    }
}
