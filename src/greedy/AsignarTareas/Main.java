package greedy.AsignarTareas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Tarea> tareas = new ArrayList<>();

        // El ejemplo de tu enunciado:
        // T1 (P=10, C=2); T2 (P=20, C=1); T3 (P=8, C=2)
        tareas.add(new Tarea("T1", 10, 2));
        tareas.add(new Tarea("T2", 20, 1));
        tareas.add(new Tarea("T3", 8, 2));

        System.out.println("--- INICIO DEL ALGORITMO ---");
        List<Tarea> resultado = obtenerSecuencia(tareas);

        System.out.println("\n--- RESULTADO FINAL ---");
        System.out.println("Secuencia óptima a ejecutar: " + resultado);
    }

    public static List<Tarea> obtenerSecuencia(List<Tarea> tareas) {
        // 1. Ordenamos de mayor a menor puntaje
        tareas.sort((t1, t2) -> Integer.compare(t2.getPuntaje(), t1.getPuntaje()));

        List<Tarea> procesador = new ArrayList<>();
        Set<Integer> segundosOcupados = new HashSet<>();

        // 2. Iteramos UNA sola vez la lista de tareas
        for (Tarea t : tareas) {

            int tiempo = t.getCaducidad();

            while (tiempo >= 1 && segundosOcupados.contains(tiempo)) {
                tiempo--;
            }

            if (tiempo >= 1) {
                segundosOcupados.add(tiempo);
                procesador.add(t);
            }
        }

        return procesador;
    }
}
