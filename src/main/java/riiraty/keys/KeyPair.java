package riiraty.keys;

import java.math.BigInteger;

/**
 * Implementation of RSA asymmetrical key pair
 */
public class KeyPair {
    private BigInteger n; // modulus
    private BigInteger e; // public exponent
    private BigInteger d; // private exponent

    public KeyPair(BigInteger n, BigInteger e, BigInteger d) {
        this.n = n;
        this.e = e;
        this.d = d;
    }

    public BigInteger getModulus() {
        return n;
    }

    public BigInteger getPublic() {
        return e;
    }

    public BigInteger getPrivate() {
        return d;
    }
    
}
