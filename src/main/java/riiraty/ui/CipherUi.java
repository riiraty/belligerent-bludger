package riiraty.ui;

import java.util.Scanner;

public class CipherUi {

    private final Scanner scanner;

    public CipherUi(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Hello agent.");
        mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("");
            System.out.println("Command options: ");
            System.out.println("decrypt");
            System.out.println("encrypt");
            System.out.println("keygen");
            System.out.println("help");
            System.out.println("quit");
            System.out.println("");

            String command = scanner.nextLine();
            System.out.println("");

            if (command.equals("decrypt")) {
                System.out.println("--- decrypting ---");
            } else if (command.equals("encrypt")) {
                System.out.println("--- encrypting ---");
            } else if (command.equals("keygen")) {
                System.out.println("--- generating keys ---");
            } else if (command.equals("help")) {
                System.out.println("--- help ---");
            } else if (command.equals("quit")) {
                scanner.close();
                System.out.println("Goodbye.");
                break;
            } else {
                System.out.println("Give valid command.");
            }
        }
        
    }
}
