package riiraty.util;

import java.util.Base64;

public class Base64Tool {

    /**
     * Encodes String with Base64 scheme.
     * 
     * @param arg 
     * @return encoded String
     */
    public static String encode(String arg) {
        String encoded = Base64.getEncoder().encodeToString(arg.getBytes());

        return encoded;
    }

    /**
     * Decodes String with Base64 scheme.
     * 
     * @param arg
     * @return decoded String
     */
    public static String decode(String arg) {
        byte[] bytes = Base64.getDecoder().decode(arg);
        String decoded = new String(bytes);

        return decoded;
    }
}
