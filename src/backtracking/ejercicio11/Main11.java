package backtracking.ejercicio11;

import java.util.List;

public class Main11 {
    public static void main(String[] args) {
        Aspiradora robot = new Aspiradora();

        // Coordenadas: Inicio en (0,0) -> Base en (3,3)
        List<List<Integer>> caminoCorto = robot.getResultado(0, 0, 3, 3);

        if (caminoCorto.isEmpty()) {
            System.out.println("El robot no pudo llegar a la base. Se quedó sin batería.");
        } else {
            System.out.println("¡Camino más corto encontrado en " + (caminoCorto.size() - 1) + " pasos!");
            System.out.println("Secuencia de coordenadas:");
            for (List<Integer> paso : caminoCorto) {
                System.out.println("[" + paso.get(0) + ", " + paso.get(1) + "]");
            }
        }
    }
}