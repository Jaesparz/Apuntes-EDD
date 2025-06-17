import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PilaLinkedList<T> {
    private LinkedList<T> lista = new LinkedList<>();

    public void push(T elemento) {
        lista.addLast(elemento);
    }

    public T pop() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return lista.removeLast();
    }

    public T peek() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return lista.getLast();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}