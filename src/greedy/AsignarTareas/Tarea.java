package greedy.AsignarTareas;

class Tarea {
    private String nombre;
    private int puntaje;
    private int caducidad;

    public Tarea(String nombre, int puntaje, int caducidad) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.caducidad = caducidad;
    }

    public int getPuntaje() { return puntaje; }
    public int getCaducidad() { return caducidad; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + "(P:" + puntaje + ", C:" + caducidad + ")";
    }
}
