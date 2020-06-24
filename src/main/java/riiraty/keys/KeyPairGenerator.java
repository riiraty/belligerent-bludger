package riiraty.keys;

import java.math.BigInteger;
import java.util.Random;

/**
 * Computes the needes variables for the keys.
 * n = modulus
 * e = public exponent
 * d = private exponent
 */
public class KeyPairGenerator {
    private KeyPair keyPair;

    public void keygen() {
        // 1. find two large primes
        BigInteger p = primeGenerator();
        BigInteger q = primeGenerator();
        System.out.println("(1/5)");

        // 2. compute n = pq
        BigInteger n = p.multiply(q);
        System.out.println("(2/5)");

        // 3. compute phi(n) = (p-1)(q-1)
        // Euler's totient function
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("(3/5)");

        // 4. find e, where 1 < e < phi 
        // and e is coprime with phi: gcd = 1
        BigInteger e = generateE(phi);
        System.out.println("(4/5)");

        // 5. compute d with e and phi
        // modular inverse: ax = 1 (mod m)
        BigInteger d = computeD(e, phi)[1];
        // check that d is not negative
        if (d.min(BigInteger.ZERO).equals(d)) {
            // adding a multiple of phi still satisfies the equation
            d = d.add(phi);
        }
        System.out.println("(5/5)");

        PublicKey publicKey = new PublicKey(n, e);
        PrivateKey privateKey = new PrivateKey(n, d);

        this.keyPair = new KeyPair(publicKey, privateKey);
        System.out.println(keyPair.toString());
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
     * Limited tries before a default value is used.
     * 65537 0x10001, 4th Fermat number, is a prime
     * 
     * @param phi is the totient function of modulus n
     * @return public exponent
     */
    public BigInteger generateE(BigInteger phi) {
        Random random = new Random();
        BigInteger e;
        BigInteger def = BigInteger.valueOf(65537); // default
        int i = 0;
        int j = 0;
        // do while loop so that e < phi applies
        do {
            e = new BigInteger(1024, random); // generate new e
            while (e.min(phi).equals(phi)) { // while phi < e
                e = new BigInteger(1024, random); // generate new e
                i++;
                if (i > 1000000) {
                    return def;
                }
            }
            j++;
            if (j > 100000) {
                return def;
            }
        } while (!gcd(e, phi).equals(BigInteger.ONE));

        return e;
    }

    /** 
     * Recursive basic Euclidean algorithm to find
     * the greatest common denominator (gcd) of two BigIntegers
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
     * the private exponent d: computeD(e, phi)
     * @param d
     * @param s
     * @return
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
