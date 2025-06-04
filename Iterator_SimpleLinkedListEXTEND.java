//////////////////////////////////////////////////////////////
//Clase Base de la Lista:
//////////////////////////////////////////////////////////////
class SinglyLinkedList<T> {
    private Node<T> head;

    // Nodo interno
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data);
        }
    }

    public SinglyLinkedListIterator iterator() {
        return new SinglyLinkedListIterator();
    }

    public class SinglyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            T data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported for singly linked list");
        }

        public void reset() {
            current = head;
        }

        public T peek() {
            if (!hasNext()) throw new IllegalStateException("No more elements to peek");
            return current.data;
        }

        public boolean isFirst() {
            return current == head;
        }
    }
}

//////////////////////////////////////////////////////////////
//Uso:
//////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        SinglyLinkedList<Integer>.SinglyLinkedListIterator iterator = list.iterator();

        // Imprimir todos los elementos
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Usar métodos adicionales
        iterator.reset();
        System.out.println("\nPrimer elemento (peek): " + iterator.peek());
        System.out.println("Es el primer elemento: " + iterator.isFirst());
    }
}
