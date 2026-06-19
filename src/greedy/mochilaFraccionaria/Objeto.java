package greedy.mochilaFraccionaria;

public class Objeto {
    private double peso;
    private double valor;

    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public double getValor() {
        return valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getRatio() {
        return this.valor / this.peso;
    }
}
