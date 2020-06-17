### User guide for the project (17.6.2020)

Clone the repository to your computer.

To run the program
```
$ gradle jar
$ java -jar build/libs/project.jar
```
or
```
$ gradle --console=plain run -q
```

Maximum input for encryption is 128 characters, because a keysize of 1024 bit is in use. Only basic ASCII printing characters are allowed as input (excludes ä, ö etc.).

Keygen creates a new keypair with keysize 1024 bit and prints computed values and finally the pair of keys encoded with Base64 scheme. The progran does not have a function to store keys.

User can input a key (encoded <code>String</code> that keygen provides) they want to use for encryption or decryption, if user does not provide a key a default key is used. 

The program currently does not check user input and expects valid inputs.
