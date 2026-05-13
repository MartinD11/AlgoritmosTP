package backtracking.Laberinto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Laberinto {
    private Celda[][] celdas;
    private List<Posicion> caminoFinal;
    private int mejorValor;

    public Laberinto(Celda[][] celdas) {
        this.celdas = celdas;
        this.caminoFinal = new ArrayList<>();
    }

    public List<Posicion> solucion(Posicion origen, Posicion destino) {
        this.caminoFinal.clear();
        this.mejorValor = Integer.MAX_VALUE;

        List<Posicion> caminoActual = new ArrayList<>();
        HashSet<Posicion> visitados = new HashSet<>();

        visitados.add(origen);
        caminoActual.add(origen);

        int valorInicial = this.celdas[origen.getFila()][origen.getColumna()].getValor();

        buscarCamino(origen, destino, caminoActual, valorInicial, visitados);

        return this.caminoFinal;
    }

    private void buscarCamino(Posicion actual, Posicion destino, List<Posicion> caminoActual, int valorAcumulado, HashSet<Posicion> visitados) {

        if (valorAcumulado >= this.mejorValor) {
            return;
        }

        if (actual.equals(destino)) {
            this.mejorValor = valorAcumulado;
            this.caminoFinal.clear();
            this.caminoFinal.addAll(caminoActual);
            return;
        }

        for (Posicion vecino : this.adyacentes(actual)) {

            if (!visitados.contains(vecino)) {

                int costoVecino = this.celdas[vecino.getFila()][vecino.getColumna()].getValor();

                visitados.add(vecino);
                caminoActual.add(vecino);

                buscarCamino(vecino, destino, caminoActual, valorAcumulado + costoVecino, visitados);

                visitados.remove(vecino);
                caminoActual.remove(caminoActual.size() - 1);
            }
        }
    }

    private List<Posicion> adyacentes(Posicion actual) {
        List<Posicion> retorno = new ArrayList<>();
        Celda actualCelda = this.celdas[actual.getFila()][actual.getColumna()];

        int f = actual.getFila();
        int c = actual.getColumna();
        int maxFila = this.celdas.length - 1;
        int maxCol = this.celdas[0].length - 1;

        if (actualCelda.isNorte() && f > 0) retorno.add(new Posicion(f - 1, c));
        if (actualCelda.isSur() && f < maxFila) retorno.add(new Posicion(f + 1, c));
        if (actualCelda.isEste() && c < maxCol) retorno.add(new Posicion(f, c + 1));
        if (actualCelda.isOeste() && c > 0) retorno.add(new Posicion(f, c - 1));

        return retorno;
    }
}