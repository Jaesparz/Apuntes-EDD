import java.util.NoSuchElementException;

public class ColaDoubleCircular<T> {

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
        if (estaVacia()) {
            frente = fin = nuevo;
            frente.siguiente = frente.anterior = frente;
        } else {
            nuevo.anterior = fin;
            nuevo.siguiente = frente;
            fin.siguiente = nuevo;
            frente.anterior = nuevo;
            fin = nuevo;
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
            frente.anterior = fin;
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