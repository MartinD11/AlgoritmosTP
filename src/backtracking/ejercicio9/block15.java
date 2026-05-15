package backtracking.ejercicio9;

import java.util.ArrayList;
import java.util.List;

public class block15 {
    private int[][] tablero = {
            { 1,  2,  3,  4},
            { 5,  6,  7,  8},
            { 9, 10,  0, 11},
            {13, 14, 15, 12}
    };
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private List<List<Integer>> movimientos;
    private int limite;

    public block15() {
        this.movimientos = new ArrayList<>();
        this.limite=20;
    }


    public List<List<Integer>> getMovimientos() {
        int posx=-1,posY=-1;
        for(int i=0;i<this.tablero.length;i++){
            for(int j=0;j<this.tablero[i].length;j++){
                if(tablero[i][j]==0){
                    posx=i;
                    posY=j;
                }
            }
        }

        boolean resultado =backtracking(posx,posY,-1,-1,movimientos,0);
        if(resultado){
            return movimientos;
        }
        return null;
    }

    public boolean backtracking(int posx, int posy, int posxAnt, int posyAnt, List<List<Integer>> movimientos, int pasos) {
        // Condicion de corte 1: ¡Ganamos!
        if(estaOrdenado(tablero)){
            return true;
        }

        // Condicion de corte 2: Límite de profundidad
        if(pasos > this.limite){
            return false;
        }

        // Exploramos las 4 direcciones
        for(int i = 0; i < 4; i++){
            int nuevox = posx + dx[i];
            int nuevoy = posy + dy[i];

            // VALIDACIÓN: Que no se caiga del tablero Y que no vuelva exactamente a la casilla anterior
            if(nuevox >= 0 && nuevox < 4 && nuevoy >= 0 && nuevoy < 4 && !(nuevox == posxAnt && nuevoy == posyAnt)) {

                // --- 1. HACER ---
                // A) Anotamos el paso en el historial
                List<Integer> paso = new ArrayList<>();
                paso.add(nuevox);
                paso.add(nuevoy);
                movimientos.add(paso);

                // B) Movemos el hueco (SWAP)
                int temp = tablero[posx][posy];
                tablero[posx][posy] = tablero[nuevox][nuevoy];
                tablero[nuevox][nuevoy] = temp;

                // --- 2. RECURSIÓN ---
                // Le pasamos las nuevas coordenadas, le decimos de dónde venimos (posx, posy) y sumamos 1 paso
                boolean resultado = backtracking(nuevox, nuevoy, posx, posy, movimientos, pasos + 1);
                if(resultado) {
                    return true;
                }

                // --- 3. DESHACER ---
                // A) Volvemos a intercambiar las piezas para dejar el tablero como estaba
                temp = tablero[posx][posy];
                tablero[posx][posy] = tablero[nuevox][nuevoy];
                tablero[nuevox][nuevoy] = temp;

                // B) Borramos el último paso del historial porque por acá no era la solución
                movimientos.remove(movimientos.size() - 1);
            }
        }

        return false; // Si probó las 4 direcciones y ninguna sirvió, devuelve false
    }


    private boolean estaOrdenado(int[][] tablero) {
        int numeroEsperado = 1; // Arrancamos esperando encontrar el 1

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                // Caso especial: Llegamos a la última casilla (abajo a la derecha)
                if (i == 3 && j == 3) {
                    // Si llegamos acá sin problemas, solo ganamos si esta casilla tiene un 0
                    return tablero[i][j] == 0;
                }

                // Si la casilla actual no tiene el número que toca, perdimos
                if (tablero[i][j] != numeroEsperado) {
                    return false;
                }

                // Si estaba bien, sumamos 1 para buscar el siguiente en la próxima vuelta
                numeroEsperado++;
            }
        }
        return true; // Por estructura nunca va a llegar acá gracias al if (i == 3 && j == 3), pero Java lo pide.
    }

}