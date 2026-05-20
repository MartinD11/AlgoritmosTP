package backtracking.mochila;

import java.util.ArrayList;
import java.util.List;

public class MainMochila {

    public static void main(String[] args) {

        // 1. Instanciamos los objetos (Peso, Valor)
        // Ojo acá: El objeto 1 tiene el mejor ratio ($6 por kilo), pero llevarlo
        // arruinaría el espacio para llevar la combinación ganadora (Obj 2 + Obj 3 = $220).
        List<Objeto> objetosDisponibles = new ArrayList<>();
        objetosDisponibles.add(new Objeto(2, 60));  // Objeto A
        objetosDisponibles.add(new Objeto(2, 10)); // Objeto B
        objetosDisponibles.add(new Objeto(30, 120)); // Objeto C

        // 2. Preparamos las variables que pide tu constructor
        int pesoMaximo = 50;
        int mejorValorInicial = 0;
        List<Objeto> mejorMochila = new ArrayList<>();
        List<Objeto> solParcial = new ArrayList<>();

        // 3. Instanciamos tu clase con las listas vacías
        BacktrackingM motor = new BacktrackingM(
                pesoMaximo,
                mejorValorInicial,
                objetosDisponibles,
                mejorMochila,
                solParcial
        );

        // 4. Disparamos el algoritmo
        List<Objeto> resultado = motor.getMochila();

        // 5. Imprimimos los resultados por consola
        System.out.println("--- RESULTADO DEL BACKTRACKING ---");
        if (resultado.isEmpty()) {
            System.out.println("No se pudo meter ningún objeto en la mochila.");
        } else {
            int pesoTotal = 0;
            int valorTotal = 0;

            System.out.println("Objetos en la mochila ganadora:");
            for (int i = 0; i < resultado.size(); i++) {
                Objeto obj = resultado.get(i);
                System.out.println("- Objeto " + (i+1) + " (Peso: " + obj.getPeso() + "kg | Valor: $" + obj.getValor() + ")");
                pesoTotal += obj.getPeso();
                valorTotal += obj.getValor();
            }

            System.out.println("----------------------------------");
            System.out.println("Peso final utilizado: " + pesoTotal + " / " + pesoMaximo + "kg");
            System.out.println("Ganancia MÁXIMA total: $" + valorTotal);
            // El resultado esperado debería ser Peso: 50, Valor: $220.
        }
    }
}