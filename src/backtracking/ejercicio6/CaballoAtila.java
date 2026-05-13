package backtracking.ejercicio6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CaballoAtila {
    private HashSet<Posicion> visitados;
    private List<Posicion> solParcial;
    private List<Posicion> resultado;
    private int cantCaminos;
    private boolean[][] campo;
    private boolean solEncontrada;

    public CaballoAtila(boolean[][] mapaInicial){
        cantCaminos = 0;
        visitados = new HashSet<Posicion>();
        solParcial = new ArrayList<Posicion>();
        campo = mapaInicial;
        this.resultado = new ArrayList<>();
        this.solEncontrada = false;
    }

    public List<Posicion> getCamino(Posicion origen) {
        this.cantCaminos = this.getCantCaminos();

        visitados.clear();
        solParcial.clear();

        visitados.add(origen);
        solParcial.add(origen);

        backtracking(origen,origen);

        return resultado;
    }

    private void backtracking(Posicion origen, Posicion actual) {
        //inicio de una con un for porque es la unica manera que puedo completar el camino
        //sin que me salga el error de que origen ya fue visitado y por lo tanto
        //no podria completar el camino completo

        for(Posicion movValido : this.movimientosValidos(actual)){

            //condicion de corte:
            if(origen.equals(movValido) && solParcial.size()==this.cantCaminos) {
                this.resultado.addAll(solParcial);
                this.solEncontrada = true;
                return;
            }

            //poda
            if(!this.visitados.contains(movValido)){
                this.visitados.add(movValido);
                solParcial.add(movValido);

                backtracking(origen,movValido);

                if(solEncontrada){
                    return;
                }

                this.visitados.remove(movValido);
                this.solParcial.removeLast();
            }

        }
    }

    private List<Posicion> movimientosValidos(Posicion actual) {
        List<Posicion> movValidos = new ArrayList<>();

        // Las 4 direcciones posibles (Arriba, Abajo, Izquierda, Derecha)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int xActual = actual.getX();
        int yActual = actual.getY();

        // Iteramos sobre las 4 puertas
        for (int i = 0; i < 4; i++) {
            int nuevoX = xActual + dx[i];
            int nuevoY = yActual + dy[i];

            // 1. Filtro Espacial: ¿Me caigo del mapa?
            if (nuevoX >= 0 && nuevoX < this.campo.length && nuevoY >= 0 && nuevoY < this.campo[0].length) {

                // 2. Filtro Lógico: ¿Es tierra pisable (true)?
                if (this.campo[nuevoX][nuevoY]) {
                    movValidos.add(new Posicion(nuevoX, nuevoY));
                }
            }
        }

        return movValidos;
    }


    public int getCantCaminos(){
        cantCaminos = 0;

        for (boolean[] booleans : campo) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    cantCaminos++;
                }
            }
        }

        return cantCaminos;
    }
}

