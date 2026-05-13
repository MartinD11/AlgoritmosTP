package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Ejercicio3<T> {
    /*Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.*/
    private HashMap<Integer,String> visitados = new HashMap<>();

    public boolean tieneCiclo(GrafoDirigido<T> grafo){
        //paso 1: poner a todos los vertices como no visitados
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer vertice = vertices.next();
            visitados.put(vertice,"BLANCO");
        }

        //recorro los vertices para buscar en profundidad
        Iterator<Integer> vertices2 = grafo.obtenerVertices();
        while(vertices2.hasNext()){
            Integer vertice2 = vertices2.next();
            if(visitados.get(vertice2).equals("BLANCO")){
                if(dfs_visit(grafo,vertice2)){
                    return true;
                }

            }
        }

        return false;
    }

    private boolean dfs_visit(GrafoDirigido<T> grafo, Integer vertice){
        visitados.put(vertice,"AMARILLO");

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);

        while(adyacentes.hasNext()){
            Integer vertice2 = adyacentes.next();
            String color = visitados.get(vertice2);
            if(color.equals("BLANCO")){
                if(dfs_visit(grafo,vertice2)){
                    return true;
                }
                //aca se ve si existe el ciclo o no
            }else if(color.equals("AMARILLO")){
                return true;
            }
        }

        visitados.put(vertice,"NEGRO");
        return false;
    }
}
