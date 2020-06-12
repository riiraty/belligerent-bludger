package riiraty.math;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBigInt {

    @Test
    public void magnitudeArrayLengthCorrespondsStringCharCount() {
        BigInt num = new BigInt("123");
        assertTrue(num.mag.length == 3);
    }

    @Test
    public void negativeValueConstructedRight() {
        BigInt num = new BigInt("-123");
        assertTrue(num.mag.length == 3);
        assertTrue(num.signum == -1);
    }
    
    @Test
    public void stringOfZerosLeadsToZeroLengthMagnitudeArray() {
        BigInt num = new BigInt("000");
        assertTrue(num.mag.length == 0);
    }

    @Test
    public void leadingZerosAreStripped() {
        BigInt num = new BigInt("000123");
        assertTrue(num.mag.length == 3);
    }

    @Test
    public void toStringProducesValueOfOriginalString() {
        BigInt num = new BigInt("456");
        assertEquals("456", num.toString());
    }

    @Test
    public void zeroIsPrintedRight() {
        BigInt num = new BigInt("0");
        assertEquals("0", num.toString());
    }

    @Test
    public void negativeValueIsPrintedWithSignum() {
        BigInt num = new BigInt("-1");
        assertEquals("-1", num.toString());
    }
}
