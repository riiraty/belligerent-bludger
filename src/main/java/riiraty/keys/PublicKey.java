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

}
