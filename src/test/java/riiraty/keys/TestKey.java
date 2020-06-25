package riiraty.keys;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class TestKey {

    @Test
    public void stringConctructorCreatesKeyWithCorrectValues() {
        Key key = new PublicKey("MjAxOTMwMjE2NzoxMDA0MjM2Mzc5");

        BigInteger modulus = key.getModulus();
        BigInteger exponent = key.getExponent();

        assertEquals(BigInteger.valueOf(2019302167), modulus);
        assertEquals(BigInteger.valueOf(1004236379), exponent);
    }
    
}
