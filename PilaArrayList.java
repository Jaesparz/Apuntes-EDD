import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PilaArrayList<T> {
    private ArrayList<T> lista = new ArrayList<>();

    public void push(T elemento) {
        lista.add(elemento);
    }

    public T pop() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return lista.remove(lista.size() - 1);
    }

    public T peek() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return lista.get(lista.size() - 1);
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}