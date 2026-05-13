package backtracking.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    private List<List<Integer>> resultados;
    private List<Integer> solParcial;
    private final int M=5;

    public Ejercicio3() {
        this.resultados = new ArrayList<>();
        this.solParcial = new ArrayList<>();
    }

    public List<List<Integer>> getResultados(List<Integer> numeros) {

        obtenerConjuntos(resultados,solParcial,M,0,0,numeros);

        return resultados;
    }

    private void obtenerConjuntos(List<List<Integer>> resultados, List<Integer> solParcial, int M, int suma, int indice, List<Integer> numeros) {
        if(suma==M){
            resultados.add(new ArrayList<>(solParcial));
        }else{

            for(int i=indice;i<numeros.size();i++){
                int sumanueva = suma + numeros.get(i);

                if(sumanueva<=M){
                    solParcial.add(numeros.get(i));
                    obtenerConjuntos(resultados,solParcial,M,sumanueva,i+1,numeros);
                    solParcial.remove(solParcial.size()-1);
                }
            }

        }
    }

    @Override
    public String toString() {
        return "Ejercicio3{" +
                "resultados=" + resultados +
                '}';
    }
}
