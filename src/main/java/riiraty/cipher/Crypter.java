package riiraty.cipher;

import java.math.BigInteger;
import riiraty.keys.KeyPair;
import riiraty.keys.PublicKey;
import riiraty.keys.PrivateKey;
import riiraty.util.Base64Tool;

/**
 * Tool for crypting messages with RSA-keys
 */
public class Crypter {
    private KeyPair defaultKeyPair;

    /**
     * Constructor sets the given KeyPair as default.
     * 
     * @param keyPair is set as default
     */
    public Crypter(KeyPair keyPair) {
        this.defaultKeyPair = keyPair;
    }

    /**
     * Constructor sets a default KeyPair.
     */
    public Crypter() {
        // 1024 bit keysize, makes max input 128 chars
        PublicKey publicKey = new PublicKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5OjE5MzkyMzQ5ODk1MDEwOTk3NDk0MjkwNTEzMjA4MzA4NjQzNzYzMTIzNjQwNDM3MzgyMTk3MTg4NTM2MDY0ODA3MzM2MzIwODM1NDM2ODMyODM2NDEwNTIzMTU3MjMwOTgzNjc0NDQwMDI0NDM5OTIwOTgxMjQ5NjIwNDM1MTIzMDE0NTEzMTU2NjU2OTkzOTQxMDQxMzA0ODMzODAyNTU5NjgzODI4Mzk2NTAyNjA0NjA1MTk0MzQ3NjE0NTczOTg1MzY3MTA0NDU2NjA3ODE3MzkwNTcyNjcyODAyODYwNTM4Mzk1MzgwOTI3MTE4Njc1OTc3NjY0Mzk0MTg2OTY4NDQyNTk0Njg0MDA3MTQ3Njc4MzUyODAyOTQ1MTU3NzQxNDgxODc5MDUzNTU0MTY0ODQx");
        PrivateKey privateKey = new PrivateKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5Ojg4NjY5MTUzOTY3MzIzNDY0MDUxOTcwNzEzMTY3NTc1NjUxMDUyMTAwMTgyMjM1MDg3MzU0NTE1MTUxODczMzQ0MjYyNzM0OTA4NjE5Mzk4NTIzOTg5MTczMjY5ODM2MzQ5ODgyNzYxNjQwOTQzNTQ5ODQ5MjU1NTE5MDQxMDEzNTIwODUyNzM4ODMxNjcxMzM5NTcyMDc4OTM3MTM5MDc3Njc1NzY4NDExNDY0Mzc1MzQzNjU2Mzc4MjUzNDg5MjkyNzk0OTYzODYzNjkxMDYwOTk3MzE5NjgwNzc1MDk1MjE4MjE0MDc0NzU5NDUyOTEwNTk2MTkzNzkxNjQxOTc5NDYyMzUyMDEyODUyNDk5MTYwMDUwNzk0MDYyNDQxMTM0OTM0NTY3NDk0Nzg3Mzg2Mzkz");
        KeyPair keyPair = new KeyPair(publicKey, privateKey);
        this.defaultKeyPair = keyPair;
    }

    /**
     * This method encrypts a String with RSA public key.
     * Base64 encoding is used for the ciphered BigInt.
     * 
     * @param msg as String
     * @return ciphered message encoded with Base64
     */
    public String encrypt(String msg, String key) {
        BigInteger msgBigInt = messageToBigInt(msg);
        BigInteger encrypted;
        // encrypt c = m^e(mod(n))
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
        // decrypt m = c^d(mod(n))
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
     * Converts String to BigInteger.
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
     * Converts BigInteger to String.
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
