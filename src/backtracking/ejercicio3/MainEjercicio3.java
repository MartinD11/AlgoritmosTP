package backtracking.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class MainEjercicio3 {
    public static void main(String[] args) {
        Ejercicio3 ejercicio = new Ejercicio3();

        // Caso de prueba 1: El de tu dibujo
        // n = {1, 2, 3, 4, 5, 6, 7}, M = 9
        List<Integer> numeros1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        System.out.println("--- Prueba 1: Conjunto {1,2,3,4,5,6,7} para M=9 ---");
        List<List<Integer>> resultados1 = ejercicio.getResultados(numeros1);
        imprimirResultados(resultados1);

        // Caso de prueba 2: Uno más corto para verificar visualmente
        // n = {2, 3, 5}, M = 5
        // Debería devolver: [[2, 3], [5]]
        System.out.println("\n--- Prueba 2: Conjunto {2,3,5} para M=5 ---");
        // Reiniciamos el objeto para limpiar la lista interna de resultados
        Ejercicio3 ejercicio2 = new Ejercicio3();
        List<Integer> numeros2 = new ArrayList<>(List.of(2, 3, 5));
        List<List<Integer>> resultados2 = ejercicio2.getResultados(numeros2);
        imprimirResultados(resultados2);
    }

    private static void imprimirResultados(List<List<Integer>> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron combinaciones.");
        } else {
            System.out.println("Combinaciones encontradas (" + resultados.size() + "):");
            for (List<Integer> combinacion : resultados) {
                System.out.println(combinacion);
            }
        }
    }
}
