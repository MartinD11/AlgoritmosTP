package grafos;

import java.util.*;

public class Ejercicio5<T> {
    /*Ejercicio 5
    Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
    con todos los vértices a partir de los cuales exista un camino en G que termine en v.
    */

    public List<Integer> caminosPosibles(GrafoDirigido<T> grafo, Integer destino){
        List<Integer> validos=new ArrayList<>();

        //obtenemos los vertices del grafo
        Iterator<Integer> vertices = grafo.obtenerVertices();

        while(vertices.hasNext()){
            Integer posibleOrigen = vertices.next();

            //si los vertices son distintos de destino, los recorremos
            if(!posibleOrigen.equals(destino)){
                //cada vertice va a tener una lista de visitados nueva
                HashSet<Integer> visitados= new HashSet<>();
                //consultamos si es posible llegar a destino, de ser asi, agregamos el posible valor a la lista de validos
                if(caminos(grafo, posibleOrigen, destino, visitados)){
                    validos.add(posibleOrigen);
                }
            }
        }

        return validos;
    }

    public boolean caminos(GrafoDirigido<T> grafo,Integer actual,Integer destino,HashSet<Integer> visitados){
        visitados.add(actual);

        if(actual.equals(destino)){
            return true;
        }

        Iterator<Integer> ady  = grafo.obtenerAdyacentes(actual);
        while(ady.hasNext()){
            Integer vecino=ady.next();

            if(!visitados.contains(vecino)){
                //derivamos la logica a los "vertices vecinos" y si encuentran el destino
                //con la recursion, se van a ir devolviendo los true y el vertice actual, va a ser valido
                if(caminos(grafo, vecino, destino, visitados)){
                    return true;
                }
            }
        }
        return false;

    }
}
