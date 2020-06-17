package riiraty.ui;

import java.math.BigInteger;
import java.util.Scanner;

import riiraty.cipher.Crypter;
import riiraty.keys.PublicKey;
import riiraty.keys.PrivateKey;
import riiraty.keys.KeyPair;
import riiraty.keys.KeyPairGenerator;
import riiraty.util.Tester;

/**
 * Command Line Interface of the cryptosystem.
 */
public class CipherUi {
    private final Scanner scanner;
    private Crypter crypter;

    public CipherUi(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        // Default keypair of 32 bit keysize, makes max input 4 chars
        PublicKey publicKey = new PublicKey(BigInteger.valueOf(2019302167), 
                                            BigInteger.valueOf(1004236379));
        PrivateKey privateKey = new PrivateKey(BigInteger.valueOf(2019302167), 
                                               BigInteger.valueOf(253632059));
        KeyPair keyPair = new KeyPair(publicKey, privateKey);
        crypter = new Crypter(keyPair);
        System.out.println("Hello agent.");
        System.out.println(keyPair.toString());
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
            System.out.println("[quit]   - quit and close the crypter.");
            System.out.println("--------------------------------------");
            
            System.out.print("Give command: ");
            String command = scanner.nextLine();

            if (command.equals("d")) {
                System.out.print("Give cipher: ");
                String cipher = scanner.nextLine();

                System.out.println("--- decrypting ---");

                String decrypted = crypter.decrypt(cipher);
                System.out.println("Ciphered message: " + decrypted);

            } else if (command.equals("e")) {
                System.out.print("Your message: ");
                String message = scanner.nextLine();

                System.out.println("--- encrypting ---");

                String cipher = crypter.encrypt(message);
                System.out.println("Ciphered message: " + cipher);

            } else if (command.equals("keygen")) {
                System.out.println("--- generating keys ---");
                new KeyPairGenerator();
            } else if (command.equals("quit")) {
                scanner.close();
                System.out.println("Goodbye.");
                break;
            } else if (command.equals("test")) {
                test();
                break;
            } else if ( command.equals("tester")) {
                Tester tester = new Tester();
                tester.run();
                System.out.println(tester.toString());
                break;
            } else {
                System.out.println("Not a valid command.");
            }
        }
        
    }

    // secret command for manual testing
    public void test() {
        System.out.println("----TEST------------------------------");
        String message = "Test";
        System.out.println("Original message: " + message);
        System.out.println("----Encryption------------------------");
        BigInteger bigI = crypter.messageToBigInt(message);
        System.out.println("Message as BigInt: " + bigI);
        BigInteger encrypted = bigI.modPow(BigInteger.valueOf(1004236379), 
                                           BigInteger.valueOf(2019302167));
        System.out.println("Encrypted BigInt: " + encrypted);
        String cipher = crypter.encrypt(message);
        System.out.println("Encrypted with crypter: " + cipher);

        System.out.println("----Decryption------------------------");
        String decrypted = crypter.decrypt(cipher);
        System.out.println("Decrypted with crypter: " + decrypted);

        System.out.println("----FIN-------------------------------");
    }
}
