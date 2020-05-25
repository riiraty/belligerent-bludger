package riiraty.keys;

import java.math.BigInteger;
import java.util.Random;


/**
 * Computes the needes variables for the keys.
 */
public class KeyGenerator {
    private BigInteger n; // modulus
    private BigInteger e; // public exponent
    private BigInteger d; // private exponent

    public KeyGenerator() {
        // 1. find two large primes
        BigInteger p = primeGenerator();
        BigInteger q = primeGenerator();

        // 2. compute n = pq
        this.n = p.multiply(q);
        System.out.println("Modulus: " + n);

        // 3. compute phi(n) = (p-1)(q-1)
        // Euler's totient function
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("Phi: " + phi);

        // 4. find e, where 1 < e < phi 
        // and e is coprime with phi: gcd = 1
        this.e = generateE(phi);
        System.out.println("public exponent e: " + e);

        // 5. compute d with e and phi
        this.d = computeD(e, phi)[1];
        System.out.println("private exponent d: " + d);
    }

    public BigInteger primeGenerator() {
        Random random = new Random();
        return BigInteger.probablePrime(16, random);
    }

    /**
     * Finds an e that is coprime with phi
     * Takes its sweet time... 
     * Possibly infinite loop
     * @param phi
     * @return public exponent
     */
    public BigInteger generateE(BigInteger phi) {
        Random random = new Random();
        BigInteger e = new BigInteger(32, random);
        // do while loop so that e < phi applies
        do {
            while (e.min(phi).equals(phi)) { // while phi < e
                e = new BigInteger(32, random); // generate new e
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
