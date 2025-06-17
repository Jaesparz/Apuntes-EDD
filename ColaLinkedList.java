import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ColaLinkedList<T> {
    private LinkedList<T> lista = new LinkedList<>();

    public void encolar(T elemento) {
        lista.addLast(elemento);
    }

    public T desencolar() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return lista.removeFirst();
    }

    public T frente() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return lista.getFirst();
    }

    public T finalCola() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return lista.getLast();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}