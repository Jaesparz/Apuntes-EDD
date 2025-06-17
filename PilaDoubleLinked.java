import java.util.NoSuchElementException;

public class PilaDoubleLinked<T> {

    private class Nodo {
        T valor;
        Nodo anterior, siguiente;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    private Nodo ultimo = null;
    private int size = 0;

    public void push(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (ultimo != null) {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
        }
        ultimo = nuevo;
        size++;
    }

    public T pop() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        T valor = ultimo.valor;
        ultimo = ultimo.anterior;
        if (ultimo != null) ultimo.siguiente = null;
        size--;
        return valor;
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