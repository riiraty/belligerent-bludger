## Requirements document

The project will implement RSA (Rivest–Shamir–Adleman) cryptography algorithm. Cryptography is an interest of mine, I want to use this opportunity to get in to subject hands on. There will be a text-based user interface.

The project will be in Java and use Gradle. I'm planning to use JUnit for tests and Jacoco to measure coverage. Might also configure Checkstyle.

#### Algorithms to implement

1. Generating the private and the public key

   * Generating random prime numbers for the keys
   * Calculating needed variables

2. Encrypting the input with public key

   * Converting plain text first to numbers

3. Decrypting the message with private key

   * Converting decrypted message to plain text

#### Data structures needed

* Keys (Private and Public)
* BigInteger (to use in keys and message)
* ? 

#### Received inputs

User will input plain text. There will be some limit how long the input message can be.

User can give command to generate keys for later use. 

User can encrypt by inputting the message and the public key they want to use.

User can decrypt by inputting the encrypted message and their private key.

#### Targets for time and space complexity

I am not sure yet what time complexity is the goal. There are several steps to implement (exponentiation, inversion and modular operation) for the RSA and I have to research their implementation options more.

#### References

[Cryptography](https://en.wikipedia.org/wiki/Cryptography). (n.d.). Wikipedia. Accessed: 15.5.2020

[RSA (cryptosystem)](https://en.wikipedia.org/wiki/RSA_(cryptosystem)). (n.d.). Wikipedia. Accessed: 15.5.2020

[Public-key cryptography](https://en.wikipedia.org/wiki/Public-key_cryptography). (n.d.). Wikipedia. Accessed: 15.5.2020

[Eddie Woo](https://www.youtube.com/watch?v=oOcTVTpUsPQ) (2014). The RSA Encryption Algorithm (2 of 2: Generating the Keys). Accessed: 15.5.2020

[Interface RSAKey](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/security/interfaces/RSAKey.html) (n.d.) Oracle Docs. Accessed: 15.5.2020

[Class BigInteger](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigInteger.html). (n.d.) Oracle Docs. Accessed: 15.5.2020

[RSA Cryptography Algorithm](http://algohub.me/algo/rsa-cryptography-algorithm.html). (2017). AlgorithmHub. Accessed: 15.5.2020

[https://www.quora.com/What-is-the-complexity-of-RSA-cryptographic-algorithm](https://www.quora.com/What-is-the-complexity-of-RSA-cryptographic-algorithm). Accessed: 15.5.2020

[https://crypto.stackexchange.com/questions/6164/how-do-i-derive-the-time-complexity-of-encryption-and-decryption-based-on-modula](https://crypto.stackexchange.com/questions/6164/how-do-i-derive-the-time-complexity-of-encryption-and-decryption-based-on-modula). Accessed: 15.5.2020
