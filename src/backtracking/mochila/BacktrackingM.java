package backtracking.mochila;

import java.util.List;

public class BacktrackingM {
    private int pesoMaximo;
    private int mejorValor;
    private List<Objeto> objetos;
    private List<Objeto> mochila;
    private List<Objeto> solParcial;

    public BacktrackingM(int pesoMaximo, int mejorValor, List<Objeto> objetos, List<Objeto> mochila, List<Objeto> solParcial) {
        this.pesoMaximo = pesoMaximo;
        this.mejorValor = mejorValor; // (Lo ideal es que arranque en 0)
        this.objetos = objetos;
        this.mochila = mochila;
        this.solParcial = solParcial;
    }

    public List<Objeto> getMochila() {
        backtracking(0, 0, 0);
        return mochila;
    }

    public void backtracking(int valorActual, int pesoActual, int indice) {

        if (pesoActual <= pesoMaximo) {
            if (valorActual > mejorValor) {
                mejorValor = valorActual;
                mochila.clear();
                mochila.addAll(solParcial);
            }
        }

        for (int i = indice; i < objetos.size(); i++) {
            Objeto objeto = objetos.get(i);
            int sumaPesoTemporal = objeto.getPeso() + pesoActual;
            int sumaValorTemporal = objeto.getValor() + valorActual;

            if (sumaPesoTemporal <= pesoMaximo) {

                solParcial.add(objeto);

                backtracking(sumaValorTemporal, sumaPesoTemporal, i + 1);

                solParcial.remove(solParcial.size() - 1);
            }
        }
    }
}