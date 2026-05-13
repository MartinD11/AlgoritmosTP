package grafos;

import java.util.ArrayList;

public class Vertice<T> {
    private ArrayList<Arco<T>> arcos;
    private int idVertice;

    public Vertice(int idVertice) {
        this.arcos= new ArrayList<Arco<T>>();
        this.idVertice = idVertice;
    }

    public void addArco(Arco<T> arco){
        this.arcos.add(arco);
    }

    public int getIdVertice() {
        return idVertice;
    }

    public int gerCantArcos(){
        return arcos.size();
    }

    public ArrayList<Arco<T>> getArcos() {
        ArrayList<Arco<T>> copia = new ArrayList<>();
        copia.addAll(arcos);
        return copia;
    }

    public void borarArco(int idVertice){
        Arco<T> arcoAux = null;
        if(this.existeArco(idVertice)){
            for(Arco<T> arco: arcos){
                if (arco.getVerticeDestino() == idVertice){
                    arcoAux = arco;
                    break;
                }
            }
            arcos.remove(arcoAux);
        }
    }

    public boolean existeArco(int idVertice){
        boolean adyacente = false;
        for(Arco<T> arco : arcos){
            if(arco.getVerticeDestino() == idVertice){
                adyacente = true;
            }
        }
        return adyacente;
    }

    public Arco<T> getArco(int idVertice){
        if(this.existeArco(idVertice)){
            for(Arco<T> arco: arcos){
                if(arco.getVerticeDestino() == idVertice){
                    return arco;
                }
            }
        }
        return null;
    }


}
