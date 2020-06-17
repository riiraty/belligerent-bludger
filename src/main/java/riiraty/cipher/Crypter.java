package riiraty.cipher;

import java.math.BigInteger;
import riiraty.keys.KeyPair;
import riiraty.util.Base64Tool;

/**
 * Tool for crypting messages with RSA-keys
 */
public class Crypter {
    private KeyPair keyPair;

    /**
     * Constructor sets the KeyPair used for cryption.
     * 
     * @param keyPair
     */
    public Crypter(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public Crypter() {
        // for testing
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public String getEncodedKeyPair() {
        return keyPair.toString();
    }

    /**
     * This method encrypts a String with RSA public key.
     * Base64 encoding is used for the ciphered BigInt.
     * 
     * @param msg as String
     * @return ciphered message encoded to Base64
     */
    public String encrypt(String msg) {
        BigInteger msgBigInt = messageToBigInt(msg);
        BigInteger encrypted = msgBigInt.modPow(keyPair.getPublicKey().getExponent(), 
                                                keyPair.getPublicKey().getModulus());
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
    public String decrypt(String cipher) {
        String decoded = Base64Tool.decode(cipher);
        BigInteger asBigInt = new BigInteger(decoded);
        BigInteger decrypted = asBigInt.modPow(keyPair.getPrivateKey().getExponent(), 
                                               keyPair.getPrivateKey().getModulus());
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
