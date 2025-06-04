// Implementación de una Lista Circular Doblemente Enlazada 

// Clase NodoDobleCircular para representar cada nodo en la lista
class NodoDobleCircular<E> {
    E dato;                        // Dato almacenado en el nodo
    NodoDobleCircular<E> siguiente; // Referencia al siguiente nodo
    NodoDobleCircular<E> anterior;  // Referencia al nodo anterior

    // Constructor para inicializar un nodo con un dato
    public NodoDobleCircular(E dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

// Clase MiCircularDoublyLinkedList para implementar la lista circular doblemente enlazada
public class MiCircularDoublyLinkedList<E> {
    private NodoDobleCircular<E> cabeza; // Referencia al primer nodo de la lista
    private int tamaño;                  // Tamaño de la lista (número de nodos)

    // Constructor para inicializar la lista como vacía
    public MiCircularDoublyLinkedList() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Método para añadir un elemento al final de la lista
    // Complejidad O(1) ya que se añade directamente al final sin recorrer la lista
    public void add(E dato) {
        NodoDobleCircular<E> nuevoNodo = new NodoDobleCircular<>(dato);
        if (cabeza == null) {                 // Si la lista está vacía, el nuevo nodo es cabeza y se enlaza a sí mismo
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior; // Obtener la cola desde la referencia de cabeza
            cola.siguiente = nuevoNodo;       // El último nodo apunta al nuevo nodo
            nuevoNodo.anterior = cola;        // El nuevo nodo apunta al anterior (antigua cola)
            nuevoNodo.siguiente = cabeza;     // El nuevo nodo apunta a la cabeza
            cabeza.anterior = nuevoNodo;      // La cabeza apunta de nuevo al nuevo nodo (nueva cola)
        }
        tamaño++; // Incrementa el tamaño de la lista
    }

    // Método para añadir un elemento al inicio de la lista
    // Complejidad O(1) ya que solo cambia las referencias de cabeza y del nodo siguiente
    public void addFirst(E dato) {
        NodoDobleCircular<E> nuevoNodo = new NodoDobleCircular<>(dato);
        if (cabeza == null) {                 // Si la lista está vacía, el nuevo nodo es cabeza y se enlaza a sí mismo
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior; // Obtener la cola desde la referencia de cabeza
            nuevoNodo.siguiente = cabeza;     // El nuevo nodo apunta al antiguo primer nodo
            nuevoNodo.anterior = cola;        // El nuevo nodo apunta a la antigua cola
            cola.siguiente = nuevoNodo;       // La cola apunta al nuevo nodo
            cabeza.anterior = nuevoNodo;      // El antiguo primer nodo apunta al nuevo nodo
            cabeza = nuevoNodo;               // El nuevo nodo se convierte en la cabeza
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
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.anterior.dato; // La cola está almacenada en cabeza.anterior
    }

    // Método para eliminar el primer elemento de la lista
    // Complejidad O(1) ya que solo cambia las referencias de cabeza, anterior y siguiente
    public E removeFirst() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cabeza.dato;
        if (cabeza.siguiente == cabeza) { // Si solo hay un elemento
            cabeza = null;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior;
            cabeza = cabeza.siguiente;         // La cabeza ahora apunta al segundo nodo
            cabeza.anterior = cola;            // La nueva cabeza apunta a la cola
            cola.siguiente = cabeza;           // La cola apunta de nuevo a la nueva cabeza
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para eliminar el último elemento de la lista
    // Complejidad O(1) ya que solo cambia la referencia de cola y del nodo anterior
    public E removeLast() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cabeza.anterior.dato;
        if (cabeza.siguiente == cabeza) { // Si solo hay un elemento
            cabeza = null;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior;
            cola.anterior.siguiente = cabeza;  // El penúltimo nodo apunta a la cabeza
            cabeza.anterior = cola.anterior;   // La cabeza apunta al penúltimo nodo (nueva cola)
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para verificar si un elemento está en la lista
    // Complejidad O(n) ya que necesita recorrer la lista completa en el peor caso
    public boolean contains(E dato) {
        if (cabeza == null) return false;

        NodoDobleCircular<E> actual = cabeza;
        do {
            if (actual.dato.equals(dato)) {
                return true; // Dato encontrado
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
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
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        NodoDobleCircular<E> actual = cabeza;
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza)"); // Indicar el final de la lista y la referencia a la cabeza
    }

    // Método para imprimir la lista completa desde la cola hasta la cabeza (recorrido inverso)
    // Complejidad O(n) ya que necesita recorrer toda la lista
    public void printListReverse() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        NodoDobleCircular<E> actual = cabeza.anterior; // Comienza desde la cola
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.anterior;
        } while (actual != cabeza.anterior);
        System.out.println("(cabeza en reversa)"); // Indicar el final de la lista y referencia inversa
    }

    // Ejemplo de uso de la lista circular doblemente enlazada
    public static void main(String[] args) {
        MiCircularDoublyLinkedList<Integer> lista = new MiCircularDoublyLinkedList<>();

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
