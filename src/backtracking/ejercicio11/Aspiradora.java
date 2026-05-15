package backtracking.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Aspiradora {
    private int[][] mapa = {
            {0, 0, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0}
    };

    private List<List<Integer>> mejorCamino;
    private List<List<Integer>> solParcial;

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public Aspiradora() {
        mejorCamino = new ArrayList<>();
        solParcial = new ArrayList<>();
    }

    public List<List<Integer>> getResultado(int inicioX, int inicioY, int baseX, int baseY) {
        mejorCamino.clear();
        solParcial.clear();

        List<Integer> inicio = new ArrayList<>();
        inicio.add(inicioX);
        inicio.add(inicioY);
        solParcial.add(inicio);
        mapa[inicioX][inicioY] = -1;
        backtracking(inicioX, inicioY, baseX, baseY);

        return mejorCamino;
    }

    private void backtracking(int xActual, int yActual, int baseX, int baseY) {

    }
}