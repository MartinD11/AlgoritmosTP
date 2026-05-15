package backtracking.ejercicio9;

import java.util.List;

public class Main9 {
    public static void main(String[] args) {
        System.out.println("Iniciando búsqueda para el 15-Puzzle...");
        System.out.println("----------------------------------------");

        // 1. Instanciamos tu clase
        block15 rompecabezas = new block15();

        // 2. Ejecutamos el algoritmo
        long inicio = System.currentTimeMillis();
        List<List<Integer>> solucion = rompecabezas.getMovimientos();
        long fin = System.currentTimeMillis();

        // 3. Mostramos los resultados
        if (solucion != null) {
            System.out.println("¡Rompecabezas resuelto en " + solucion.size() + " movimientos!");
            System.out.println("Tiempo de cálculo: " + (fin - inicio) + " ms\n");

            System.out.println("Secuencia de coordenadas del hueco (0):");
            int paso = 1;
            for (List<Integer> coordenada : solucion) {
                System.out.println("Paso " + paso + ": Mover hueco a la fila " + coordenada.get(0) + ", columna " + coordenada.get(1));
                paso++;
            }
        } else {
            System.out.println("No se encontró solución dentro del límite de pasos establecido.");
        }
    }
}