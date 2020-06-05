### User guide for the project (5.6.2020)

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

Maximum input for encryption at the monment is 4 characters, because a default keypair of size 32 bit is in use. Only basic ASCII printing characters are allowed as input (excludes ä, ö etc.).

Keygen creates a new keypair with keysize 1024 bit and prints computed values.
