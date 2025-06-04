// Lista Circular Simplemente Enlazada 

// Clase Nodo para representar cada nodo en la lista
class NodoCircular<E> {
    E dato;                    // Dato almacenado en el nodo
    NodoCircular<E> siguiente; // Referencia al siguiente nodo

    // Constructor para inicializar un nodo con un dato
    public NodoCircular(E dato) {
        this.dato = dato;
        this.siguiente = null; // El siguiente nodo es null inicialmente
    }
}

// Clase MiCircularLinkedList para implementar la lista circular simplemente enlazada
public class MiCircularLinkedList<E> {
    private NodoCircular<E> cabeza; // Referencia al primer nodo de la lista
    private NodoCircular<E> cola;   // Referencia al último nodo de la lista
    private int tamaño;             // Tamaño de la lista (número de nodos)

    // Constructor para inicializar la lista como vacía
    public MiCircularLinkedList() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    // Método para añadir un elemento al final de la lista
    // Complejidad O(1) ya que se añade directamente al final sin recorrer la lista
    public void add(E dato) {
        NodoCircular<E> nuevoNodo = new NodoCircular<>(dato);
        if (cabeza == null) {         // Si la lista está vacía, el nuevo nodo es cabeza y cola
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza; // El último nodo apunta de nuevo a la cabeza
        } else {
            cola.siguiente = nuevoNodo; // Enlaza el último nodo al nuevo nodo
            nuevoNodo.siguiente = cabeza; // Nuevo nodo apunta a la cabeza
            cola = nuevoNodo; // El nuevo nodo se convierte en la cola
        }
        tamaño++; // Incrementa el tamaño de la lista
    }

    // Método para añadir un elemento al inicio de la lista
    // Complejidad O(1) ya que solo cambia las referencias de cabeza y cola
    public void addFirst(E dato) {
        NodoCircular<E> nuevoNodo = new NodoCircular<>(dato);
        if (cabeza == null) {         // Si la lista está vacía, el nuevo nodo es cabeza y cola
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza; // El último nodo apunta de nuevo a la cabeza
        } else {
            nuevoNodo.siguiente = cabeza; // El nuevo nodo apunta al antiguo primer nodo
            cabeza = nuevoNodo;           // El nuevo nodo se convierte en la cabeza
            cola.siguiente = cabeza;      // La cola apunta de nuevo a la nueva cabeza
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
    // Complejidad O(1) ya que solo cambia las referencias de cabeza y cola
    public E removeFirst() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cabeza.dato;
        if (cabeza == cola) { // Si solo hay un elemento
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente; // La cabeza ahora apunta al segundo nodo
            cola.siguiente = cabeza;   // La cola apunta de nuevo a la nueva cabeza
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para eliminar el último elemento de la lista
    // Complejidad O(n) ya que necesita recorrer hasta el penúltimo nodo
    public E removeLast() {
        if (cola == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cola.dato;
        if (cabeza == cola) { // Si solo hay un elemento
            cabeza = null;
            cola = null;
        } else {
            NodoCircular<E> actual = cabeza;
            // Recorrer hasta el penúltimo nodo
            while (actual.siguiente != cola) {
                actual = actual.siguiente;
            }
            actual.siguiente = cabeza; // El penúltimo nodo ahora apunta a la cabeza
            cola = actual; // El penúltimo nodo se convierte en la nueva cola
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para verificar si un elemento está en la lista
    // Complejidad O(n) ya que necesita recorrer la lista completa en el peor caso
    public boolean contains(E dato) {
        if (cabeza == null) return false;

        NodoCircular<E> actual = cabeza;
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

    // Método para imprimir la lista completa
    // Complejidad O(n) ya que necesita recorrer toda la lista
    public void printList() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        NodoCircular<E> actual = cabeza;
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza)"); // Indicar el final de la lista y la referencia a la cabeza
    }

    // Ejemplo de uso de la lista circular simplemente enlazada
    public static void main(String[] args) {
        MiCircularLinkedList<Integer> lista = new MiCircularLinkedList<>();

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
    }
}
