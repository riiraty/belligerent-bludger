package riiraty.keys;

import java.math.BigInteger;
import riiraty.util.Base64Tool;

/**
 * implementation of RSA Key
 */
public abstract class Key {
    private final BigInteger modulus;
    private final BigInteger exponent;
    
    public Key(BigInteger modulus, BigInteger exponent) {
        this.modulus = modulus;
        this.exponent = exponent;
    }

    public Key(String encodedKey) {
        String key = Base64Tool.decode(encodedKey);
        String[] array = key.split(":");
        this.modulus = new BigInteger(array[0]);
        this.exponent = new BigInteger(array[1]);
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getExponent() {
        return exponent;
    }

    @Override
    public String toString() {
        String key = getModulus().toString() + ":" + getExponent().toString();
        String encodedKey = Base64Tool.encode(key);

        return encodedKey;
    }
}
