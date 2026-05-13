package grafos;

import java.util.*;

public class Ejercicio4<T> {
    /*Ejercicio 4
    Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
    camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el
    grafo de entrada es acíclico.
    Ejercicio
    */

    public List<Integer> caminoMasLArgo(GrafoDirigido<T> grafo, Integer actual,Integer destino){
        HashMap<Integer,List<Integer>> memoria = new HashMap<>();

        return dfs(grafo,actual,destino,memoria);
    }

    private List<Integer> dfs(GrafoDirigido<T> grafo, Integer actual,Integer destino,HashMap<Integer,List<Integer>> memoria){
        if(memoria.containsKey(actual)){
            return memoria.get(actual);
        }

        if(actual==destino){
            List<Integer> caminoDestino = new ArrayList<>();
            caminoDestino.add(actual);
            return caminoDestino;
        }

        List<Integer> mejorCaminoVecinos = new ArrayList<>();
        Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);

        while(ady.hasNext()){
            Integer camino = ady.next();

            List<Integer> caminoDelVecino= dfs(grafo,camino,destino,memoria);

            if(!caminoDelVecino.isEmpty() && caminoDelVecino.size()> mejorCaminoVecinos.size()){
                mejorCaminoVecinos.clear();
                mejorCaminoVecinos.addAll(caminoDelVecino);
            }
        }

        if(mejorCaminoVecinos.isEmpty()){

            memoria.put(actual,new ArrayList<>());
            return new ArrayList<>();
        }

        List<Integer> miCaminoFinal = new ArrayList<>();
        miCaminoFinal.add(actual);
        miCaminoFinal.addAll(mejorCaminoVecinos);

        memoria.put(actual,miCaminoFinal);
        return miCaminoFinal;


    }



}

