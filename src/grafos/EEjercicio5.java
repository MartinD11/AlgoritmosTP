package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EEjercicio5<T> {

    // El Envase: Prueba todos los vértices a ver cuáles llegan a 'v'
    public List<Integer> verticesQueLleganA(GrafoDirigido<T> grafo, Integer destino) {
        List<Integer> validos = new ArrayList<>();

        Iterator<Integer> todosLosVertices = grafo.obtenerVertices();

        while (todosLosVertices.hasNext()) {
            Integer posibleOrigen = todosLosVertices.next();

            // Evitamos probar si el destino llega a sí mismo (opcional, según criterio de la cátedra)
            if (!posibleOrigen.equals(destino)) {

                // IMPORTANTE: Cada origen necesita su propia lista de visitados limpia
                // para su propia búsqueda independiente
                HashSet<Integer> visitados = new HashSet<>();

                // Si el motor dice que desde este origen se llega al destino, lo guardo
                if (dfs_llegaAlDestino(grafo, posibleOrigen, destino, visitados)) {
                    validos.add(posibleOrigen);
                }
            }
        }
        return validos;
    }

    // El Motor: Un DFS clásico que se frena ni bien encuentra el destino
    private boolean dfs_llegaAlDestino(GrafoDirigido<T> grafo, Integer actual, Integer destino, HashSet<Integer> visitados) {
        // 1. Marco el nodo actual como visitado
        visitados.add(actual);

        // 2. ¡Caso base de éxito! Si estoy parado en el destino, devuelvo true
        if (actual.equals(destino)) {
            return true;
        }

        // 3. Si no llegué, recorro mis vecinos buscando una salida
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer vecino = adyacentes.next();

            if (!visitados.contains(vecino)) {
                // Magia recursiva: le paso la pelota a mi vecino.
                // Si mi vecino logra llegar al destino, entonces yo también llego (devuelvo true).
                if (dfs_llegaAlDestino(grafo, vecino, destino, visitados)) {
                    return true;
                }
            }
        }

        // 4. Si revisé todos mis vecinos y ninguno llegó al destino, devuelvo false
        return false;
    }
}
