// Clase NodoDoble para representar cada nodo en la lista doblemente enlazada
class NodoDoble<E> {
    E dato;                    // Dato almacenado en el nodo
    NodoDoble<E> siguiente;    // Referencia al siguiente nodo en la lista
    NodoDoble<E> anterior;     // Referencia al nodo anterior en la lista

    // Constructor para inicializar un nodo con un dato
    public NodoDoble(E dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

// Clase MiLinkedList para implementar todos los métodos de la lista doblemente enlazada
public class MiLinkedList<E> {
    private NodoDoble<E> cabeza; // Referencia al primer nodo de la lista
    private NodoDoble<E> cola;   // Referencia al último nodo de la lista
    private int tamaño;          // Tamaño de la lista (número de nodos)

    // Constructor para inicializar la lista como vacía
    public MiLinkedList() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    // Método para añadir un elemento al final de la lista
    // Complejidad O(1) ya que se añade directamente al final (cola) sin recorrer la lista
    public void add(E dato) {
        NodoDoble<E> nuevoNodo = new NodoDoble<>(dato);
        if (cabeza == null) {         // Si la lista está vacía, el nuevo nodo es la cabeza y la cola
            cabeza = cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo; // Enlaza el último nodo al nuevo nodo
            nuevoNodo.anterior = cola;  // Apunta al nodo anterior (cola)
            cola = nuevoNodo;           // El nuevo nodo se convierte en la cola
        }
        tamaño++; // Incrementa el tamaño de la lista
    }

    // Método para añadir un elemento al inicio de la lista
    // Complejidad O(1) ya que solo cambia las referencias de cabeza y del nodo siguiente
    public void addFirst(E dato) {
        NodoDoble<E> nuevoNodo = new NodoDoble<>(dato);
        if (cabeza == null) {         // Si la lista está vacía, el nuevo nodo es la cabeza y la cola
            cabeza = cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza; // El nuevo nodo apunta al antiguo primer nodo
            cabeza.anterior = nuevoNodo;  // El antiguo primer nodo apunta al nuevo nodo
            cabeza = nuevoNodo;           // El nuevo nodo se convierte en la cabeza
        }
        tamaño++;
    }

    // Método para obtener el primer elemento de la lista
    // Complejidad O(1) ya que accede directamente al primer nodo
    public E getFirst() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.dato;
    }

    // Método para obtener el último elemento de la lista
    // Complejidad O(1) ya que accede directamente al último nodo
    public E getLast() {
        if (cola == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cola.dato;
    }

    // Método para eliminar el primer elemento de la lista
    // Complejidad O(1) ya que solo cambia las referencias de cabeza y del nodo siguiente
    public E removeFirst() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cabeza.dato;
        cabeza = cabeza.siguiente; // La cabeza ahora apunta al segundo nodo
        if (cabeza != null) {
            cabeza.anterior = null; // Se elimina la referencia hacia el nodo anterior
        } else {
            cola = null; // Si la lista queda vacía, cola también debe ser null
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para eliminar el último elemento de la lista
    // Complejidad O(1) ya que solo cambia la referencia de cola y del nodo anterior
    public E removeLast() {
        if (cola == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cola.dato;
        cola = cola.anterior; // La cola ahora apunta al penúltimo nodo
        if (cola != null) {
            cola.siguiente = null; // Elimina la referencia hacia el nodo siguiente
        } else {
            cabeza = null; // Si la lista queda vacía, cabeza también debe ser null
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para verificar si un elemento está en la lista
    // Complejidad O(n) ya que necesita recorrer la lista completa en el peor caso
    public boolean contains(E dato) {
        NodoDoble<E> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true; // Dato encontrado
            }
            actual = actual.siguiente;
        }
        return false; // Dato no encontrado
    }

    // Método para obtener el tamaño actual de la lista
    // Complejidad O(1) ya que solo devuelve el valor del atributo tamaño
    public int size() {
        return tamaño;
    }

    // Método para verificar si la lista está vacía
    // Complejidad O(1) ya que solo verifica si el tamaño es igual a 0
    public boolean isEmpty() {
        return tamaño == 0;
    }

    // Método para imprimir la lista completa desde la cabeza hasta la cola
    // Complejidad O(n) ya que necesita recorrer toda la lista
    public void printList() {
        NodoDoble<E> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null"); // Indicar el final de la lista
    }

    // Método para imprimir la lista completa desde la cola hasta la cabeza (recorrido inverso)
    // Complejidad O(n) ya que necesita recorrer toda la lista
    public void printListReverse() {
        NodoDoble<E> actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null"); // Indicar el final de la lista en orden inverso
    }

    // Ejemplo de uso de la lista doblemente enlazada
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

        // Verificar si la lista contiene un elemento
        System.out.println("¿Contiene 2? " + lista.contains(2));
        System.out.println("¿Contiene 5? " + lista.contains(5));

        // Obtener el tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.size());

        // Verificar si la lista está vacía
        System.out.println("¿La lista está vacía? " + lista.isEmpty());

        // Imprimir la lista en orden inverso
        System.out.print("Lista en orden inverso: ");
        lista.printListReverse();
    }
}
