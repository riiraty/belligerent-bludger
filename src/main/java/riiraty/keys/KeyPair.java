package riiraty.keys;

/**
 * Implementation of RSA asymmetrical keypair.
 */
public class KeyPair {
    private final PublicKey publicKey;
    private final PrivateKey privateKey;

    public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    
    /** 
     * @return PublicKey
     */
    public PublicKey getPublicKey() {
        return publicKey;
    }

    
    /** 
     * @return PrivateKey
     */
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        String pub = getPublicKey().toString();
        String key = getPrivateKey().toString();

        String keyPairString = pub + "\n" 
                               + key + "\n"
                               + "***  \u001b[31;1mNever share your private key\u001b[0m  ***";

        return keyPairString;
    }
    
}
