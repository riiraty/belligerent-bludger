package riiraty.cipher;

import java.math.BigInteger;
import java.util.Base64;
import riiraty.keys.KeyPair;

/**
 * Tool for crypting messages with RSA-keys
 */
public class MyRSA {
    private KeyPair keyPair;

    /**
     * Constructor sets the KeyPair used for cryption.
     * 
     * @param keyPair
     */
    public MyRSA(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public MyRSA() {
        // for testing
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
        BigInteger encrypted = msgBigInt.modPow(keyPair.getPublicKey().getPublicExponent(), 
                                                keyPair.getPublicKey().getModulus());
        String cipher = encodeBase64(encrypted.toString());

        return cipher;
    }

    /**
     * This method decrypts a cipher String with RSA private key.
     * Base64 decoding is used to reverse the encoding done while encrypting.
     * 
     * @param cipher
     * @return
     */
    public String decrypt(String cipher) {
        String decoded = decodeBase64(cipher);
        BigInteger asBigInt = new BigInteger(decoded);
        BigInteger decrypted = asBigInt.modPow(keyPair.getPrivateKey().getPrivateExponent(), 
                                               keyPair.getPrivateKey().getModulus());
        String message = BigIntToString(decrypted);

        return message;
    }

    /**
     * Converts String to BigInt.
     * 
     * @param message as String
     * @return message as BigInt
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
     * @return
     */
    public String BigIntToString(BigInteger cipher) {
        byte[] bytes = cipher.toByteArray();
        String msgString = new String(bytes);

        return msgString;
    }

    /**
     * Encodes String with Base64.
     * 
     * @param arg 
     * @return
     */
    public String encodeBase64(String arg) {
        String encoded = Base64.getEncoder().encodeToString(arg.getBytes());

        return encoded;
    }

    /**
     * Decodes String with Base64.
     * 
     * @param arg
     * @return
     */
    public String decodeBase64(String arg) {
        byte[] bytes = Base64.getDecoder().decode(arg);
        String decoded = new String(bytes);

        return decoded;
    }
    
}
