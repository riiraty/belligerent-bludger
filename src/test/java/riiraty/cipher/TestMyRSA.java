package riiraty.cipher;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import riiraty.keys.KeyPair;


public class TestMyRSA {

    MyRSA crypter;
    MyRSA keyCrypter;

    @Before
    public void setUp() {
        this.crypter = new MyRSA();

        KeyPair keyPair = new KeyPair(BigInteger.valueOf(2019302167), //modulus
                                      BigInteger.valueOf(1004236379), // e 
                                      BigInteger.valueOf(253632059)); // d
        this.keyCrypter = new MyRSA(keyPair);
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

    @Test 
    public void encrypterReturnsProperBigInt() {
        BigInteger encrypted = keyCrypter.encrypt(BigInteger.valueOf(84698384));

        assertEquals(BigInteger.valueOf(863379213), encrypted);
    }

    @Test
    public void decrypterReturnsProperBigInt() {
        BigInteger decrypted = keyCrypter.decrypt(BigInteger.valueOf(863379213));

        assertEquals(BigInteger.valueOf(84698384), decrypted);
    }

}
