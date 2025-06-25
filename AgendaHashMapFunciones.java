import java.util.*;

public class AgendaHashMapFunciones {
    public static void main(String[] args) {
        // Crear un HashMap para almacenar contactos
        Map<String, String> agenda = new HashMap<>();

        // put(K key, V value): Agrega o reemplaza un valor asociado a una clave
        agenda.put("Carlos", "0991234567");
        agenda.put("Ana", "0987654321");
        agenda.put("Pedro", "0971122334");

        // replace(K key, V value): Reemplaza el valor si la clave existe
        agenda.replace("Ana", "0980000000");

        // get(Object key): Obtiene el valor asociado a una clave
        String telefonoPedro = agenda.get("Pedro");
        System.out.println("Teléfono de Pedro: " + telefonoPedro);

        // containsKey(Object key): Verifica si una clave existe
        if (agenda.containsKey("Carlos")) {
            System.out.println("Carlos está en la agenda.");
        }

        // containsValue(Object value): Verifica si un valor existe
        if (agenda.containsValue("0980000000")) {
            System.out.println("Un contacto tiene el número 0980000000.");
        }

        // remove(Object key): Elimina una entrada por su clave
        agenda.remove("Pedro");

        // isEmpty(): Verifica si el mapa está vacío
        if (!agenda.isEmpty()) {
            System.out.println("Agenda no está vacía.");
        }

        // keySet(): Devuelve un Set con todas las claves
        System.out.println("Contactos:");
        for (String nombre : agenda.keySet()) {
            System.out.println(nombre);
        }

        // values(): Devuelve una colección con todos los valores
        System.out.println("Números:");
        for (String telefono : agenda.values()) {
            System.out.println(telefono);
        }

        // entrySet(): Itera sobre claves y valores al mismo tiempo
        System.out.println("Agenda completa:");
        for (Map.Entry<String, String> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}