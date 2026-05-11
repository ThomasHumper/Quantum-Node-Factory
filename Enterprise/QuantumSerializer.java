import java.util.*;

public class MiniOS {

    private static boolean running = true;
    private static Map<String, String> memory = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boot();

        while (running) {
            System.out.print("MiniOS> ");
            String input = scanner.nextLine();
            handleCommand(input);
        }

        scanner.close();
    }

    static void boot() {
        System.out.println("Booting MiniOS...");
        System.out.println("Loading kernel modules...");
        System.out.println("Starting shell ✔");
        System.out.println("Type 'help' for commands\n");
    }

    static void handleCommand(String input) {
        String[] parts = input.split(" ");
        String cmd = parts[0].toLowerCase();

        switch (cmd) {
            case "help":
                help();
                break;

            case "exit":
                System.out.println("Shutting down MiniOS...");
                running = false;
                break;

            case "echo":
                for (int i = 1; i < parts.length; i++) {
                    System.out.print(parts[i] + " ");
                }
                System.out.println();
                break;

            case "set":
                if (parts.length >= 3) {
                    memory.put(parts[1], parts[2]);
                    System.out.println("Stored ✔");
                } else {
                    System.out.println("Usage: set <key> <value>");
                }
                break;

            case "get":
                if (parts.length >= 2) {
                    System.out.println(memory.getOrDefault(parts[1], "null"));
                } else {
                    System.out.println("Usage: get <key>");
                }
                break;

            case "mem":
                System.out.println("Memory dump:");
                memory.forEach((k, v) -> System.out.println(k + " = " + v));
                break;

            default:
                System.out.println("Unknown command: " + cmd);
        }
    }

    static void help() {
        System.out.println("Commands:");
        System.out.println("  help           - show commands");
        System.out.println("  echo text      - print text");
        System.out.println("  set k v        - store value in memory");
        System.out.println("  get k          - retrieve value");
        System.out.println("  mem            - show memory");
        System.out.println("  exit           - shutdown");
    }
}
