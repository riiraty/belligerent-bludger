package riiraty.cipher;

import java.math.BigInteger;
import riiraty.keys.*;
import riiraty.util.Base64Tool;

/**
 * Tool for crypting messages with RSA-keys
 */
public class Crypter {
    private KeyPair defaultKeyPair;

    /**
     * Constructor sets the KeyPair used for cryption.
     * 
     * @param keyPair
     */
    public Crypter(KeyPair keyPair) {
        this.defaultKeyPair = keyPair;
    }

    public Crypter() {
        // for testing
    }

    public void setKeyPair(KeyPair keyPair) {
        this.defaultKeyPair = keyPair;
    }

    /**
     * This method encrypts a String with RSA public key.
     * Base64 encoding is used for the ciphered BigInt.
     * 
     * @param msg as String
     * @return ciphered message encoded to Base64
     */
    public String encrypt(String msg, String key) {
        BigInteger msgBigInt = messageToBigInt(msg);
        BigInteger encrypted;

        // if no key was given, use default
        if (key.equals("")) {
            encrypted = msgBigInt.modPow(defaultKeyPair.getPublicKey().getExponent(), 
                                         defaultKeyPair.getPublicKey().getModulus());
        } else {
            PublicKey publicKey = new PublicKey(key);
            encrypted =  msgBigInt.modPow(publicKey.getExponent(), publicKey.getModulus());
        }

        String cipher = Base64Tool.encode(encrypted.toString());

        return cipher;
    }

    /**
     * This method decrypts a cipher String with RSA private key.
     * Base64 decoding is used to reverse the encoding done while encrypting.
     * 
     * @param cipher encrypted message encoded with Base64
     * @return decrypted message
     */
    public String decrypt(String cipher, String key) {
        String decoded = Base64Tool.decode(cipher);
        BigInteger asBigInt = new BigInteger(decoded);
        BigInteger decrypted;

        // if no key was given, use default
        if (key.equals("")) {
            decrypted = asBigInt.modPow(defaultKeyPair.getPrivateKey().getExponent(), 
                                        defaultKeyPair.getPrivateKey().getModulus());
        } else {
            PrivateKey privateKey = new PrivateKey(key);
            decrypted = asBigInt.modPow(privateKey.getExponent(), privateKey.getModulus());
        }
        String message = BigIntToString(decrypted);

        return message;
    }

    /**
     * Converts String to BigInt.
     * 
     * @param message as String
     * @return BigInt representation of String
     */
    public BigInteger messageToBigInt(String message) {
        byte[] bytes = message.getBytes();
        BigInteger msgBigInt = new BigInteger(bytes);

        return msgBigInt;
    }

    /**
     * Converts BigInt to String.
     * 
     * @param cipher
     * @return String representation of BigInt 
     */
    public String BigIntToString(BigInteger cipher) {
        byte[] bytes = cipher.toByteArray();
        String msgString = new String(bytes);

        return msgString;
    }
    
}
