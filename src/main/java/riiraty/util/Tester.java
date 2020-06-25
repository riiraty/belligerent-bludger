package riiraty.util;

import java.util.Random;

import riiraty.cipher.Crypter;
import riiraty.keys.*;

public class Tester {
    private int n;
    private long[] times;
    private String[] messages;
    private String[] ciphers;
    private Crypter crypter;

    public Tester(int rounds) {
        n = rounds;
        times =  new long[n];
        messages = new String[n];
        ciphers = new String[n];
        PublicKey publicKey = new PublicKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5OjE5MzkyMzQ5ODk1MDEwOTk3NDk0MjkwNTEzMjA4MzA4NjQzNzYzMTIzNjQwNDM3MzgyMTk3MTg4NTM2MDY0ODA3MzM2MzIwODM1NDM2ODMyODM2NDEwNTIzMTU3MjMwOTgzNjc0NDQwMDI0NDM5OTIwOTgxMjQ5NjIwNDM1MTIzMDE0NTEzMTU2NjU2OTkzOTQxMDQxMzA0ODMzODAyNTU5NjgzODI4Mzk2NTAyNjA0NjA1MTk0MzQ3NjE0NTczOTg1MzY3MTA0NDU2NjA3ODE3MzkwNTcyNjcyODAyODYwNTM4Mzk1MzgwOTI3MTE4Njc1OTc3NjY0Mzk0MTg2OTY4NDQyNTk0Njg0MDA3MTQ3Njc4MzUyODAyOTQ1MTU3NzQxNDgxODc5MDUzNTU0MTY0ODQx");
        PrivateKey privateKey = new PrivateKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5Ojg4NjY5MTUzOTY3MzIzNDY0MDUxOTcwNzEzMTY3NTc1NjUxMDUyMTAwMTgyMjM1MDg3MzU0NTE1MTUxODczMzQ0MjYyNzM0OTA4NjE5Mzk4NTIzOTg5MTczMjY5ODM2MzQ5ODgyNzYxNjQwOTQzNTQ5ODQ5MjU1NTE5MDQxMDEzNTIwODUyNzM4ODMxNjcxMzM5NTcyMDc4OTM3MTM5MDc3Njc1NzY4NDExNDY0Mzc1MzQzNjU2Mzc4MjUzNDg5MjkyNzk0OTYzODYzNjkxMDYwOTk3MzE5NjgwNzc1MDk1MjE4MjE0MDc0NzU5NDUyOTEwNTk2MTkzNzkxNjQxOTc5NDYyMzUyMDEyODUyNDk5MTYwMDUwNzk0MDYyNDQxMTM0OTM0NTY3NDk0Nzg3Mzg2Mzkz");
        KeyPair keyPair = new KeyPair(publicKey, privateKey);
        crypter = new Crypter(keyPair);
    }

    public void run() {
        init();
        System.out.println("--------------------------------------");
        System.out.println("Performance test results: ");

        double keygen = keygen();
        System.out.println("Average keygen: " + keygen + " ms");

        double encrypt = encrypt();
        System.out.println("Average encryption: " + encrypt + " ms");

        double decrypt = decrypt();
        System.out.println("Average decryption: " + decrypt + " ms");
    }

    private void init() {
        // init random messages
        for (int i = 0; i < n; i++) {
            messages[i] = randomString();
        }

        // ciphers to array
        for (int i = 0; i < n; i++) {
            ciphers[i] = crypter.encrypt(messages[i], "");
        }
    }

    private String randomString() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(64);
        for ( int i = 0; i < 64; i++ ) { 
            sb.append( chars.charAt( rnd.nextInt(chars.length()) ) );
        }
        return sb.toString();
    }
    
    private double getAverage(long[] times) {
        double total = 0;
        for (long time : times) {
            total += time;
        }
        return total / n;
    }

    private double keygen() {
        KeyPairGenerator keyPairGenerator = new KeyPairGenerator();
        long t;
        for (int i = 0; i < n; i++) {
            t = System.nanoTime();
            keyPairGenerator.keygen();
            t = System.nanoTime() - t;
            times[i] = t;
        }
        double milliseconds = getAverage(times) / 1000000.0;
        return milliseconds;
    }
    

    private double encrypt() {
        long t;
        for (int i = 0; i < n; i++) {
            t = System.nanoTime();
            crypter.encrypt(messages[i], "");
            t = System.nanoTime() - t;
            times[i] = t;
        }
        double milliseconds = getAverage(times) / 1000000.0;
        return milliseconds;
    }

    private double decrypt() {
        long t;
        for (int i = 0; i < n; i++) {
            t = System.nanoTime();
            crypter.decrypt(ciphers[i], "");
            t = System.nanoTime() - t;
            times[i] = t;
        }
        double milliseconds = getAverage(times) / 1000000.0;
        return milliseconds;
    }

}
