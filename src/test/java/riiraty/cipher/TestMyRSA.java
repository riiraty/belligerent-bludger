package riiraty.cipher;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.math.BigInteger;

public class TestMyRSA {

    MyRSA crypter;

    @Before
    public void setUp() {
        this.crypter = new MyRSA();
    }
    
    @Test
    public void stringConvertsToBigInt() {
        String testString = "TEST";
        BigInteger stringAsBigInt = crypter.StringToBigInt(testString);

        assertEquals(BigInteger.valueOf(84698384), stringAsBigInt);
    }

    @Test
    public void bigIntConvertsToString() {
        BigInteger testBigInteger = BigInteger.valueOf(84698384);
        String bigIntAsString = crypter.BigIntToString(testBigInteger);

        assertEquals("TEST", bigIntAsString);
    }

}
