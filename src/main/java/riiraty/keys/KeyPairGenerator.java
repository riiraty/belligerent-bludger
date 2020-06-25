package riiraty.keys;

import java.math.BigInteger;
import java.util.Random;

/**
 * Generates RSA keypairs used for encryption and decryption.
 *
 */
public class KeyPairGenerator {
    private KeyPair keyPair;

    /**
     * Computes the needes variables for the keys.
     * n = modulus
     * e = public exponent
     * d = private exponent
     */
    public void keygen() {
        // 1. find two large primes
        BigInteger p = primeGenerator();
        BigInteger q = primeGenerator();

        // 2. compute n = pq
        BigInteger n = p.multiply(q);

        // 3. compute phi(n) = (p-1)(q-1)
        // Euler's totient function
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // 4. find e, where 1 < e < phi 
        // and e is coprime with phi: gcd = 1
        BigInteger e = generateE(phi);

        // 5. compute d with e and phi
        // so that de(mod(phi)) = 1;
        BigInteger d = computeD(e, phi)[1];
        // check that d is not negative
        if (d.min(BigInteger.ZERO).equals(d)) {
            // adding a multiple of phi still satisfies the equation
            d = d.add(phi);
        }

        PublicKey publicKey = new PublicKey(n, e);
        PrivateKey privateKey = new PrivateKey(n, d);

        this.keyPair = new KeyPair(publicKey, privateKey);
    }

    public KeyPair getKeys() {
        return keyPair;
    }

    public BigInteger primeGenerator() {
        Random random = new Random();
        return BigInteger.probablePrime(512, random);
    }

    /**
     * Finds an e that is coprime with phi.
     * Limited tries before a default value is used:
     * 65537 (0x10001), 4th Fermat number, is a prime.
     * 
     * @param phi the totient function of modulus n
     * @return public exponent e
     */
    public BigInteger generateE(BigInteger phi) {
        Random random = new Random();
        BigInteger e;
        BigInteger def = BigInteger.valueOf(65537); // default

        int i = 0;
        int j = 0;
        do {
            e = new BigInteger(1024, random);
            while (e.min(phi).equals(phi)) { // while e > phi
                e = new BigInteger(1024, random);
                i++;
                if (i > 100000) {
                    return def;
                }
            }
            j++;
            if (j > 100000) {
                return def;
            }
        } while (!gcd(e, phi).equals(BigInteger.ONE)); // while gcd(e, phi) != 1

        return e;
    }

    /**
     * Recursive basic Euclidean algorithm to find
     * the greatest common denominator (gcd) of two BigIntegers.
     * 
     * @param a first number
     * @param b second number
     * @return the greatest common denominator
     */
    public BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        } else {
            return gcd(b, a.mod(b));
        }
    }

    /**
     * Recursive Extended Euclidean algorithm to compute
     * the private exponent d.
     * (When called with computeD(e, phi))
     * 
     * @param d
     * @param s
     * @return an array where array[1] is private exponent d
     */
    public BigInteger[] computeD(BigInteger d, BigInteger s) {
        /*
        * extended_euclid(d,s)
            if s = 0
                than return (d,1,0)
            (d',s',t') <-- extended_euclid(s, d mod s)
            return (d',t',s' - (d div s)t')
        */
        if (s.equals(BigInteger.ZERO)) {
            return new BigInteger[]{d, BigInteger.ONE, BigInteger.ZERO};
        }
        BigInteger[] values = computeD(s, d.mod(s));

        BigInteger i = values[0];
        BigInteger j = values[2];
        BigInteger k = values[1].subtract(d.divide(s).multiply(values[2]));
        
        return new BigInteger[]{i, j, k};
    }
    
}
