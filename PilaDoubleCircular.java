import java.util.NoSuchElementException;

public class PilaDoubleCircular<T> {

    private class Nodo {
        T valor;
        Nodo siguiente, anterior;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    private Nodo ultimo = null;
    private int size = 0;

    public void push(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (ultimo == null) {
            nuevo.siguiente = nuevo.anterior = nuevo;
            ultimo = nuevo;
        } else {
            Nodo primero = ultimo.siguiente;
            nuevo.anterior = ultimo;
            nuevo.siguiente = primero;
            ultimo.siguiente = nuevo;
            primero.anterior = nuevo;
            ultimo = nuevo;
        }
        size++;
    }

    public T pop() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        T val = ultimo.valor;
        if (ultimo.siguiente == ultimo) {
            ultimo = null;
        } else {
            Nodo nuevoUltimo = ultimo.anterior;
            nuevoUltimo.siguiente = ultimo.siguiente;
            ultimo.siguiente.anterior = nuevoUltimo;
            ultimo = nuevoUltimo;
        }
        size--;
        return val;
    }

    public T peek() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return ultimo.valor;
    }

    public boolean estaVacia() {
        return ultimo == null;
    }

    public int size() {
        return size;
    }
}