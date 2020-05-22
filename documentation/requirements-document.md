## Requirements document

The project will implement RSA (Rivest–Shamir–Adleman) cryptography algorithm. Cryptography is an interest of mine, I want to use this opportunity to get in to subject hands on. There will be a command line interface.

The project will be in Java and use Gradle. JUnit will be used for tests and Jacoco to measure coverage. Code quality is to be checked with Checkstyle. CircelCI will ensure there are no "works on my machine" problems and Codecov will give easy access to coverage reports.

#### Algorithms to implement

* Generating Keys

    1. Find large primes *p* and *q*.
    
        Generate random numbers and check with *Miller-Rabin primality test* if they are prime numbers.

    2. Compute modulus *n* from *p* and *q*.

        *n* = *pq*

    3. Compute phi(*n*) with Euler's totient function.

        phi(*n*) = (*p*-1)(*q*-1)

    4. Find *e*, the public exponent.
     
        1 < e < phi(*n*) and *e* is coprime with phi(*n*).

        Generate  random numbers of desired bit size that are smaller than phi(*n*).

        Calculate the greatest common denominator with phi(*n*) using *Euclidean algorithm*, hoping for 1 as the value.
        
        Other possibility would be use binary representation and for example *Binary GCD algorithm*.

    5. Calculate *d*, the private exponent.

        *d* = *e⁻¹(mod phi(*n*))

        Find the multiplicative inverse with *Extended Euclidean algorithm*

* Encrypting the input with a public key

   1. Converting plain text to numbers

   2. Crypting with modular exponentiation

* Decrypting the message with a private key

    1. Decrypting with modular exponentiation

    2. Converting the decrypted message to plain text

#### Data structures needed

* Keys (Private and Public)
* BigInteger (to use in keys and cipher messages)

#### Received inputs

User will input plain text. There will be some limit how long the input message can be.

User can give command to generate keys for later use. 

User can encrypt by inputting the message and the public key they want to use.

User can decrypt by inputting the encrypted message and their private key.

#### Targets for time and space complexity

Complexity estimates for the keygen algorithms varied a lot between resources. Generating all the required variables for the keys requires several algorithms. Encryption and decryption are done with modular exponentiation.

The algorithms rely on arithmetic operations of BigInteger.

*Miller-Rabin primality test* should have time complexity of O( *k* log³*n*), where *n* is the number tested for primality, and *k* is the number of rounds performed.

*Euclidean algorithm*: O(log N).

*Extended Euclidean algorithm*: O(log *m*²)

Encryption and decryption are both done with modular exponentiation, time complexity: O(N³).

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

[Miller-Rabin primality test](https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test). (n.d.). Wikipedia. Accessed 22.5.2020

[Euclidean algorithm](https://en.wikipedia.org/wiki/Euclidean_algorithm). (n.d.). Wikipedia. Accessed: 22.5.2020

[Binary QCD algorithm](https://en.wikipedia.org/wiki/Binary_GCD_algorithm). (n.d.). Wikipedia. Accessed: 22.5.2020

[Extended Euclidean algorithm](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm). (n.d.). Wikipedia. Accessed: 22.5.2020

[https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/](https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/). Accessed: 22.5.2020
