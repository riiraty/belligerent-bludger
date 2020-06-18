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

        PublicKey publicKey = new PublicKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5OjE5MzkyMzQ5ODk1MDEwOTk3NDk0MjkwNTEzMjA4MzA4NjQzNzYzMTIzNjQwNDM3MzgyMTk3MTg4NTM2MDY0ODA3MzM2MzIwODM1NDM2ODMyODM2NDEwNTIzMTU3MjMwOTgzNjc0NDQwMDI0NDM5OTIwOTgxMjQ5NjIwNDM1MTIzMDE0NTEzMTU2NjU2OTkzOTQxMDQxMzA0ODMzODAyNTU5NjgzODI4Mzk2NTAyNjA0NjA1MTk0MzQ3NjE0NTczOTg1MzY3MTA0NDU2NjA3ODE3MzkwNTcyNjcyODAyODYwNTM4Mzk1MzgwOTI3MTE4Njc1OTc3NjY0Mzk0MTg2OTY4NDQyNTk0Njg0MDA3MTQ3Njc4MzUyODAyOTQ1MTU3NzQxNDgxODc5MDUzNTU0MTY0ODQx");
        PrivateKey privateKey = new PrivateKey("MTA3OTYzNjUwMDU3ODc5NDUzMzA4NTQyOTgyMjcwMjIzODMyNjIxOTg3ODcwMzI2NDc0NTAzNjM0NTQzMDExMzQwNDE5NjI1MjUyNzM0OTIyNDMzNjIzMDk0MDEwNjk5NjU1NTQzMTU5NTMyMjAzNjc4MTE5OTQ2ODM2ODAwODg3NTgwNDU5MzkwODY5OTMzMjU5MjIxMDAzNTI5ODY3NDM0MzMzMjAzMjQyMjYwMjAxODczNjE2MDEwNDA5NzkwMDA4MjgxMjAyMzAwMDI1OTQ3MjYzMjQ4MzQzNDA5MDM3MjQyNjg1MjU0MDQwNDE0NzQ5MjY1MDY3MjgyMDEzMjM1MDIyNDUyODc0MzcxOTYyODM4MDY4NDUwMzEzMDQwNDMwODEwOTc4OTgzNDUxMzI4Mzg5Ojg4NjY5MTUzOTY3MzIzNDY0MDUxOTcwNzEzMTY3NTc1NjUxMDUyMTAwMTgyMjM1MDg3MzU0NTE1MTUxODczMzQ0MjYyNzM0OTA4NjE5Mzk4NTIzOTg5MTczMjY5ODM2MzQ5ODgyNzYxNjQwOTQzNTQ5ODQ5MjU1NTE5MDQxMDEzNTIwODUyNzM4ODMxNjcxMzM5NTcyMDc4OTM3MTM5MDc3Njc1NzY4NDExNDY0Mzc1MzQzNjU2Mzc4MjUzNDg5MjkyNzk0OTYzODYzNjkxMDYwOTk3MzE5NjgwNzc1MDk1MjE4MjE0MDc0NzU5NDUyOTEwNTk2MTkzNzkxNjQxOTc5NDYyMzUyMDEyODUyNDk5MTYwMDUwNzk0MDYyNDQxMTM0OTM0NTY3NDk0Nzg3Mzg2Mzkz");
        KeyPair keyPair = new KeyPair(publicKey, privateKey);
        this. keyCrypter = new Crypter(keyPair);
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
        String encrypted = keyCrypter.encrypt("Test", "");

        assertEquals("NTQzMjY3MzAyODkxMzg5ODU0MjEyODA4MDUxODA4MjgxNzc1MTI1MDYxMjQ4MjgzOTE0NzEzOTQ1NjQyNzE3NTM1MzA4MjQzNDE3NjM1MTU4OTA3NDkyMjE2MTQ1MzA0NDQxOTYwNjI4MzkxNzUzMjE0NDY0MTU5ODgyMTU4MDMwODQ4NjQwMjM3NDIzMjMwOTk2NTY1MzUxMDU5MTU4MzQwMzE3ODUyNzIzNzA4Mzg4NDY2OTYwMTQ0NzQ3NjkxMTYwMjgzNDgyNjI1NDI2NjM5MDUwNTk4NTYxOTYzMzM0NjQwODc2NDc1MzQwODM3ODEyMTQ1NDQ1MDI2NjM4OTc5ODQyMTkxNzQ1MTk4NTA4ODY5MjkyMzYwODAwNzU2NDA5NjE1Mjg4MzU3NDc2OTUwMzI=", encrypted);
    }

    @Test
    public void decryptionWithDefaultKeyWorks() {
        String decrypted = keyCrypter.decrypt("NTQzMjY3MzAyODkxMzg5ODU0MjEyODA4MDUxODA4MjgxNzc1MTI1MDYxMjQ4MjgzOTE0NzEzOTQ1NjQyNzE3NTM1MzA4MjQzNDE3NjM1MTU4OTA3NDkyMjE2MTQ1MzA0NDQxOTYwNjI4MzkxNzUzMjE0NDY0MTU5ODgyMTU4MDMwODQ4NjQwMjM3NDIzMjMwOTk2NTY1MzUxMDU5MTU4MzQwMzE3ODUyNzIzNzA4Mzg4NDY2OTYwMTQ0NzQ3NjkxMTYwMjgzNDgyNjI1NDI2NjM5MDUwNTk4NTYxOTYzMzM0NjQwODc2NDc1MzQwODM3ODEyMTQ1NDQ1MDI2NjM4OTc5ODQyMTkxNzQ1MTk4NTA4ODY5MjkyMzYwODAwNzU2NDA5NjE1Mjg4MzU3NDc2OTUwMzI=", "");

        assertEquals("Test", decrypted);;
    }

    @Test 
    public void encryptionUsesGivenKey() {
        // PublicKey(BigInteger.valueOf(2019302167), BigInteger.valueOf(1004236379));
        String encrypted = keyCrypter.encrypt("Test", "MjAxOTMwMjE2NzoxMDA0MjM2Mzc5");

        assertEquals("NDcxODgxNjA=", encrypted);
    }

    @Test
    public void decrypterUsesGivenKey() {
        // PrivateKey(BigInteger.valueOf(2019302167), BigInteger.valueOf(253632059));
        String decrypted = keyCrypter.decrypt("NDcxODgxNjA=", "MjAxOTMwMjE2NzoyNTM2MzIwNTk=");

        assertEquals("Test", decrypted);;
    }

}
