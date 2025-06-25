import java.util.*;

public class AgendaHashMap {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        agenda.put("Carlos", "0991234567");
        agenda.put("Ana", "0987654321");
        agenda.put("Pedro", "0971122334");

        System.out.println("Agenda con HashMap (sin orden):");
        for (Map.Entry<String, String> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}