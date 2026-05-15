package backtracking.ejercicio10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main10 {
    public static void main(String[] args) {
        // 1. Instanciamos tu clase
        subconjuntos buscador = new subconjuntos();

        // 2. Preparamos el conjunto exacto del enunciado
        List<Integer> conjunto = new ArrayList<>(Arrays.asList(-7, -3, -2, -1, 5, 8));
        int N = 3;

        System.out.println("Conjunto original: " + conjunto);
        System.out.println("Buscando subconjuntos de tamaño N = " + N + " que sumen 0...");
        System.out.println("--------------------------------------------------");

        // 3. Ejecutamos el algoritmo pasándole la lista y el tamaño
        List<List<Integer>> resultados = buscador.getResultado(conjunto, N);

        // 4. Imprimimos el resultado de tu Backtracking
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron subconjuntos que cumplan la condición.");
        } else {
            System.out.println("¡Éxito! Se encontraron " + resultados.size() + " subconjuntos:");
            for (List<Integer> subconjunto : resultados) {
                System.out.println(subconjunto);
            }
        }
    }
}