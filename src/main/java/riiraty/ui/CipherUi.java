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
        // PublicKey publicKey = new PublicKey(BigInteger.valueOf(2019302167), 
        //                                     BigInteger.valueOf(1004236379));
        // PrivateKey privateKey = new PrivateKey(BigInteger.valueOf(2019302167), 
        //                                        BigInteger.valueOf(253632059));

        // Default key pair of 1024 bit size, makes max input 128 chars
        PublicKey publicKey = new PublicKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5OjE5MzkyMzQ5ODk1MDEwOTk3NDk0MjkwNTEzMjA4MzA4NjQzNzYzMTIzNjQwNDM3MzgyMTk3MTg4NTM2MDY0ODA3MzM2MzIwODM1NDM2ODMyODM2NDEwNTIzMTU3MjMwOTgzNjc0NDQwMDI0NDM5OTIwOTgxMjQ5NjIwNDM1MTIzMDE0NTEzMTU2NjU2OTkzOTQxMDQxMzA0ODMzODAyNTU5NjgzODI4Mzk2NTAyNjA0NjA1MTk0MzQ3NjE0NTczOTg1MzY3MTA0NDU2NjA3ODE3MzkwNTcyNjcyODAyODYwNTM4Mzk1MzgwOTI3MTE4Njc1OTc3NjY0Mzk0MTg2OTY4NDQyNTk0Njg0MDA3MTQ3Njc4MzUyODAyOTQ1MTU3NzQxNDgxODc5MDUzNTU0MTY0ODQx");
        PrivateKey privateKey = new PrivateKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5Ojg4NjY5MTUzOTY3MzIzNDY0MDUxOTcwNzEzMTY3NTc1NjUxMDUyMTAwMTgyMjM1MDg3MzU0NTE1MTUxODczMzQ0MjYyNzM0OTA4NjE5Mzk4NTIzOTg5MTczMjY5ODM2MzQ5ODgyNzYxNjQwOTQzNTQ5ODQ5MjU1NTE5MDQxMDEzNTIwODUyNzM4ODMxNjcxMzM5NTcyMDc4OTM3MTM5MDc3Njc1NzY4NDExNDY0Mzc1MzQzNjU2Mzc4MjUzNDg5MjkyNzk0OTYzODYzNjkxMDYwOTk3MzE5NjgwNzc1MDk1MjE4MjE0MDc0NzU5NDUyOTEwNTk2MTkzNzkxNjQxOTc5NDYyMzUyMDEyODUyNDk5MTYwMDUwNzk0MDYyNDQxMTM0OTM0NTY3NDk0Nzg3Mzg2Mzkz");
        KeyPair keyPair = new KeyPair(publicKey, privateKey);
        crypter = new Crypter(keyPair);
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
            System.out.println("[quit]   - quit and close the crypter.");
            System.out.println("--------------------------------------");
            
            System.out.print("Give command: ");
            String command = scanner.nextLine();

            if (command.equals("d")) {
                decrypt();
            } else if (command.equals("e")) {
                encrypt();
            } else if (command.equals("keygen")) {
                keygen();
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
                System.out.println("---------\u001b[31;1mNot a valid command.\u001b[0m---------");
            }
        }
        
    }

    public void decrypt() {
        System.out.print("Give cipher: ");
        String cipher = scanner.nextLine();

        System.out.print("Give key (ENTER for default): ");
        String key = scanner.nextLine();

        String decrypted = crypter.decrypt(cipher, key);

        System.out.println("----------------decrypting----------------");
        System.out.println("Original message: " + decrypted);
    }

    public void encrypt() {
        System.out.print("Your message: ");
        String message = scanner.nextLine();

        System.out.print("Give key (ENTER for default): ");
        String key = scanner.nextLine();

        String cipher = crypter.encrypt(message, key);

        System.out.println("----------------encrypting----------------");    
        System.out.println("Ciphered message: " + cipher);
    }

    public void keygen() {
        System.out.println("-------------generating keys--------------");        
        new KeyPairGenerator();
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
        String cipher = crypter.encrypt(message, "");
        System.out.println("Encrypted with crypter: " + cipher);

        System.out.println("----Decryption------------------------");
        String decrypted = crypter.decrypt(cipher, "");
        System.out.println("Decrypted with crypter: " + decrypted);

        System.out.println("----FIN-------------------------------");
    }
}
