package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer,Vertice<T>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<Integer,Vertice<T>>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if(!vertices.containsKey(verticeId)) {
            vertices.put(verticeId,new Vertice<T>(verticeId));
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if(vertices.containsKey(verticeId)) {
            deleteArcosEntrantes(verticeId);
            vertices.remove(verticeId);
        }
    }

    public void deleteArcosEntrantes(int verticeId){
        for (Vertice<T> v : vertices.values()) {
            if(v.getIdVertice()!=verticeId){
                v.borarArco(verticeId);
            }
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arcoAux = new Arco<>(verticeId1,verticeId2,etiqueta);

        if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2))  {
            if(!vertices.get(verticeId1).existeArco(verticeId2)) {
                vertices.get(verticeId1).addArco(arcoAux);
            }
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1)){
            vertices.get(verticeId1).borarArco(verticeId2);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1)){
            return vertices.get(verticeId1).existeArco(verticeId2);
        }else{
            return false;
        }
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        Arco<T> arcoAux = null;

        if(vertices.containsKey(verticeId1)){
            arcoAux = vertices.get(verticeId1).getArco(verticeId2);
        }
        return arcoAux;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
       int cantidad = 0;

       for (Vertice<T> v : vertices.values()) {
           cantidad+= v.gerCantArcos();
       }

       return cantidad;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Vertice<T> v : vertices.values()) {
            arr.add(v.getIdVertice());
        }
        return arr.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        Vertice<T> v = vertices.get(verticeId);

        if(v!=null){
            ArrayList<Integer> adyacentes  =new ArrayList<>();
            for (Arco<T> arco: v.getArcos()) {
                adyacentes.add(arco.getVerticeDestino());
            }
            return adyacentes.iterator();
        }
        return new ArrayList<Integer>().iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcosAux = new ArrayList<>();

        for (Vertice<T> v : vertices.values()) {
            arcosAux.addAll(v.getArcos());
        }
        return arcosAux.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        ArrayList<Arco<T>> arcosAux = new ArrayList<>();
        if(vertices.containsKey(verticeId)){
            arcosAux.addAll(vertices.get(verticeId).getArcos());
        }
        return arcosAux.iterator();
    }

    @Override
    public String toString() {
        return "GrafoDirigido{" +
                "vertices=" + vertices +
                '}';
    }

}
