// Clase Nodo para representar cada nodo en la lista
class Nodo<E> {
    E dato; // Dato almacenado en el nodo
    Nodo<E> siguiente; // Referencia al siguiente nodo

    // Constructor para inicializar un nodo con un dato
    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null; // El siguiente nodo es null inicialmente
    }
}

// Clase MiLinkedList para implementar todos los métodos de la lista enlazada
public class MiLinkedList<E> {
    private Nodo<E> cabeza; // Referencia al primer nodo de la lista
    private int tamaño; // Tamaño de la lista (número de nodos)

    // Constructor para inicializar la lista como vacía
    public MiLinkedList() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Método para añadir un elemento al final de la lista
    // Complejidad O(n) ya que se necesita recorrer hasta el final de la lista
    public void add(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato); // Crear un nuevo nodo con el dato
        if (cabeza == null) {
            cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            Nodo<E> actual = cabeza;
            // Recorremos hasta el último nodo
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo; // Añadir el nuevo nodo al final
        }
        tamaño++; // Incrementar el tamaño de la lista
    }

    // Método para añadir un elemento al inicio de la lista
    // Complejidad O(1) ya que solo cambia la referencia de la cabeza
    public void addFirst(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo; // El nuevo nodo se convierte en la nueva cabeza
        tamaño++;
    }

    // Método para añadir un elemento al final de la lista (alias de add)
    // Complejidad O(n) ya que llama al método add() que recorre toda la lista
    public void addLast(E dato) {
        add(dato); // Reutilizamos el método add para añadir al final
    }

    // Método para añadir un elemento en una posición específica
    // Complejidad O(n) ya que se necesita recorrer hasta la posición deseada
    public void add(int index, E dato) {
        if (index < 0 || index > tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (index == 0) { // Insertar al inicio
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo<E> actual = cabeza;
            for (int i = 0; i < index - 1; i++) { // Llegar al nodo anterior a la posición deseada
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente; // Enlazar el nuevo nodo
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    // Método para obtener el elemento en una posición específica
    // Complejidad O(n) ya que se necesita recorrer hasta la posición deseada
    public E get(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<E> actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.dato; // Devolver el dato en la posición deseada
    }

    // Método para obtener el primer elemento de la lista
    // Complejidad O(1) ya que solo accede al primer nodo
    public E getFirst() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.dato;
    }

    // Método para obtener el último elemento de la lista
    // Complejidad O(n) ya que se necesita recorrer hasta el último nodo
    public E getLast() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        Nodo<E> actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    // Método para eliminar el primer elemento de la lista
    // Complejidad O(1) ya que solo cambia la referencia de la cabeza
    public E removeFirst() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cabeza.dato;
        cabeza = cabeza.siguiente; // La cabeza ahora apunta al segundo nodo
        tamaño--;
        return datoEliminado;
    }

    // Método para eliminar el último elemento de la lista
    // Complejidad O(n) ya que se necesita recorrer hasta el penúltimo nodo
    public E removeLast() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        if (cabeza.siguiente == null) { // Si solo hay un nodo
            return removeFirst(); // Reutilizamos removeFirst()
        }
        Nodo<E> actual = cabeza;
        while (actual.siguiente.siguiente != null) { // Llegar al penúltimo nodo
            actual = actual.siguiente;
        }
        E datoEliminado = actual.siguiente.dato;
        actual.siguiente = null; // Eliminar la referencia al último nodo
        tamaño--;
        return datoEliminado;
    }

    // Método para eliminar un elemento en una posición específica
    // Complejidad O(n) ya que se necesita recorrer hasta el nodo anterior a la posición
    public E remove(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        E datoEliminado;
        if (index == 0) { // Eliminar el primer elemento
            datoEliminado = cabeza.dato;
            cabeza = cabeza.siguiente;
        } else {
            Nodo<E> actual = cabeza;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.siguiente;
            }
            datoEliminado = actual.siguiente.dato;
            actual.siguiente = actual.siguiente.siguiente; // Saltar el nodo eliminado
        }
        tamaño--;
        return datoEliminado; // Devolver el dato del nodo eliminado
    }

    // Método para verificar si un elemento está en la lista
    // Complejidad O(n) ya que se necesita recorrer la lista completa en el peor caso
    public boolean contains(E dato) {
        Nodo<E> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true; // Dato encontrado
            }
            actual = actual.siguiente;
        }
        return false; // Dato no encontrado
    }

    // Método para obtener el tamaño de la lista
    // Complejidad O(1) ya que solo devuelve el valor del atributo tamaño
    public int size() {
        return tamaño;
    }

    // Método para verificar si la lista está vacía
    // Complejidad O(1) ya que solo verifica si el tamaño es igual a 0
    public boolean isEmpty() {
        return tamaño == 0;
    }

    // Método para imprimir la lista completa
    // Complejidad O(n) ya que se necesita recorrer toda la lista
    public void printList() {
        Nodo<E> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null"); // Indicar el final de la lista
    }

    // Ejemplo de uso de la lista enlazada simple
    public static void main(String[] args) {
        MiLinkedList<Integer> lista = new MiLinkedList<>();

        // Añadir elementos al final de la lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.print("Lista después de agregar elementos: ");
        lista.printList();

        // Añadir elemento al inicio
        lista.addFirst(0);
        System.out.print("Lista después de agregar 0 al inicio: ");
        lista.printList();

        // Obtener el primer y último elemento
        System.out.println("Primer elemento: " + lista.getFirst());
        System.out.println("Último elemento: " + lista.getLast());

        // Eliminar el primer elemento
        lista.removeFirst();
        System.out.print("Lista después de eliminar el primer elemento: ");
        lista.printList();

        // Eliminar el último elemento
        lista.removeLast();
        System.out.print("Lista después de eliminar el último elemento: ");
        lista.printList();

        // Insertar un elemento en una posición específica
        lista.add(1, 99
