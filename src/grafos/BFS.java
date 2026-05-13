package grafos;

import java.util.*;

public class BFS<T> {
    private Queue<Integer> cola;
    private HashSet<Integer> visitados;

    public BFS() {
        this.cola = new LinkedList<>();
        this.visitados = new HashSet<>();
    }

    public List<Integer> bfs(GrafoDirigido<T> grafo) {
        cola.clear();
        visitados.clear();

        List<Integer> recorridoFinal  = new LinkedList<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer vertice  = vertices.next();

            if(!visitados.contains(vertice)){
                bfs_visit(grafo,vertice,recorridoFinal);
            }

        }
        return recorridoFinal;
    }

    private void bfs_visit(GrafoDirigido<T> grafo, Integer vertice, List<Integer> recorridoFinal) {
        recorridoFinal.add(vertice);
        visitados.add(vertice);
        cola.add(vertice);

        while(!cola.isEmpty()){
            Integer vertice2 = cola.poll();

            Iterator<Integer> ady = grafo.obtenerAdyacentes(vertice2);
            while(ady.hasNext()){
                Integer vertice3 = ady.next();
                if(!visitados.contains(vertice3)){
                    visitados.add(vertice3);
                    cola.add(vertice3);
                }
            }
        }
    }
}
