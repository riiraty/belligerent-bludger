package riiraty.math;

/**
 * My own implementation of BigInteger
 */
public class BigInt {

    /**
     * The signum: -1 for negative, 0 for zero and 1 for positive.
     */
    final int signum;

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
        int sign = 1;

        // check if negative
        int index = val.lastIndexOf("-");
        if (index != -1) {
            sign = -1;
            cursor = 1;
        }

        // skip leading zeros, get number of digits
        while (cursor < len &&
               Character.digit(val.charAt(cursor), 10) == 0) {
            cursor++;
        }
        numDigits = len - cursor;

        // String of zeros -> empty array
        if (cursor == len) {
            signum = 0;
            mag = new int[0];
            return;
        }

        numDigits = len - cursor;
        signum = sign;

        int[] magnitude = new int[numDigits];
        for (int i = 0; i < numDigits; i++) {
            magnitude[i] = Character.digit(val.charAt(cursor), 10);
            cursor++;
        }

        mag = magnitude;
    }

    // Constants
    public static final BigInt ZERO = new BigInt("0");
    public static final BigInt ONE = new BigInt("1");

    
    /** 
     * @return String
     */
    public String toString() {
        // if zero
        if (signum == 0) {
            return "0";
        }

        String value = "";

        // if negative
        if (signum == -1) {
            value += "-";
        }

        for (int digit : mag) {
            value += digit;
        }
        return value;
    }
    
}
