/**
 * Método recursivo que reordena los nodos de la lista basándose en el valor `n`.
 * 
 * @param n Valor de referencia para dividir los nodos.
 * @return La nueva cabeza de la lista reordenada.
 */
private Node reOrdenarRecursivo(int n) {
    // Caso base: si la lista está vacía o contiene un solo nodo, no se reordena
    if (head == null || head.next == null) {
        return head;
    }

    // Guardar la referencia original de la cabeza
    Node current = head;

    // Llamada recursiva para reorganizar el resto de la lista
    head = head.next; // Avanzar la cabeza antes de la llamada recursiva
    Node rest = reOrdenarRecursivo(n);

    // Decidir la posición del nodo actual
    if (current.element <= n) {
        // Mantener al inicio
        current.next = rest;
        if (rest != null) {
            rest.prev = current;
        }
        current.prev = null; // Este nodo será la nueva cabeza
        return current; // Retornar el nodo actual como nueva cabeza
    } else {
        // Mover al final
        Node temp = rest;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = current;
        current.prev = temp;
        current.next = null; // Este nodo será la nueva cola
        return rest; // Retornar la cabeza de la lista reorganizada
    }
}
}
}

/**
 * Método que mueve los nodos con valores menores o iguales a `n` al final de la lista.
 *
 * @param n Valor de referencia para identificar los nodos a mover.
 */
public void moverMenoresOIgualesAlFinal(int n) {
    Node current = head; // Empezar desde la cabeza

    while (current != null) {
        // Verificar si el nodo actual cumple la condición
        if (current.element <= n) {
            Node temp = current; // Guardar referencia del nodo actual

            // Mover al siguiente nodo antes de realizar modificaciones
            current = current.next;

            // Desconectar el nodo actual de su posición actual
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next; // Si el nodo es la cabeza, actualizar la cabeza
            }

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev; // Si el nodo es la cola, actualizar la cola
            }

            // Agregar el nodo al final
            temp.prev = tail;
            temp.next = null;
            if (tail != null) {
                tail.next = temp;
            }
            tail = temp;

            // Si la lista estaba vacía, el nodo también es la cabeza
            if (head == null) {
                head = temp;
            }
        } else {
            // Si no cumple la condición, pasar al siguiente nodo
            current = current.next;
        }
    }
}


/**
 * Método que reorganiza los nodos de la lista dependiendo del argumento pasado.
 * 
 * @param n       Valor de referencia para organizar los nodos.
 * @param criterio Indica cómo reorganizar la lista ("menor" o "mayor").
 *                 - Si criterio es "menor": los valores menores o iguales a `n` se mueven al inicio.
 *                 - Si criterio es "mayor": los valores menores o iguales a `n` se mueven al final.
 */
public void reorganizarPorCriterio(int n, String criterio) {
    if (!criterio.equals("menor") && !criterio.equals("mayor")) {
        throw new IllegalArgumentException("El criterio debe ser 'menor' o 'mayor'.");
    }

    Node current = head; // Inicia desde la cabeza

    while (current != null) {
        Node temp = current; // Guarda referencia del nodo actual
        current = current.next; // Avanza al siguiente nodo antes de modificar

        if ((criterio.equals("menor") && temp.element <= n) || 
            (criterio.equals("mayor") && temp.element > n)) {
            
            // Desconecta el nodo actual de su posición
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next; // Si es la cabeza, actualizarla
            }

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev; // Si es la cola, actualizarla
            }

            if (criterio.equals("menor")) {
                // Mueve al inicio de la lista
                temp.next = head;
                if (head != null) {
                    head.prev = temp;
                }
                temp.prev = null;
                head = temp;

                // Si la lista estaba vacía, actualizar también la cola
                if (tail == null) {
                    tail = temp;
                }
            } else {
                // Mueve al final de la lista
                temp.prev = tail;
                temp.next = null;
                if (tail != null) {
                    tail.next = temp;
                }
                tail = temp;

                // Si la lista estaba vacía, actualizar también la cabeza
                if (head == null) {
                    head = temp;
                }
            }
        }
    }
}
