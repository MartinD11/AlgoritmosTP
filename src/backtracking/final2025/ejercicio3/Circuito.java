package backtracking.final2025.ejercicio3;

import grafos.GrafoDirigido;
import grafos.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Circuito {
    private ArrayList<Integer> vertices;
    private int mejorCosto = Integer.MAX_VALUE;
    private HashSet<Integer> visitados;
    private ArrayList<Integer> solucion;
    private ArrayList<Integer> solParcial;

    public Circuito() {
        this.vertices = new ArrayList<>();
        this.visitados = new HashSet<>();
        this.solucion = new ArrayList<>();
        this.solParcial = new ArrayList<>();
    }

    public ArrayList<Integer> getCiudades(GrafoNoDirigido<Integer> grafo,Integer origen) {
        Iterator<Integer> vertice = grafo.obtenerVertices();

        while (vertice.hasNext()) {
            Integer v2 =  vertice.next();
            vertices.add(v2);
        }

        visitados.add(origen);
        solParcial.add(origen);

        backtracking(grafo,origen,origen,0);

        return solucion;
    }

    private void backtracking(GrafoNoDirigido<Integer> grafo,Integer origen, Integer actual, int costoActual) {
        //condicion de corte
        if(visitados.size() == this.vertices.size()) {
            if(grafo.existeArco(actual,origen)){
                int costoUltimo = (Integer) grafo.obtenerArco(origen,actual).getEtiqueta();

                int costoTotal = costoUltimo + costoActual;

                if(costoTotal < mejorCosto) {
                    mejorCosto = costoTotal;
                    solucion.clear();
                    solucion.addAll(solParcial);
                    solucion.add(origen);
                }
            }
            return;
        }

        //recorro las opciones
        Iterator<Integer> vertice = grafo.obtenerAdyacentes(actual);
        while (vertice.hasNext()) {
            Integer v2 =  vertice.next();
            if(!visitados.contains(v2) && costoActual < mejorCosto) {
                int  costo = (Integer) grafo.obtenerArco(actual,v2).getEtiqueta();

                if(costo + costoActual < mejorCosto) {
                    visitados.add(v2);
                    solParcial.add(v2);

                    backtracking(grafo,origen,v2,costo+costoActual);

                    visitados.remove(v2);
                    solParcial.removeLast();
                }
            }
        }

    }
}
