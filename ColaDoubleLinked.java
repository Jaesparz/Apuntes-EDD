import java.util.NoSuchElementException;

public class ColaDoubleLinked<T> {

    private class Nodo {
        T valor;
        Nodo siguiente, anterior;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    private Nodo frente = null;
    private Nodo fin = null;
    private int size = 0;

    public void encolar(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (fin != null) {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
        } else {
            frente = nuevo;
        }
        fin = nuevo;
        size++;
    }

    public T desencolar() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        T val = frente.valor;
        frente = frente.siguiente;
        if (frente != null) frente.anterior = null;
        else fin = null;
        size--;
        return val;
    }

    public T frente() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return frente.valor;
    }

    public T finalCola() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return fin.valor;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int size() {
        return size;
    }
}