package backtracking.ejercicio7;

import java.util.HashSet;

public class RellenarMatriz {
    private int[][] matriz;
    private HashSet<Integer> visitados;
    private int[] sumasFila;
    private int[] sumasCol;

    public RellenarMatriz(){
        visitados = new HashSet<>();
        sumasFila = new int[0];
        sumasCol = new int[0];
        matriz = new int[0][0];
    }

    public int[][] rellenarMatriz(int [] num, int S, int tamanio){
        visitados.clear();
        matriz = new int[tamanio][tamanio];
        sumasFila = new int[tamanio];
        sumasCol = new int[tamanio];
        boolean rellenada = false;

        if(num.length > tamanio * tamanio){
            rellenada = backtracking(num, S, 0, 0);
        }

        if(rellenada){
            return matriz;
        }

        return null;
    }

    private boolean backtracking(int [] num, Integer S, int fila, int col){
        if(fila == matriz.length){
            return true;
        }

        for(int i = 0; i < num.length; i++){
            int numeroActual = num[i];

            if(!visitados.contains(numeroActual)){

                int sumaFila = sumasFila[fila] + numeroActual;
                int sumaCol = sumasCol[col] + numeroActual;

                boolean filaValida = sumaFila <= S;
                boolean colValida = sumaCol <= S;

                if (col == matriz.length - 1 && sumaFila != S) {
                    filaValida = false;
                }

                if (fila == matriz.length - 1 && sumaCol != S) {
                    colValida = false;
                }

                if(filaValida && colValida){
                    visitados.add(numeroActual);
                    sumasFila[fila] += numeroActual;
                    sumasCol[col] += numeroActual;
                    matriz[fila][col] = numeroActual;

                    int proximaFila = fila;
                    int proximaCol = col + 1;

                    if (proximaCol == matriz.length) {
                        proximaFila = fila + 1;
                        proximaCol = 0;
                    }

                    boolean funciono = backtracking(num, S, proximaFila, proximaCol);
                    if(funciono){
                        return true;
                    }

                    visitados.remove(numeroActual);
                    sumasFila[fila] -= numeroActual;
                    sumasCol[col] -= numeroActual;
                    matriz[fila][col] = 0;
                }
            }
        }
        return false;
    }
}