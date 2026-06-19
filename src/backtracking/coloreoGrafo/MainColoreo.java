package backtracking.coloreoGrafo;

import grafos.Grafo;
import grafos.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainColoreo {
    private List<Integer> vertices;
    private HashMap<Integer, Integer> solucion;
    private HashMap<Integer, Integer> solPArcial;
    private List<Integer> colores;
    private int maxColores = Integer.MAX_VALUE;

    public MainColoreo() {
        this.vertices = new ArrayList<>();
        this.solucion = new HashMap<>();
        this.colores = new ArrayList<>();
        this.solPArcial = new HashMap<>();
    }

    public HashMap<Integer, Integer> getVerticesPintados(GrafoNoDirigido grafo) {
        Iterator<Integer> vertice = grafo.obtenerVertices();

        while (vertice.hasNext()) {
            this.vertices.add(vertice.next());
        }

        backtracking(grafo,0,0);

        return solucion;
    }

    private void backtracking(GrafoNoDirigido grafo, int indice,int maxColorParcial){
        //condicion de corte
        if(indice==vertices.size()){
            solucion.clear();
            solucion = new HashMap<>(solPArcial);
            maxColores = maxColorParcial;
            return;
        }

        Integer verticeActual = vertices.get(indice);
        //recorro las posibles soluciones y podo de ser posible
        for(int i= 1; i<vertices.size(); i++){
            if(esPosibleColorear(grafo,verticeActual,i)){
                int nuevoMax = Math.max(maxColorParcial, i);
                if((nuevoMax<maxColores)){
                    solPArcial.put(verticeActual,i);

                    backtracking(grafo,indice+1,nuevoMax);

                    solPArcial.remove(verticeActual);
                }
            }
        }
    }

    private boolean esPosibleColorear(GrafoNoDirigido grafo, Integer verticeActual, int indice){
        Iterator<Integer> ady =grafo.obtenerAdyacentes(verticeActual);

        while(ady.hasNext()){
            Integer vecino = ady.next();

            if(solPArcial.containsKey(vecino) && solPArcial.get(vecino)==indice){
                return false;
            }
        }
        return true;
    }
}
