package listas;

public class MySimpleLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size = this.size+1;
    }

    public T extractFront() {
        if(this.first == null)
            return null;
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--;
        return info;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        if(index < 0 || index >= this.size){
            return null;
        }

        int contador = 0;
        Node<T> tmp  =this.first;

        while(contador < index){
            tmp = tmp.getNext();
            contador++;
        }
        return tmp.getInfo();

    }

    public int size() {
        // ya hecho con una variable size que me da una complejidad de O(1)
        return 0;
    }

    public int indexOf(T info){
        int contador = 0;
        Node<T> tmp = this.first;

        while(contador < this.size){
            if(tmp.getInfo().equals(info)){
                return contador;
            }
            tmp = tmp.getNext();
            contador++;
        }

        return -1;
    }

    public void insertInOrder(T info) {
        if(this.first == null || (Integer) info <= (Integer) this.first.getInfo()){
            this.insertFront(info);
            return;
        }
        Node<T> prev = this.first;
        Node<T> actual = this.first;

        while(actual!=null && (Integer) actual.getInfo() < (Integer) info){
            prev = actual;
            actual = actual.getNext();
        }

        Node<T> tmp = new Node<T>(info,actual);
        prev.setNext(tmp);

        this.size++;
    }

    @Override
    public MyIterator iterator(){
        return new MyIterator(this.first);
    }

    @Override
    public String toString() {
        // 1. Tu validación inicial
        if (this.first == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int contador = 0;
        Node<T> tmp = this.first;

        while (contador < this.size) {
            sb.append(tmp.getInfo());

            if (contador < this.size - 1) {
                sb.append(", ");
            }

            tmp = tmp.getNext();
            contador++;
        }

        sb.append("]"); // Cerramos el corchete
        return sb.toString(); // Retornamos el String definitivo
    }



    public int getSize() {
        return this.size;
    }

}
