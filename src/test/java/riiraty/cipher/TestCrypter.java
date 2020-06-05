package riiraty.cipher;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigInteger;
import riiraty.keys.PublicKey;
import riiraty.keys.PrivateKey;
import riiraty.keys.KeyPair;

public class TestCrypter {

    Crypter crypter;
    Crypter keyCrypter;

    @Before
    public void setUp() {
        this.crypter = new Crypter();

        // // Generated with riiraty.keys.KeyPairGenerator, keysize 32 bit
        PublicKey publicKey = new PublicKey(BigInteger.valueOf(2019302167), 
                                            BigInteger.valueOf(1004236379));
        PrivateKey privateKey = new PrivateKey(BigInteger.valueOf(2019302167), 
                                               BigInteger.valueOf(253632059));
        KeyPair keyPair = new KeyPair(publicKey, privateKey);
        this.keyCrypter = new Crypter(keyPair);
    }
    
    @Test
    public void messageStringConvertsToBigInt() {
        String testString = "Test";
        BigInteger stringAsBigInt = crypter.messageToBigInt(testString);

        assertEquals(BigInteger.valueOf(1415934836), stringAsBigInt);
    }

    @Test
    public void bigIntConvertsToString() {
        BigInteger testBigInteger = BigInteger.valueOf(1415934836);
        String bigIntAsString = crypter.BigIntToString(testBigInteger);

        assertEquals("Test", bigIntAsString);
    }

    @Test 
    public void encrypterReturnsCipher() {
        String encrypted = keyCrypter.encrypt("Test");

        assertEquals("NDcxODgxNjA=", encrypted);
    }

    @Test
    public void decrypterReturnsOriginalMessage() {
        String decrypted = keyCrypter.decrypt("NDcxODgxNjA=");

        assertEquals("Test", decrypted);;
    }

}
