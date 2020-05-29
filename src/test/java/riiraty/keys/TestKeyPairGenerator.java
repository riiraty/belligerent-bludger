package riiraty.keys;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestKeyPairGenerator {
    KeyPairGenerator keygen;

    @Before
    public void setUp() {
        this.keygen = new KeyPairGenerator();
    }
    
    @Test
    public void constructorCreatesKeypair() {
        assertTrue(keygen.getKeys() != null);
    }

}
