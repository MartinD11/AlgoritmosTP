package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DFS<T> {
    private HashMap<Integer,String> visitados = new HashMap<>();

    public List<Integer> dfsVisitar(GrafoDirigido<T> grafo){
        //paso 1: poner a todos los vertices como no visitados
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer vertice = vertices.next();
            visitados.put(vertice,"BLANCO");
        }

        List<Integer> recorridoFinal = new ArrayList<>();

        //recorro los vertices para buscar en profundidad
        Iterator<Integer> vertices2 = grafo.obtenerVertices();
        while(vertices2.hasNext()){
            Integer vertice2 = vertices2.next();
            if(visitados.get(vertice2).equals("BLANCO")){
                dfs_visit(grafo,vertice2,recorridoFinal);
            }
        }

        return recorridoFinal;
    }

    private void dfs_visit(GrafoDirigido<T> grafo, Integer vertice, List<Integer> recorridoFinal){
        visitados.put(vertice,"AMARILLO");
        recorridoFinal.add(vertice);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);

        while(adyacentes.hasNext()){
            Integer vertice2 = adyacentes.next();
            String color = visitados.get(vertice2);
            if(color.equals("BLANCO")){
                dfs_visit(grafo,vertice2,recorridoFinal);
            }
        }

        visitados.put(vertice,"NEGRO");
    }
}
