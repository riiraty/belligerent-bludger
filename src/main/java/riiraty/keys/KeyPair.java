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

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    @Override
    public String toString() {
        String pub = getPublicKey().toString();
        String key = getPrivateKey().toString();

        String keyPairString = "PUBLIC KEY: " + pub + "\nPRIVATE KEY: " + key + 
                               "\n***  \u001b[31;1mNever share your private key\u001b[0m  ***";

        return keyPairString;
    }
    
}
