package riiraty.keys;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class TestKeyPairGenerator {
    KeyPairGenerator keyPairGenerator;

    @Before
    public void setUp() {
        this.keyPairGenerator = new KeyPairGenerator();
    }
    
    @Test
    public void keygenSetsKeypair() {
        keyPairGenerator.keygen();
        assertTrue(keyPairGenerator.getKeys() != null);
    }

    @Test
    public void gcdReturnsCorrectValue() {
        BigInteger gcd = keyPairGenerator.gcd(BigInteger.valueOf(24), BigInteger.valueOf(18));
        assertEquals(BigInteger.valueOf(6), gcd);
    }

    @Test
    public void generateEReturnsSuitableValue() {
        BigInteger phi = new BigInteger("113451011482074073348236527102968898592979071182448954706040892401083310041937706645848551262161877163697799460170270528146862088949609158564937734374443308029933090344103702116143892237123118938162232342675012142948847755587011438149147540977232299582577163637487692426759032059158234541093525428600026859712");
        BigInteger e = keyPairGenerator.generateE(phi);

        assertTrue(e.max(BigInteger.ONE).equals(e)); // 1 < e
        assertTrue(e.min(phi).equals(e)); // e < phi
        assertEquals(BigInteger.ONE, keyPairGenerator.gcd(e, phi)); // gcd(e, phi) = 1
    }

    @Test
    public void computeDReturnsSuitableValue() {
        BigInteger phi = new BigInteger("113451011482074073348236527102968898592979071182448954706040892401083310041937706645848551262161877163697799460170270528146862088949609158564937734374443308029933090344103702116143892237123118938162232342675012142948847755587011438149147540977232299582577163637487692426759032059158234541093525428600026859712");
        BigInteger e = BigInteger.valueOf(65537);
        BigInteger[] array = keyPairGenerator.computeD(e, phi);
        BigInteger d = array[1];

        assertEquals(BigInteger.ONE, d.multiply(e).mod(phi)); // de(mod(phi)) = 1
    }

    @Test
    public void generatedKeysArePair() {
        keyPairGenerator.keygen();
        PublicKey publicKey = keyPairGenerator.getKeys().getPublicKey();
        PrivateKey privateKey = keyPairGenerator.getKeys().getPrivateKey();

        BigInteger testValue = new BigInteger("123");
        // encrypt c = m^e(mod(n))
        BigInteger cipher = testValue.modPow(publicKey.getExponent(), publicKey.getModulus());
        // decrypt m = c^d(mod(n))
        BigInteger decipher = cipher.modPow(privateKey.getExponent(), privateKey.getModulus());

        assertEquals(testValue, decipher);
    }

}
