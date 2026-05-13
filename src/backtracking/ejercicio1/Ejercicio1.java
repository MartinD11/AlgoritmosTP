package backtracking.ejercicio1;

import grafos.GrafoDirigido;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ejercicio1<T> {
    private ArrayList<Integer> solucionFinal;
    private HashSet<Integer> visitados;

    public Ejercicio1() {
        this.solucionFinal = new ArrayList<>();
        this.visitados = new HashSet<>();
    }

    public ArrayList<Integer> caminoMasLargo(GrafoDirigido<T> grafo,Integer origen, Integer destino){
        visitados.clear();
        solucionFinal.clear();

        ArrayList<Integer> solParcial = new ArrayList<>();

        visitados.add(origen);
        solParcial.add(origen);

        backtracking(grafo,origen,destino,solParcial);

        return solucionFinal;

    }

    private void  backtracking (GrafoDirigido<T> grafo,Integer origen, Integer destino,ArrayList<Integer> solParcial){

        if(origen.equals(destino)){
            if(solParcial.size()>solucionFinal.size()){
                solucionFinal.clear();
                solucionFinal.addAll(solParcial);
            }
            return;
        }

        Iterator<Integer> ady = grafo.obtenerAdyacentes(origen);

        while(ady.hasNext()){
            Integer vecino=ady.next();

            if(!visitados.contains(vecino)){
                visitados.add(vecino);
                solParcial.add(vecino);

                backtracking(grafo,vecino,destino,solParcial);

                visitados.remove(vecino);
                solParcial.remove(solParcial.size()-1);
                //podria utilizar removeLast();
            }


        }


    }
}
