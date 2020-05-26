package riiraty.cipher;

import java.math.BigInteger;
import riiraty.keys.KeyPair;

/**
 * Tool for crypting messages with RSA-keys
 */
public class MyRSA {
    private KeyPair keyPair;

    public MyRSA(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public MyRSA() {
        // for testing
    }

    /***
     * Converts user input of plain text to String of ASCII-character values
     * Then converts formed String to BigInteger
     * @param messageAsString user input
     * @return ciphered message
     */
    public BigInteger StringToBigInt(String messageAsString) {
        String cipherString = "";
        int i = 0;
        while (i < messageAsString.length()) {
            int character = (int) messageAsString.charAt(i);
            cipherString = cipherString + character;
            i++;
        }
        BigInteger ciphered = new BigInteger(String.valueOf(cipherString));
        return ciphered;
    }

    /**
     * Encrypts the BigInteger form of message
     * @param messageAsBigInteger
     * @return encrypted cipher
     */
    public BigInteger encrypt(BigInteger messageAsBigInteger) {
        BigInteger encrypted = messageAsBigInteger.modPow(keyPair.getPublic(), 
                                                        keyPair.getModulus());
        return encrypted;
    }

    /**
     * Decrypts the BigInteger form of encrypted message
     * @param cipherMessageAsBigInteger
     * @return decrypted cipher
     */
    public BigInteger decrypt(BigInteger cipherMessageAsBigInteger) {
        BigInteger decrypted = cipherMessageAsBigInteger.modPow(keyPair.getPrivate(), 
                                                                keyPair.getModulus());
        return decrypted;
    }

    /**
     * Converts BigInteger.toString() to a String of 
     * corresponding ASCII-characters
     * @param cipherMessageAsBigInt
     * @return
     */
    public String BigIntToString(BigInteger cipherMessageAsBigInt) {
        String cipherAsString = cipherMessageAsBigInt.toString();
        String plainText = "";
        int i = 0;
        while (i+2 <= cipherAsString.length()) {
            int valueOfChar = Integer.parseInt(cipherAsString.substring(i, i+2));
            char character = (char) valueOfChar;
            plainText = plainText + character;
            i += 2;
        }
        return plainText;
    }
    
}
