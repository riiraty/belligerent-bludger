## Week 3

#### Progress

Implementing my own *KeyPairGenerator* with java.math.BigInteger. Including implementation of Euclidean algorithm and Extended Euclidean algorithm. Setting a default value for public exponent *e* after limited attempts to generate one. Handling situations when computed *d* is of negative value.

Implementig class *KeyPair* to hold a generated pair of keys.

Figuring out Base64 encoding to make cipher printable.

Writing unit tests for implemented classes.

#### Problems

I have been planning to store users keys in to files. The idea is that user would have only on keypair at a time, but could store several public keys of others to decrypt messages with. Should I have a file for each public key or store all in a single file? And since this is more of a CLI usability problem, should I even be spending time on this? 

#### Work hours record

Date | Time (h) | Progress
-----|----------|----------
25.5.| 5 | First unit tests, rest of keygen steps
26.5.| 3,5 | Improving keygen, implementing keypair, refactoring code
28.5.| 4,5 | Researching Base64 encoding, designin class structure and key storing options
29.5.| 3,5 | Unit tests for implemented classes, reading Gradle docs
Total:| 16,5