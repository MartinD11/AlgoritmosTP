package backtracking.ejercicio7;

public class Main7 {

    public static void main(String[] args) {
        // 1. Instanciamos tu clase
        RellenarMatriz resolutor = new RellenarMatriz();

        // 2. Preparamos los datos de prueba
        int tamanio = 3;
        int S = 15;
        // Ponemos 10 números para cumplir que k > n*n (10 > 9)
        int[] numerosDisponibles = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Iniciando Backtracking...");
        System.out.println("Buscando matriz de " + tamanio + "x" + tamanio + " con suma " + S);
        System.out.println("--------------------------------------------------");

        // 3. Ejecutamos el algoritmo
        int[][] resultado = resolutor.rellenarMatriz(numerosDisponibles, S, tamanio);

        // 4. Mostramos el resultado
        if (resultado != null) {
            System.out.println("¡Solución encontrada!\n");
            imprimirMatriz(resultado);
        } else {
            System.out.println("No se encontró ninguna combinación válida que cumpla las reglas.");
        }
    }

    // Método auxiliar para imprimir la matriz de forma prolija en consola
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[i].length; j++) {
                // Formateamos para que los números queden alineados
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println("]");
        }
    }
}