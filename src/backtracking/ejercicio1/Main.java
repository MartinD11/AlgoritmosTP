package backtracking.ejercicio1;

import grafos.GrafoDirigido;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Instanciamos el grafo (asumo que tu clase se llama así)
        GrafoDirigido<Integer> casa = new GrafoDirigido<>();

        // 2. Agregamos las salas (Vértices)
        casa.agregarVertice(1); // ENTRADA
        casa.agregarVertice(2);
        casa.agregarVertice(3);
        casa.agregarVertice(4);
        casa.agregarVertice(5);
        casa.agregarVertice(6); // SALIDA

        // 3. Agregamos las puertas con un solo sentido (Arcos dirigidos)

        // Caminos desde la Entrada (1)
        casa.agregarArco(1, 2,1);
        casa.agregarArco(1, 3,1);

        // El camino directo/rápido hacia la salida
        casa.agregarArco(2, 4,1);
        casa.agregarArco(4, 6,1);

        // El camino largo/tramposo que da la vuelta
        casa.agregarArco(3, 4,1); // Atajo engañoso
        casa.agregarArco(3, 5,1); // Desvío largo
        casa.agregarArco(5, 2,1); // De la 5 vuelvo a la 2 para hacer más recorrido

        // 4. Instanciamos tu clase resolutora
        Ejercicio1<Integer> buscador = new Ejercicio1<>();

        // 5. Llamamos al motor (Queremos ir de la Sala 1 a la Sala 6)
        System.out.println("Arrancando el motor de búsqueda...");
        List<Integer> recorridoMasLargo = buscador.caminoMasLargo(casa, 1, 6);

        // 6. Imprimimos el resultado
        System.out.println("\n--- RESULTADO FINAL ---");
        if (recorridoMasLargo.isEmpty()) {
            System.out.println("No se encontró ninguna ruta hacia la salida.");
        } else {
            System.out.println("El camino más largo encontrado atraviesa " + recorridoMasLargo.size() + " salas:");
            System.out.println(recorridoMasLargo);
        }
    }
}