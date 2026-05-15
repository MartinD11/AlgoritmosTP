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

        if (!mejorCamino.isEmpty() && solParcial.size() >= mejorCamino.size()) {
            return;
        }

        if (xActual == baseX && yActual == baseY) {
            mejorCamino = new ArrayList<>(solParcial);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nuevoX = xActual + dx[i];
            int nuevoY = yActual + dy[i];


            if (nuevoX >= 0 && nuevoX < mapa.length && nuevoY >= 0 && nuevoY < mapa[0].length) {

                if (mapa[nuevoX][nuevoY] == 0) {
                    List<Integer> paso = new ArrayList<>();
                    paso.add(nuevoX);
                    paso.add(nuevoY);
                    solParcial.add(paso);
                    mapa[nuevoX][nuevoY] = -1;

                    backtracking(nuevoX, nuevoY, baseX, baseY);

                    mapa[nuevoX][nuevoY] = 0;
                    solParcial.remove(solParcial.size() - 1);
                }
            }
        }
    }
}