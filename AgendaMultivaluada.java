import java.util.*;

public class AgendaMultivaluada {
    private Map<String, List<String>> contactos;

    public AgendaMultivaluada() {
        contactos = new HashMap<>();
    }

    public void agregarTelefono(String nombre, String telefono) {
        contactos.computeIfAbsent(nombre, k -> new ArrayList<>()).add(telefono);
    }

    public void mostrarAgenda() {
        for (Map.Entry<String, List<String>> entry : contactos.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Teléfonos: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        AgendaMultivaluada agenda = new AgendaMultivaluada();
        agenda.agregarTelefono("Carlos", "0991234567");
        agenda.agregarTelefono("Carlos", "0989988776");
        agenda.agregarTelefono("Ana", "0987654321");

        agenda.mostrarAgenda();
    }
}