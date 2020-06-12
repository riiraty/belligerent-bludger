# Implementation of the project

## Implemented classes

### KeyPairGenerator

RSA cryption requires a pair of keys:

* <code>PublicKey</code> consists of modulus *n* and public exponent *e*  and is used to encrypt messages

* <code>PrivateKey</code> consists of modulus *n* and private exponent *d* and is used to decrypt messages

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

    Greatest common denominator (gcd) for two numbers is found using (basic) Euclidean algorithm

    ```
    gcd(a, b)
        if b = 0
            then return a
        else
            return gcd(b, a mod(b))
    ```
    Exponent *e* is chosen by producing random primes of desired bit size, and checking that they satisfy both conditions. Default value is used, if suitable *e* is not found after reasonable amount of attempts.

5. Using Extended Euclidean algorithm, compute private exponent *d*

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

##### BigInt

Holds large numbers by storing digits in <code>int[]</code>. 

Signum of the number is stored in <code>int</code>: 1 for positives, 0 for zero and -1 for negatives. 

Has <code>static</code> constants for 1 and 0.

##### Random

## Achieved time- and space complexity

## Performance

## Defects and possible improvements

## References