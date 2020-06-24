package riiraty.keys;

import java.math.BigInteger;

/**
 * Implementation for RSA public key.
 * Is used to encrypt messages.
 */
public class PublicKey extends Key {

    public PublicKey(BigInteger n, BigInteger e) {
        super(n, e);
    }

    public PublicKey(String key) {
        super(key);
    }

    @Override
    public String toString() {
        return "\u001b[1mPUBLIC KEY: \u001b[0m" + super.toString();
    }
}
