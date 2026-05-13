package backtracking.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    private List<Integer> numeros;

    public Ejercicio4() {
        numeros = new ArrayList<>();
    }

    public boolean solve(){
        int m;
        boolean result =false;
        int calculo =0;

        for (int i = 0; i < numeros.size(); i++) {
            calculo += numeros.get(i);
        }

        if(calculo % 2 == 0 ){
            calculo = calculo / 2;
            result =conjuntoDisjuntos(numeros,0,0,calculo);
        }else{
            return false;
        }
        return result;
    }

    private boolean conjuntoDisjuntos(List<Integer> numeros,int suma,int indice,int M){
        if(suma==M){
            return true;
        }else{
            for (int i = indice; i < numeros.size(); i++) {
                int sumaNueva = suma + numeros.get(i);

                if(sumaNueva <= M){
                    boolean exito = conjuntoDisjuntos(numeros,sumaNueva,i+1,M);
                    if(exito){
                        return  true;
                    }
                }
            }
        }
        return false;

    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

}
