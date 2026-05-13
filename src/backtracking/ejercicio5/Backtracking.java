package backtracking.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    private List<Procesador> mejorDistribucion;
    private int mejorTiempo;

    public Backtracking() {
        this.mejorDistribucion = new ArrayList<>();
        this.mejorTiempo = Integer.MAX_VALUE;
    }

    public List<Procesador> getSolucion(List<Procesador> procesadores, List<Tarea> tareas) {
        this.mejorTiempo = Integer.MAX_VALUE;
        this.mejorDistribucion.clear();

        asignarTareas(procesadores, tareas, 0);

        return this.mejorDistribucion;
    }

    private void asignarTareas(List<Procesador> procesadores, List<Tarea> tareas, int indiceTarea) {

        if (indiceTarea == tareas.size()) {
            int cargaMaximaActual = buscarCuelloDeBotella(procesadores);

            if (cargaMaximaActual < this.mejorTiempo) {
                this.mejorTiempo = cargaMaximaActual;
                this.mejorDistribucion = crearCopiaProfunda(procesadores);
            }
            return;
        }

        Tarea tareaActual = tareas.get(indiceTarea);

        for (Procesador p : procesadores) {

            // poda
            int tiempoSimulado = p.getCarga() + tareaActual.getTiempo();

            if (tiempoSimulado < this.mejorTiempo) {
                p.addTarea(tareaActual);

                asignarTareas(procesadores, tareas, indiceTarea + 1);

                p.removeUltimaTarea();
            }
        }
    }


    // busco el procesador con mayor carga
    private int buscarCuelloDeBotella(List<Procesador> procesadores) {
        int max = 0;
        for (Procesador p : procesadores) {
            if (p.getCarga() > max) {
                max = p.getCarga();
            }
        }
        return max;
    }

    // copia de lso procesadores para poder devolverlos al final sin que se eliminen por la recursion
    private List<Procesador> crearCopiaProfunda(List<Procesador> procesadores) {
        List<Procesador> copia = new ArrayList<>();
        for (Procesador p : procesadores) {
            Procesador nuevoP = new Procesador(p.getId());
            for (Tarea t : p.getTareas()) {
                nuevoP.addTarea(t);
            }
            copia.add(nuevoP);
        }
        return copia;
    }

    public void add(Procesador procesador) {
        this.mejorDistribucion.add(procesador);
    }
}