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

    /**
     * Translates String representation of BigInt in the radix
     * 10 into a BigInt. 
     * @param val String representation of BigInteger
     */
    public BigInt(String val) {
        int cursor = 0;
        int numDigits;
        final int len = val.length();

        //to do: check if negative

        // skip leading zeros, get number of digits
        while (cursor < len &&
               Character.digit(val.charAt(cursor), 10) == 0) {
            cursor++;
        }
        numDigits = len - cursor;

        // String of zeros -> empty array
        if (numDigits == 0) {
            mag = new int[0];
            return;
        }

        int[] magnitude = new int[numDigits];
        for(int i = cursor; i < len; i++) {
            magnitude[i] = Character.digit(val.charAt(cursor), 10);
        }
        mag = magnitude;
    }

    public String toString() {
        String value = "";
        for (int digit : mag){
            value += digit;
        }
        return value;
    }
    
}