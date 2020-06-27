# Implementation of the project

## Implemented classes

### Keys and KeyPairGenerator

RSA cryption requires a pair of keys:

* <code>PublicKey</code> consists of modulus *n* and public exponent *e*  and is used to encrypt messages

* <code>PrivateKey</code> consists of modulus *n* and private exponent *d* and is used to decrypt messages

A <code>Key</code> is a pair of numbers in form of <code>BigInteger</code>: modulus and exponent. <code>String</code> representation of a <code>Key</code> is "{modulus}:{exponent}" encoded with Base64 scheme.

Needed variables for the keys are computed as follows:

1. Find two large primes, *p* and *q*

    Size of these primes is 512 bit, to get approximately size 1048 bit for keysize (bit size of modulus).

2. Compute modulus *n* , where

    *n = pq*

3. Using Euler's totient function, compute *&Phi;(n)*, where 

    *&Phi;(n) = (p-1)(q-1)*

4. Find public exponent *e* , where 

    * *1 < e < &Phi;(n)*

    * *gcd(e, &Phi;(n)) = 1* 
    
    The latter meaning that *e* is coprime with *&Phi;(n)*

    Greatest common denominator (gcd) for two numbers is found using (basic) Euclidean algorithm. Time complexity O(log N).

    ```
    gcd(a, b)
        if b = 0
            then return a
        else
            return gcd(b, a mod(b))
    ```
    Exponent *e* is chosen by producing random primes of desired bit size, and checking that they satisfy both conditions. Default value is used, if suitable *e* is not found after reasonable amount of attempts. 

5. Using Extended Euclidean algorithm, compute private exponent *d*, so that

    * *de(mod(&Phi;(n))) = 1* 

    Time complexity O(log N), space complexity O(1). The extended euclidean algorithm takes the same time complexity as the basic algorithm as the process is same with the difference that extra data is processed in each step.
    ```
    extended_euclid(d,s)
        if s = 0
            than return (d,1,0)
        (d',s',t') <-- extended_euclid(s, d mod s)
        return (d',t',s' - (d div s)t')
    ```

    To get *d*, method is called with *e* and *&Phi;(n)*.

### RSA crypter

A generated asymmetrical <code>KeyPair</code> is used for RSA cryption

##### Encryption

* User input is plain text

* The message is given as <code>String</code> and converted into <code>BigInteger</code> representation of it

* Encryption is done using <code>PublicKey</code> :

    *c = m<sup>e</sup>* mod *(n)* , where *m* is the message as <code>BigInteger</code>

* Formed cipher is encoded with <code>Base64</code> to make it printable and readable for the user

##### Decryption

* User input is plain text

* The cipher is decoded with <code>Base64</code> and the resulting <code>String</code> constructs a <code>BigInteger</code>

* Decryption is done with <code>PrivateKey</code> :

    *m = c<sup>d</sup>* mod *(n)* , where *c* is the cipher as <code>BigInteger</code>

* The resulting <code>BigInteger</code> is turned in to <code>String</code> representation, and this is the original message

### Math

<code>BigInt</code> holds large numbers by storing digits in <code>int[]</code>. 

Signum of the number is stored in <code>int</code>: 1 for positives, 0 for zero and -1 for negatives. 

Has <code>static</code> constants for 1 and 0.

This implementation is not in use since it is still mostly unfinished. Program uses java.math.BigInteger and its operations.

The program uses java.util.Random, because <code>BigInteger.probablePrime()</code> takes <code>Random</code> as a parameter.

## Performance

Roughly speaking the generation of a <code>KeyPair</code> takes 9 milliseconds and both encryption and decryption take 0.5 milliseconds. These results are from running <code>Tester</code> with 100 000 rounds. There is more variation in keygen, mostly because of the way the public exponent *e* is generated. Running more rounds would give more certain results.

## Defects and possible improvements

Implementation does not include possibility to use a pair of keys to sign messages.

There is no padding scheme in use, so cipher is always the same if a plaintext is encrypted multiple times. 

Keysize is constant (1024) without option to change it. 

User cannot change the default keys, since UI and Cypter are not written with option to set default keypair after constuctors sets it.

Max input is 128 characters, because the plaintext is handled as a single block.

Only basic ASCII characters are in use.

## References

https://www.di-mgt.com.au/rsa_alg.html#keygen

https://www.di-mgt.com.au/rsa_alg.html#note2

https://crypto.stackexchange.com/questions/10805/how-does-one-deal-with-a-negative-d-in-rsa

https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/

https://www.di-mgt.com.au/euclidean.html

https://en.wikipedia.org/wiki/Euclidean_algorithm#Algorithmic_efficiency

https://iq.opengenus.org/extended-euclidean-algorithm/

http://algohub.me/algo/rsa-cryptography-algorithm.html

https://stackoverflow.com/questions/28838136/rsa-turning-string-to-biginteger

https://www.baeldung.com/java-base64-encode-and-decode

http://hg.openjdk.java.net/jdk/jdk11/file/tip/src/java.base/share/classes/java/math/BigInteger.java

https://blog.trailofbits.com/2019/07/08/fuck-rsa/
