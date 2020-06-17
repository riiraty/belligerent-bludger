package riiraty.keys;

import java.math.BigInteger;

/**
 * Implementatin of RSA private key.
 * Is used to decrypt messages.
 */
public class PrivateKey extends Key {
    
    public PrivateKey(BigInteger n, BigInteger d) {
        super(n, d);
    }
    
    public PrivateKey(String key) {
        super(key);
    }
}
