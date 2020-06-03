package riiraty.keys;

import java.math.BigInteger;

public class PrivateKey {
    private final BigInteger n;
    private final BigInteger d;
    
    public PrivateKey(BigInteger n, BigInteger d) {
        this.n = n;
        this.d = d;
    }

    public BigInteger getModulus() {
        return n;
    }

    public BigInteger getPrivateExponent() {
        return d;
    }
    
}
