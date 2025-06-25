import java.util.*;

public class AgendaLinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> agenda = new LinkedHashMap<>();
        agenda.put("Carlos", "0991234567");
        agenda.put("Ana", "0987654321");
        agenda.put("Pedro", "0971122334");

        System.out.println("Agenda con LinkedHashMap (orden de inserción):");
        for (Map.Entry<String, String> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}