package backtracking.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class subconjuntos {
    private List<Integer> numeros;
    private List<Integer> solParcial;
    private List<List<Integer>> resultado;

    public subconjuntos() {
        numeros = new ArrayList<Integer>();
        solParcial = new ArrayList<Integer>();
        resultado = new ArrayList<List<Integer>>();
    }

    public List<List<Integer>> getResultado(List<Integer> conjunto, int n) {
        this.numeros = conjunto;
        solParcial.clear();
        resultado.clear();

        backtracking(n, 0, 0);

        return resultado;
    }

    private void backtracking(int n, int indice, int suma) {
        if(suma == 0 && solParcial.size() == n){
            resultado.add(new ArrayList<>(solParcial));
        }

        for(int i = indice; i < numeros.size(); i++){
            int sumaActual = suma + numeros.get(i);

            if(!(solParcial.size() == n)){
                solParcial.add(numeros.get(i));
                backtracking(n, i + 1, sumaActual);
                solParcial.remove(solParcial.size() - 1);
            }
        }
    }
}