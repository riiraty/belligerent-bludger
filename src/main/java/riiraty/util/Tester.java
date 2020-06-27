package riiraty.util;

import java.util.Random;

import riiraty.cipher.Crypter;
import riiraty.keys.KeyPairGenerator;

/**
 * Performance testing for the program.
 */
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
        crypter = new Crypter();
    }

    public void run() {
        long start = System.nanoTime();
        init();
        System.out.println("--------------------------------------");
        System.out.println("\u001b[1mPerformance test results: \u001b[0m");


        double keygen = keygen();
        String formatKeygen = String.format("%.3f", keygen);
        System.out.println("Average for keygen: " + formatKeygen + " ms");

        double encrypt = encrypt();
        String formatEncrypt = String.format("%.3f", encrypt);
        System.out.println("Average for encryption: " + formatEncrypt + " ms");

        double decrypt = decrypt();
        String formatDecrypt = String.format("%.3f", decrypt);
        System.out.println("Average for decryption: " + formatDecrypt + " ms");

        double stop = (System.nanoTime() - start) / 1000000.0;
        String formatStop = String.format("%.3f", stop);
        System.out.println("Total test time: " + formatStop + " ms" );
    }

    /**
     * Creates an array of random Strings 
     * and an array of their ciphers.
     */
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

    
    /** 
     * Creates a random String of length 64 chars
     * using specified characters.
     * @return String
     */
    private String randomString() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(64);
        for ( int i = 0; i < 64; i++ ) { 
            sb.append( chars.charAt( rnd.nextInt(chars.length()) ) );
        }
        return sb.toString();
    }
    
    
    /** 
     * @param times an array of runtimes
     * @return double average time from parameter array
     */
    private double getAverage(long[] times) {
        double total = 0;
        for (long time : times) {
            total += time;
        }
        return total / n;
    }

    
    /** 
     * Creates n pairs of keys and calculates an average.
     * @return double
     */
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
    

    
    /** 
     * Encrypts n messages and calculates an average for signle encryption.
     * @return double
     */
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

    
    /** 
     * Decrypts n ciphers and calculates an average for signle decryption.
     * @return double
     */
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
