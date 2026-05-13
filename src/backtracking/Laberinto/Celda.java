package backtracking.Laberinto;

public class Celda {
    private int valor;
    private boolean norte, sur, este, oeste;

    public Celda(int valor, boolean norte, boolean sur, boolean este, boolean oeste) {
        this.valor = valor;
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
    }

    // Getters
    public int getValor() { return valor; }
    public boolean isNorte() { return norte; }
    public boolean isSur() { return sur; }
    public boolean isEste() { return este; }
    public boolean isOeste() { return oeste; }
}