package backtracking.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Procesador {
    private int id;
    private int carga;
    private List<Tarea> tareas;

    public Procesador(int id) {
        this.id = id;
        this.carga = 0;
        this.tareas = new ArrayList<>();
    }

    public int getCarga() { return carga; }
    public List<Tarea> getTareas() { return tareas; }
    public int getId() { return id; }

    // Al agregar, suma la carga automáticamente
    public void addTarea(Tarea t) {
        this.tareas.add(t);
        this.carga += t.getTiempo();
    }

    // Método nuevo para el "deshacer" del Backtracking
    public void removeUltimaTarea() {
        if (!tareas.isEmpty()) {
            Tarea removida = this.tareas.remove(this.tareas.size() - 1);
            this.carga -= removida.getTiempo();
        }
    }
}