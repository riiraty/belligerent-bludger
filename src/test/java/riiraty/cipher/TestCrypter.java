package riiraty.cipher;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
    public void encryptionWithDefaultKeyWorks() {
        String encrypted = crypter.encrypt("Test", "");

        assertEquals("NTQzMjY3MzAyODkxMzg5ODU0MjEyODA4MDUxODA4MjgxNzc1MTI1MDYxMjQ4MjgzOTE0NzEzOTQ1NjQyNzE3NTM1MzA4MjQzNDE3NjM1MTU4OTA3NDkyMjE2MTQ1MzA0NDQxOTYwNjI4MzkxNzUzMjE0NDY0MTU5ODgyMTU4MDMwODQ4NjQwMjM3NDIzMjMwOTk2NTY1MzUxMDU5MTU4MzQwMzE3ODUyNzIzNzA4Mzg4NDY2OTYwMTQ0NzQ3NjkxMTYwMjgzNDgyNjI1NDI2NjM5MDUwNTk4NTYxOTYzMzM0NjQwODc2NDc1MzQwODM3ODEyMTQ1NDQ1MDI2NjM4OTc5ODQyMTkxNzQ1MTk4NTA4ODY5MjkyMzYwODAwNzU2NDA5NjE1Mjg4MzU3NDc2OTUwMzI=", encrypted);
    }

    @Test
    public void decryptionWithDefaultKeyWorks() {
        String decrypted = crypter.decrypt("NTQzMjY3MzAyODkxMzg5ODU0MjEyODA4MDUxODA4MjgxNzc1MTI1MDYxMjQ4MjgzOTE0NzEzOTQ1NjQyNzE3NTM1MzA4MjQzNDE3NjM1MTU4OTA3NDkyMjE2MTQ1MzA0NDQxOTYwNjI4MzkxNzUzMjE0NDY0MTU5ODgyMTU4MDMwODQ4NjQwMjM3NDIzMjMwOTk2NTY1MzUxMDU5MTU4MzQwMzE3ODUyNzIzNzA4Mzg4NDY2OTYwMTQ0NzQ3NjkxMTYwMjgzNDgyNjI1NDI2NjM5MDUwNTk4NTYxOTYzMzM0NjQwODc2NDc1MzQwODM3ODEyMTQ1NDQ1MDI2NjM4OTc5ODQyMTkxNzQ1MTk4NTA4ODY5MjkyMzYwODAwNzU2NDA5NjE1Mjg4MzU3NDc2OTUwMzI=", "");

        assertEquals("Test", decrypted);;
    }

    @Test 
    public void encryptionUsesGivenKey() {
        // PublicKey(BigInteger.valueOf(2019302167), BigInteger.valueOf(1004236379));
        String encrypted = crypter.encrypt("Test", "MjAxOTMwMjE2NzoxMDA0MjM2Mzc5");

        assertEquals("NDcxODgxNjA=", encrypted);
    }

    @Test
    public void decrypterUsesGivenKey() {
        // PrivateKey(BigInteger.valueOf(2019302167), BigInteger.valueOf(253632059));
        String decrypted = crypter.decrypt("NDcxODgxNjA=", "MjAxOTMwMjE2NzoyNTM2MzIwNTk=");

        assertEquals("Test", decrypted);;
    }

    @Test
    public void whitespacesRemainAsOriginal() {
        String original = "  This is  a VERY secret  msg     .  ";

        String encrypted = crypter.encrypt(original, "");
        String decrypted = crypter.decrypt(encrypted, "");

        assertEquals(original, decrypted);
    }

    @Test
    public void BasicCharactersRemainAsOriginal() {
        String original = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        String encrypted = crypter.encrypt(original, "");
        String decrypted = crypter.decrypt(encrypted, "");

        assertEquals(original, decrypted);
    }

    @Test
    public void keyCrypterUsesGivenPublicKeyAsDefault() {
        String encrypted = keyCrypter.encrypt("Test", "");
        assertEquals("NDcxODgxNjA=", encrypted);
    }

    @Test
    public void keyCrypterUsesGivenPrivateKeyAsDefault() {
        String decrypted = keyCrypter.decrypt("NDcxODgxNjA=", "");
        assertEquals("Test", decrypted);
    }

}
