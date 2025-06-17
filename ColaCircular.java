import java.util.NoSuchElementException;

public class ColaCircular<T> {

    private class Nodo {
        T valor;
        Nodo siguiente;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    private Nodo frente = null;
    private Nodo fin = null;
    private int size = 0;

    public void encolar(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (estaVacia()) {
            frente = fin = nuevo;
            fin.siguiente = frente;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
            fin.siguiente = frente;
        }
        size++;
    }

    public T desencolar() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        T valor = frente.valor;
        if (frente == fin) {
            frente = fin = null;
        } else {
            frente = frente.siguiente;
            fin.siguiente = frente;
        }
        size--;
        return valor;
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