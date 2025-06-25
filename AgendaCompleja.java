import java.util.*;

class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return nombre + " - " + telefono + " - " + email;
    }
}

public class AgendaCompleja {
    private Map<String, Contacto> contactos;

    public AgendaCompleja() {
        contactos = new TreeMap<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.put(contacto.getNombre(), contacto);
    }

    public void mostrarContactos() {
        for (Map.Entry<String, Contacto> entry : contactos.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void buscarPorPrefijo(String prefijo) {
        System.out.println("Contactos que comienzan con "" + prefijo + "":");
        for (String nombre : contactos.keySet()) {
            if (nombre.startsWith(prefijo)) {
                System.out.println(contactos.get(nombre));
            }
        }
    }

    public static void main(String[] args) {
        AgendaCompleja agenda = new AgendaCompleja();
        agenda.agregarContacto(new Contacto("Carlos", "0991234567", "carlos@email.com"));
        agenda.agregarContacto(new Contacto("Carla", "0998765432", "carla@email.com"));
        agenda.agregarContacto(new Contacto("Ana", "0987654321", "ana@email.com"));

        agenda.mostrarContactos();
        agenda.buscarPorPrefijo("Car");
    }
}