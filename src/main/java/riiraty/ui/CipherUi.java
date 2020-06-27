package riiraty.ui;

import java.util.Scanner;

import riiraty.cipher.Crypter;
import riiraty.keys.KeyPairGenerator;
import riiraty.util.Tester;

/**
 * Command Line Interface of the cryptosystem.
 */
public class CipherUi {
    private final Scanner scanner;
    private Crypter crypter;
    private KeyPairGenerator keyPairGenerator;

    public CipherUi(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        crypter = new Crypter();
        keyPairGenerator = new KeyPairGenerator();

        System.out.println("Hello agent.");
        mainMenu();
    }

    public void mainMenu() {
        boolean run = true;
        
        while (run) {
            info();
            System.out.print("Give command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "d":
                    decrypt();
                    break;
                case "e":
                    encrypt();
                    break;
                case "keygen":
                    keygen();
                    break;
                case "quit":
                    run = false;
                    break;
                case "test":
                    performanceTest();
                    break;
                default:
                    System.out.println(error());
                    break;
            }

        }

        scanner.close();
        System.out.println("Goodbye.");   
    }

    // Command functions:

    public void info() {
        System.out.println("--------------------------------------");
        System.out.println("\u001b[1mCommand options:\u001b[0m ");
        System.out.println("[d]      - decrypt a cipher message.");
        System.out.println("[e]      - encrypt plain text message.");
        System.out.println("[keygen] - generate a keypair.");
        System.out.println("[quit]   - quit and close the crypter.");
        System.out.println("[test]   - run performance test.");
        System.out.println("--------------------------------------");
    }

    public void decrypt() {
        System.out.print("Give cipher: ");
        String cipher = scanner.nextLine();

        System.out.print("Give key (ENTER for default): ");
        String key = scanner.nextLine();

        try {
            String decrypted = crypter.decrypt(cipher.trim(), key.trim());
            System.out.println("--------------\u001b[32mdecrypting\u001b[0m--------------");
            System.out.println("\u001b[1mOriginal message: \u001b[0m" + decrypted);
        } catch (Exception e) {
            System.out.println(error());
        }

    }

    public void encrypt() {
        System.out.print("Your message: ");
        String message = scanner.nextLine();

        System.out.print("Give key (ENTER for default): ");
        String key = scanner.nextLine();

        try {
            String cipher = crypter.encrypt(message, key.trim());
            System.out.println("--------------\u001b[32mencrypting\u001b[0m-------------");    
            System.out.println("\u001b[1mCiphered message: \u001b[0m" + cipher);
        } catch (Exception e) {
            System.out.println(error());
        }

    }

    public void keygen() {
        try {
            System.out.println("-------------\u001b[32mgenerating keys\u001b[0m--------------");
            keyPairGenerator.keygen();
            System.out.println(keyPairGenerator.getKeys().toString());
        } catch (Exception e) {
            System.out.println(error());
        }
    }

    public void performanceTest() {
        System.out.print("Number of rounds: ");
        String rounds = scanner.nextLine();
        
        try {
            int n = Integer.parseInt(rounds);
            Tester tester = new Tester(n);
            tester.run();
        } catch (Exception e) {
            System.out.println(error());
        }
    }

    
    /** 
     * @return String error message after Exceptions
     */
    private String error() {
        return "------------\u001b[31;1mInvalid input.\u001b[0m------------";
    }

}
