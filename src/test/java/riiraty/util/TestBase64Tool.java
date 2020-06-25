package riiraty.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;;

public class TestBase64Tool {

    @Test
    public void encodingWorks() {
        String test = "test";
        String encoded = Base64Tool.encode(test);

        assertEquals("dGVzdA==", encoded);
    }

    public void decodingWorks() {
        String encoded = "dGVzdA==";
        String decoded = Base64Tool.decode(encoded);

        assertEquals("test", decoded);
    }
    
}
