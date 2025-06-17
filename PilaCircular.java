import java.util.NoSuchElementException;

public class PilaCircular<T> {

    private class Nodo {
        T valor;
        Nodo siguiente;

        Nodo(T valor) {
            this.valor = valor;
            this.siguiente = this;
        }
    }

    private Nodo ultimo = null;
    private int size = 0;

    public void push(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (ultimo == null) {
            ultimo = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        size++;
    }

    public T pop() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        Nodo primero = ultimo.siguiente;
        if (primero == ultimo) {
            T val = primero.valor;
            ultimo = null;
            size--;
            return val;
        }
        while (ultimo.siguiente != primero) {
            ultimo = ultimo.siguiente;
        }
        T val = primero.valor;
        ultimo.siguiente = primero.siguiente;
        size--;
        return val;
    }

    public T peek() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return ultimo.siguiente.valor;
    }

    public boolean estaVacia() {
        return ultimo == null;
    }

    public int size() {
        return size;
    }
}