package riiraty.ui;

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
    private KeyPairGenerator keyPairGenerator;

    public CipherUi(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        // Default key pair of 1024 bit size, makes max input 128 chars
        PublicKey publicKey = new PublicKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5OjE5MzkyMzQ5ODk1MDEwOTk3NDk0MjkwNTEzMjA4MzA4NjQzNzYzMTIzNjQwNDM3MzgyMTk3MTg4NTM2MDY0ODA3MzM2MzIwODM1NDM2ODMyODM2NDEwNTIzMTU3MjMwOTgzNjc0NDQwMDI0NDM5OTIwOTgxMjQ5NjIwNDM1MTIzMDE0NTEzMTU2NjU2OTkzOTQxMDQxMzA0ODMzODAyNTU5NjgzODI4Mzk2NTAyNjA0NjA1MTk0MzQ3NjE0NTczOTg1MzY3MTA0NDU2NjA3ODE3MzkwNTcyNjcyODAyODYwNTM4Mzk1MzgwOTI3MTE4Njc1OTc3NjY0Mzk0MTg2OTY4NDQyNTk0Njg0MDA3MTQ3Njc4MzUyODAyOTQ1MTU3NzQxNDgxODc5MDUzNTU0MTY0ODQx");
        PrivateKey privateKey = new PrivateKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5Ojg4NjY5MTUzOTY3MzIzNDY0MDUxOTcwNzEzMTY3NTc1NjUxMDUyMTAwMTgyMjM1MDg3MzU0NTE1MTUxODczMzQ0MjYyNzM0OTA4NjE5Mzk4NTIzOTg5MTczMjY5ODM2MzQ5ODgyNzYxNjQwOTQzNTQ5ODQ5MjU1NTE5MDQxMDEzNTIwODUyNzM4ODMxNjcxMzM5NTcyMDc4OTM3MTM5MDc3Njc1NzY4NDExNDY0Mzc1MzQzNjU2Mzc4MjUzNDg5MjkyNzk0OTYzODYzNjkxMDYwOTk3MzE5NjgwNzc1MDk1MjE4MjE0MDc0NzU5NDUyOTEwNTk2MTkzNzkxNjQxOTc5NDYyMzUyMDEyODUyNDk5MTYwMDUwNzk0MDYyNDQxMTM0OTM0NTY3NDk0Nzg3Mzg2Mzkz");
        KeyPair keyPair = new KeyPair(publicKey, privateKey);

        crypter = new Crypter(keyPair);
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

            switch(command) {
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
                    System.out.println("---------\u001b[31;1mNot a valid command.\u001b[0m---------");
                    break;
            }

        }

        scanner.close();
        System.out.println("Goodbye.");   
    }

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
            System.out.println("---------\u001b[31;1mSomething went wrong\u001b[0m---------");
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
            System.out.println("---------\u001b[31;1mSomething went wrong\u001b[0m---------");
        }

    }

    public void keygen() {
        System.out.println("-------------generating keys--------------");
        keyPairGenerator.keygen();
    }

    public void performanceTest() {
        Tester tester = new Tester();
        tester.run();
        System.out.println(tester.toString());
    }

}
