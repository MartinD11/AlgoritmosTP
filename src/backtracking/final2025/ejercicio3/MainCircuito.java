package backtracking.final2025.ejercicio3;

import grafos.GrafoNoDirigido;
import java.util.ArrayList;

public class MainCircuito {

    public static void main(String[] args) {

        // 1. Instanciamos tu grafo indicando que las etiquetas (pesos) son Integer
        GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();

        // 2. Agregamos las 4 ciudades (Vértices)
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        // 3. Agregamos las rutas (Arcos) con sus respectivos costos
        // Como es no dirigido, tu clase ya se encarga de hacer el ida y vuelta internamente
        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 3, 15);
        grafo.agregarArco(1, 4, 20);

        grafo.agregarArco(2, 3, 35);
        grafo.agregarArco(2, 4, 25);

        grafo.agregarArco(3, 4, 30);

        // 4. Instanciamos tu algoritmo resolutor
        Circuito viajante = new Circuito();

        // 5. Disparamos la búsqueda arrancando desde la ciudad 1
        System.out.println("Calculando la ruta óptima...");
        ArrayList<Integer> mejorRuta = viajante.getCiudades(grafo, 1);

        // 6. Mostramos el resultado por consola
        System.out.println("\n--- RESULTADO DEL VIAJE ---");

        if (mejorRuta == null || mejorRuta.isEmpty()) {
            System.out.println("No se encontró ningún circuito posible que visite todas las ciudades y vuelva al origen.");
        } else {
            System.out.print("Ruta ganadora: ");
            for (int i = 0; i < mejorRuta.size(); i++) {
                System.out.print(mejorRuta.get(i));
                if (i < mejorRuta.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();

            // Con estos datos, la ruta óptima debería ser: 1 -> 2 -> 4 -> 3 -> 1
            // Y el costo interno que calculó tu clase debería haber sido de 80.
        }
    }
}