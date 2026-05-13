package backtracking.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        // 1. Creamos las listas sueltas primero (El entorno)
        List<Procesador> procesadores = new ArrayList<>();
        procesadores.add(new Procesador(1));
        procesadores.add(new Procesador(2));
        procesadores.add(new Procesador(3));

        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea(10));
        tareas.add(new Tarea(7));
        tareas.add(new Tarea(5));
        tareas.add(new Tarea(4));
        tareas.add(new Tarea(3));

        System.out.println("Iniciando asignación de tareas...\n");

        // 2. Instanciamos el motor de Backtracking
        Backtracking motor = new Backtracking();

        // 3. Le pasamos las listas listas al motor para que las procese
        List<Procesador> solucion = motor.getSolucion(procesadores, tareas);

        // 4. Imprimimos el resultado de la lista clonada que nos devolvió
        System.out.println("--- RESULTADO DE LA DISTRIBUCIÓN ---");
        int cuelloDeBotella = 0;

        for (Procesador p : solucion) {
            System.out.print("Procesador " + p.getId() + " [Carga total: " + p.getCarga() + "h] -> Tareas asignadas: ");

            if (p.getTareas().isEmpty()) {
                System.out.print("Ninguna");
            } else {
                for (Tarea t : p.getTareas()) {
                    System.out.print("(" + t.getTiempo() + "h) ");
                }
            }
            System.out.println();

            // Buscamos el tiempo máximo para mostrarlo al final
            if (p.getCarga() > cuelloDeBotella) {
                cuelloDeBotella = p.getCarga();
            }
        }

        System.out.println("------------------------------------");
        System.out.println("TIEMPO TOTAL DEL SISTEMA: " + cuelloDeBotella + " horas.");
    }
}
