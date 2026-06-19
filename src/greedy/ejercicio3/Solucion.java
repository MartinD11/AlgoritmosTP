package greedy.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Solucion {

    public List<Actividad> getActividadesPosibles(List<Actividad> candidatos) {

        candidatos.sort((a1, a2) -> Integer.compare(a1.getFin(), a2.getFin()));

        int horaActual = 0;
        int indice = 0;
        List<Actividad> solucion = new ArrayList<>();

        solucion.add(candidatos.get(indice));
        horaActual = candidatos.get(indice).getFin();
        indice++;

        while(indice < candidatos.size()){
            Actividad a1 = candidatos.get(indice);

            if(a1.getInicio() >= horaActual){
                solucion.add(a1);
                horaActual = a1.getFin();
                indice++;
            } else {
                indice++;
            }
        }

        return solucion;
    }
}
