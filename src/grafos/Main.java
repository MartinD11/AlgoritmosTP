package grafos;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== INICIANDO PRUEBAS DEL TP DE GRAFOS ===");

        // 1. Instanciamos el Grafo (La etiqueta de los arcos será Integer para los KMs)
        GrafoDirigido<Integer> mapa = new GrafoDirigido<>();

        // 2. Agregamos los Vértices (Las Ciudades)
        mapa.agregarVertice(1); // Olavarría
        mapa.agregarVertice(2); // Azul
        mapa.agregarVertice(3); // Rauch
        mapa.agregarVertice(4); // Tandil
        mapa.agregarVertice(5); // Las Flores

        // 3. Agregamos los Arcos (Las Rutas) -> origen, destino, etiqueta(kms)
        mapa.agregarArco(1, 2, 50);  // Olavarría -> Azul
        mapa.agregarArco(2, 3, 70);  // Azul -> Rauch
        mapa.agregarArco(3, 4, 70);  // Rauch -> Tandil
        mapa.agregarArco(2, 4, 100); // Azul -> Tandil (Ruta alternativa directa)
        mapa.agregarArco(1, 5, 120); // Olavarría -> Las Flores
        mapa.agregarArco(5, 4, 150); // Las Flores -> Tandil

        System.out.println("\nEstructura del Grafo cargada:");
        System.out.println("Cantidad de Vértices: " + mapa.cantidadVertices());
        System.out.println("Cantidad de Arcos: " + mapa.cantidadArcos());


        // --- PRUEBA 1: Búsqueda a lo Ancho (BFS) ---
        System.out.println("\n=== PRUEBA EJERCICIO 2: BFS ===");
        BFS<Integer> buscadorBFS = new BFS<>();
        List<Integer> recorridoBFS = buscadorBFS.bfs(mapa);

        System.out.println("Recorrido BFS completo del grafo:");
        System.out.println(recorridoBFS);
        // Debería imprimir algo similar a [1, 2, 5, 3, 4] dependiendo del orden del iterador


        // --- PRUEBA 2: Camino Más Largo (Programación Dinámica) ---
        System.out.println("\n=== PRUEBA EJERCICIO 4: CAMINO MÁS LARGO ===");
        Ejercicio4<Integer> buscadorCaminos = new Ejercicio4<>(); // Usá el nombre de tu clase

        int origen = 1;  // Salimos de Olavarría
        int destino = 4; // Queremos llegar a Tandil

        List<Integer> mejorRuta = buscadorCaminos.caminoMasLArgo(mapa, origen, destino);

        System.out.println("Buscando el camino con más 'saltos' desde " + origen + " hasta " + destino + "...");

        if (mejorRuta.isEmpty()) {
            System.out.println("No se encontró ningún camino.");
        } else {
            System.out.println("El camino más largo encontrado es:");
            System.out.println(mejorRuta);
            // Debería imprimir [1, 2, 3, 4] (Olavarría -> Azul -> Rauch -> Tandil)
            // Ya que tiene 3 saltos, ganándole a las alternativas [1, 2, 4] y [1, 5, 4].
        }

        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}
