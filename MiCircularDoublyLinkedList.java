// Implementación de una Lista Circular Doblemente Enlazada  Y CON LOS METODOS QUE PIDEN LA TAREA 4 Y 5

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

// clase para implementar la lista circular doble enlazada
public class MiCircularDoublyLinkedList<E> {
    private NodoDobleCircular<E> cabeza;
    private int tamaño;

    // Constructor
    public MiCircularDoublyLinkedList() {
        this.cabeza = null;
        this.tamaño = 0;
    }


    //DEBER 5
    // EJERCICIO 1: metodo para insertar al final

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

    // EJERCICIO 2: metodo para calcular longitud de la lista

    public int size() {
        return tamaño;
    }

    // EJERCICIO 3: metodo para imprimir la lista completa desde la cabeza hasta la cola

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

    //EJERCICIO 4: metodo para unir dos listas

    public void unirListas(MiCircularDoublyLinkedList<E> otraLista) {
        if (otraLista == null || otraLista.isEmpty()) return;

        if (this.isEmpty()) {
            this.cabeza = otraLista.cabeza;
            this.tamaño = otraLista.tamaño;
        } else {
            NodoDobleCircular<E> colaActual = this.cabeza.anterior;
            NodoDobleCircular<E> colaOtra = otraLista.cabeza.anterior;

            // Unir el final de la lista actual con el inicio de la otra lista
            colaActual.siguiente = otraLista.cabeza;
            otraLista.cabeza.anterior = colaActual;

            // Unir el final de la otra lista con el inicio de la lista actual
            colaOtra.siguiente = this.cabeza;
            this.cabeza.anterior = colaOtra;

            this.tamaño += otraLista.tamaño;
        }

        otraLista.cabeza = null; // La otra lista queda vacía
        otraLista.tamaño = 0;
    }

    //EJERCICIO 5: metodo para invertir la lista (retornando una nueva lista)

    public MiCircularDoublyLinkedList<E> invertir() {
        MiCircularDoublyLinkedList<E> listaInvertida = new MiCircularDoublyLinkedList<>();

        if (this.isEmpty()) return listaInvertida;

        NodoDobleCircular<E> actual = this.cabeza.anterior; // Comienza desde la cola
        do {
            listaInvertida.addFirst(actual.dato); // Agrega los elementos al principio de la nueva lista
            actual = actual.anterior;
        } while (actual != this.cabeza.anterior);

        return listaInvertida;
    }

    //CONTINUACION "DEBER 4"
    // EJERCICIO 6: metodo get(i)

    public E get(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoDobleCircular<E> actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    //EJERCICIO 7: metodo getLast()

    public E getLast() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.anterior.dato;
    }


    public boolean isEmpty() {
        return tamaño == 0;
    }


    public void addFirst(E dato) {
        NodoDobleCircular<E> nuevoNodo = new NodoDobleCircular<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior;
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        tamaño++;
    }

    public static void main(String[] args) {

        //TESTINGS


        // Prueba de add()
        System.out.println("Prueba de add()");
        MiCircularDoublyLinkedList<Integer> lista1 = new MiCircularDoublyLinkedList<>();
        lista1.add(10);
        lista1.add(20);
        lista1.add(30);
        lista1.printList();

        // Prueba de size()
        System.out.println("\nPrueba de size()");
        System.out.println("Tamaño de la lista: " + lista1.size());

        // Prueba de printList()
        System.out.println("\nPrueba de printList()");
        lista1.printList();

        // Prueba de unirListas()
        System.out.println("\nPrueba de unirListas()");
        MiCircularDoublyLinkedList<Integer> lista2 = new MiCircularDoublyLinkedList<>();
        lista2.add(40);
        lista2.add(50);
        lista1.unirListas(lista2);
        lista1.printList();

        // Prueba de invertir()
        System.out.println("\nPrueba de invertir()");
        MiCircularDoublyLinkedList<Integer> listaInvertida = lista1.invertir();
        listaInvertida.printList();

        // Prueba de get(i)
        System.out.println("\nPrueba de get(i)");
        System.out.println("Elemento en el índice 2: " + lista1.get(2));

        // Prueba de getLast()
        System.out.println("\nPrueba de getLast()");
        System.out.println("Último elemento: " + lista1.getLast());
    }





}

