package greedy;

import grafos.Grafo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ColoreoGrafo {
    public HashMap<Integer, String> colorear(List<Integer> vertices, List<String> colores, Grafo grafo) {
        HashMap<Integer, String> grafoColoreado = new HashMap<>();

        for(Integer v : vertices) {
            boolean pintado = false;
            int i = 0;

            while (i < colores.size() && !pintado) {
                String c = colores.get(i);

                if (colorValido(v, c, grafoColoreado, grafo)) {
                    grafoColoreado.put(v, c);
                    pintado = true;
                }
                i++;
            }

            if (!pintado) {
                System.out.println("Faltan colores para el vértice: " + v);
            }
        }

        return grafoColoreado;
    }

    public boolean colorValido(Integer vertice, String colorAProbar, HashMap<Integer, String> coloreado, Grafo grafo) {
        Iterator<Integer> ady = grafo.obtenerAdyacentes(vertice);

        while(ady.hasNext()) {
            Integer vecino = ady.next();

            if (coloreado.containsKey(vecino)) {
                if (coloreado.get(vecino).equals(colorAProbar)) {
                    return false;
                }
            }
        }

        return true;
    }
}
