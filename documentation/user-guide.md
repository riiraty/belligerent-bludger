### User guide for the project

#### Getting started

Clone the repository to your computer. You need [Gradle](https://gradle.org/) to run the following commands.

#### Commands

##### Before
```
$ gradle clean
```

##### Run tests
```
$ gradle test
```
See the report at: file:///{RepositoryRoot}/build/reports/tests/test/index.html

##### Create codecoverage report
```
 $ gradle test jacocoTestReport
```
See the report at: file:///{RepositoryRoot}/build/reports/jacoco/test/html/index.html

##### Check  for code style violations
```
$ gradle checkstyleMain
```
See the report at: file:///{RepositoryRoot}/build/reports/checkstyle/main.html

##### Run build script
```
$ gradle build
```
##### Run the program
```
$ gradle run
```

#### To run the program

create a jar file
```
$ gradle jar
$ java -jar build/libs/project.jar
```
or simply command
```
$ gradle --console=plain run -q
```

#### Command Line Interface

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/command-options.png "command options")

##### Encryption

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/encrypt-default.png "encryption example")

Maximum input for encryption is 128 characters, because a keysize of 1024 bit is in use. Only basic ASCII printing characters are allowed as input: [a-zA-Z0-9!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~]. Resulting cipher text is printed with Base64 encoding.

##### Decryption

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/decrypt-default.png "decryption example")

The input format for cipher text is the Base64 encoded text the encryption command produces. Decryption has to be done with the pair of the key used for encryption.

##### Generating keys

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/keygen.png "keygen example")

The command <code>keygen</code> creates a new keypair with keysize 1024 bit and prints the pair of keys encoded with Base64 scheme. The public key is used for encryption and the private key is used for decryption. The progran does not have a function to store keys.

##### Using spesific key

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/decrypt-keygen-key.png "key input example")

It is possible to use an another key pair for encryption or decryption instead of the default keys.

##### Performance testing

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/test-100000.png "performance test example")

The command <code>test</code> will run a perfomance test with specified amount of rounds from which the average run times are calculated from.
