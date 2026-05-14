package backtracking.ejercicio8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main8 {

    public static void main(String[] args) {
        // 1. Instanciamos tu clase Piramide
        Piramide constructorPiramide = new Piramide();

        // 2. Preparamos los datos de prueba basados en el ejemplo de la imagen
        int B = 3;
        int k = 20;

        // Ponemos una lista con varios números disponibles (incluyendo los de la solución)
        List<Integer> numerosDisponibles = new ArrayList<>(Arrays.asList(9, 5, 12, 1, 8, 7, 14, 6, 3, 2));

        System.out.println("Iniciando Backtracking para la Pirámide...");
        System.out.println("Base (B): " + B + " | Límite estricto (k): " + k);
        System.out.println("Números disponibles en la caja: " + numerosDisponibles);
        System.out.println("--------------------------------------------------");

        // 3. Ejecutamos el algoritmo
        int[][] resultado = constructorPiramide.getPiramide(numerosDisponibles, B, k);

        // 4. Mostramos el resultado de la pirámide invertida (Fila 0 abajo, Fila B-1 arriba)
        if (resultado != null) {
            System.out.println("¡Pirámide construida con éxito!\n");
            imprimirPiramide(resultado, B);
        } else {
            System.out.println("No se encontró ninguna combinación de números que pueda sostener la pirámide.");
        }
    }

    // Método auxiliar para imprimir la matriz con forma de pirámide real en la consola
    private static void imprimirPiramide(int[][] matriz, int B) {
        // Recorremos desde la cima (Fila B-1) hacia la base (Fila 0) para que se vea como pirámide
        for (int i = B - 1; i >= 0; i--) {

            // Agregamos espacios a la izquierda para centrar los ladrillos visualmente
            for (int espacio = 0; espacio < (B - 1 - i) * 3; espacio++) {
                System.out.print(" ");
            }

            // Imprimimos los ladrillos válidos de ese piso
            for (int j = 0; j < (B - i); j++) {
                System.out.printf("[%2d]  ", matriz[i][j]);
            }
            System.out.println(); // Salto de piso
        }
    }
}