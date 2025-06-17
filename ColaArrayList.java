import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ColaArrayList<T> {
    private ArrayList<T> lista = new ArrayList<>();

    public void encolar(T elemento) {
        lista.add(elemento); // se agrega al final
    }

    public T desencolar() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return lista.remove(0); // se elimina del frente
    }

    public T frente() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return lista.get(0);
    }

    public T finalCola() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return lista.get(lista.size() - 1);
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}