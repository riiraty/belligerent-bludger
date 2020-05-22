package riiraty.ui;

import java.math.BigInteger;
import java.util.Scanner;
import riiraty.cipher.MyRSA;

/**
 * Command Line Interface of the cryptosystem.
 */
public class CipherUi {

    private final Scanner scanner;
    private MyRSA crypter;

    public CipherUi(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        // valid values, but key too short to crypt properly
        crypter = new MyRSA(BigInteger.valueOf(14), BigInteger.valueOf(5), BigInteger.valueOf(11));
        System.out.println("Hello agent.");
        mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("Command options: ");
            System.out.println("--------------------------------------");
            System.out.println("[d]      - decrypt a cipher message.");
            System.out.println("[e]      - encrypt plain text message.");
            System.out.println("[keygen] - generate a keypair.");
            System.out.println("[help]   - get command details.");
            System.out.println("[quit]   - quit and close the crypter.");
            System.out.println("--------------------------------------");
            
            System.out.print("Give command: ");
            String command = scanner.nextLine();

            if (command.equals("d")) {
                System.out.println("--- decrypting ---");
            } else if (command.equals("e")) {
                System.out.print("Your message: ");
                String message = scanner.nextLine();

                System.out.println("--- encrypting ---");

                BigInteger messageAsBigInt = crypter.StringToBigInt(message);
                BigInteger encrypted = crypter.encrypt(messageAsBigInt);
                System.out.println("Encrypted message: " + encrypted);

                String encryptedString = crypter.BigIntToString(encrypted);
                System.out.println("Encrypted as String: " + encryptedString);

            } else if (command.equals("keygen")) {
                System.out.println("--- generating keys ---");
            } else if (command.equals("help")) {
                System.out.println("--- help ---");
            } else if (command.equals("quit")) {
                scanner.close();
                System.out.println("Goodbye.");
                break;
            } else {
                System.out.println("Not a valid command.");
            }
        }
        
    }
}
