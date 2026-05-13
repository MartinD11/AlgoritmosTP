package listas;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

    private Node<T> navegador;

    public MyIterator(Node<T> node) {
        this.navegador = node;
    }

    @Override
    public boolean hasNext() {
        return this.navegador != null;
    }

    @Override
    public T next() {
        T info = this.navegador.getInfo();
        this.navegador = this.navegador.getNext();
        return info;
    }

    public T get() {
        return this.navegador.getInfo();
    }
}
