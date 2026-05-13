package backtracking.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class MainFour {
    public static void main(String[] args) {

        // Caso 1: El caso ideal. Suma 10 (par) y la partición (5) es posible: {3, 2} y {4, 1}
        List<Integer> casoIdeal = new ArrayList<>(List.of(3, 4, 1, 2));
        probarCaso("Caso Ideal", casoIdeal);

        // Caso 2: Suma 10 (par) pero la partición a 5 es IMPOSIBLE usando un 6.
        // Acá vas a ver cómo el algoritmo intenta, hace podas y retrocede hasta rendirse.
        //List<Integer> casoImposiblePar = new ArrayList<>(List.of(2, 2, 6));
        //probarCaso("Caso Imposible (Par)", casoImposiblePar);

        // Caso 3: Suma 7 (impar). El "Fail-Fast".
        // Acá ni siquiera debería entrar al método recursivo.
        //List<Integer> casoImpar = new ArrayList<>(List.of(1, 2, 4));
        //probarCaso("Caso Impar (Fail-Fast)", casoImpar);
    }

    private static void probarCaso(String nombrePrueba, List<Integer> numeros) {
        System.out.println("==================================================");
        System.out.println("Iniciando: " + nombrePrueba);
        System.out.println("Conjunto a evaluar: " + numeros);
        System.out.println("--------------------------------------------------");

        Ejercicio4 ejercicio = new Ejercicio4();
        // Pasamos los números a tu clase
        ejercicio.setNumeros(numeros);

        boolean resultado = ejercicio.solve();

        if (resultado) {
            System.out.println("✅ VEREDICTO: ¡Se encontró una partición válida!");
        } else {
            System.out.println("❌ VEREDICTO: No existe ninguna partición posible.");
        }
        System.out.println("==================================================\n");
    }
}
