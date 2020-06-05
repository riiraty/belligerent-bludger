package riiraty.math;

/**
 * My own implementation of BigInteger
 */
public class BigInt {

    /**
     * The magnitude of this BigInt.
     * Zeroth elementh most-significant.
     */
    final int[] mag;

    public BigInt(String stringRep) {
        this.mag = new int[stringRep.length()];
    }
    
}