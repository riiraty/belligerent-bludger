package riiraty.keys;

import java.math.BigInteger;

/**
 * Implementation for RSA public key.
 */
public class PublicKey {
    private final BigInteger n;
    private final BigInteger e;
    
    public PublicKey(BigInteger n, BigInteger e) {
        this.n = n;
        this.e = e;
    }

    public BigInteger getModulus() {
        return n;
    }

    public BigInteger getPublicExponent() {
        return e;
    }

}
