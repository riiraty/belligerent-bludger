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

        // 3. compute phi(n) = (p-1)(q-1)
        // Euler's totient function
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // 4. find e, where 1 < e < phi and e is coprime with phi
        // generate random BigIntegers that are smaller than phi
        // check if they are coprime with phi:
        // the greatest common denominator should be 1

        // 5. calculate d
        // recursice extended Euclidean algorithm
    }

    public BigInteger primeGenerator() {
        Random random = new Random();
        return BigInteger.probablePrime(512, random);
    }
    
}
