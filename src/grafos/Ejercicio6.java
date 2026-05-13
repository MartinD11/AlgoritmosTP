package grafos;

import java.util.*;

public class Ejercicio6<T> {

    private Queue<Integer> cola;
    private HashSet<Integer> visitados;

    public Ejercicio6() {
        this.cola = new LinkedList<>();
        this.visitados = new HashSet<>();
    }

    public List<Integer> caminoMasCorto(GrafoDirigido<T> grafo, Integer inicio, Integer fin) {
        cola.clear();
        visitados.clear();

        HashMap<Integer, Integer> deDondeVine = new HashMap<>();

        cola.add(inicio);
        visitados.add(inicio);

        while(!cola.isEmpty()){
            Integer actual = cola.poll();

            if(actual.equals(fin)){
                return armarCaminoFinal(deDondeVine, inicio, fin);
            }

            Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
            while(ady.hasNext()){
                Integer vecino = ady.next();

                if(!visitados.contains(vecino)){
                    visitados.add(vecino);
                    cola.add(vecino);
                    deDondeVine.put(vecino, actual);
                }
            }
        }

        return new ArrayList<>();
    }

    private List<Integer> armarCaminoFinal(HashMap<Integer, Integer> deDondeVine, Integer inicio, Integer fin) {
        List<Integer> camino = new ArrayList<>();
        Integer pasoActual = fin;

        while(pasoActual != null) {
            camino.add(pasoActual);

            if (pasoActual.equals(inicio)) {
                break;
            }

            pasoActual = deDondeVine.get(pasoActual);
        }

        Collections.reverse(camino);

        return camino;
    }
}