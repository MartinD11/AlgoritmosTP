package greedy.mochilaFraccionaria;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    public List<Objeto> getSolucion(List<Objeto> candidatos, double pesoMax) {
        List<Objeto> solucion = new ArrayList<>();
        double pesoActual = 0;
        int indice = 0;

        candidatos.sort((o1, o2) -> Double.compare(o2.getRatio(), o1.getRatio()));

        while (indice < candidatos.size() && pesoActual < pesoMax) {
            Objeto o1 = candidatos.get(indice);

            // CASO 1: Entra entero
            if (pesoActual + o1.getPeso() <= pesoMax) {
                solucion.add(o1);
                pesoActual += o1.getPeso(); // ¡No te olvides de esta suma!
                indice++;
            }
            else {
                double espacioLibre = pesoMax - pesoActual;
                double fraccion = espacioLibre / o1.getPeso();
                double valorFraccionado = o1.getValor() * fraccion;

                Objeto oFraccionado = new Objeto(espacioLibre, valorFraccionado);

                solucion.add(oFraccionado);

                pesoActual = pesoMax;
            }
        }

        return solucion;
    }

}
