package backtracking.ejercicio8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Piramide {
    private HashSet<Integer>visitados;
    private int[][] piramide;

    public Piramide() {
        this.visitados = new HashSet<>();
    }

    public int[][] getPiramide(List<Integer> numeros,int B,int k) {
        visitados.clear();
        piramide = new int[B][B];

        if(rellenarPiramide(numeros,B,0,0,k)) {
            return piramide;
        }

        return null;
    }

    private boolean rellenarPiramide(List<Integer> numeros,int B,int fila,int col,int k) {
        //condicion de corte
        if(fila==B){
            return true;
        }

        int proximaFila = fila;
        int proximaCol = col + 1;
        if (proximaCol == B - fila) {
            proximaFila = fila + 1;
            proximaCol = 0;
        }

        if(fila==0){
            for(int i = 0;i < numeros.size();i++) {
                int numero = numeros.get(i);

                if(!visitados.contains(numero) && numero<k){
                    visitados.add(numero);
                    piramide[fila][col] = numero;

                    boolean resultado =rellenarPiramide(numeros,B,proximaFila,proximaCol,k);

                    if(resultado){
                        return true;
                    }

                    visitados.remove(numero);
                    piramide[fila][col] = 0;
                }
            }
        }else{
            //si la fila no es la primera, entonces arranco a hacer las sumas
            int sumaCalculada = piramide[fila - 1][col] + piramide[fila - 1][col + 1];

            if(sumaCalculada<k && !visitados.contains(sumaCalculada)){
                visitados.add(sumaCalculada);
                piramide[fila][col] = sumaCalculada;

                boolean resultado=rellenarPiramide(numeros,B,proximaFila,proximaCol,k);

                if(resultado){
                    return true;
                }

                visitados.remove(sumaCalculada);
                piramide[fila][col] = 0;
            }
        }

        return false;
    }
}
