## Week 4

#### Progress

More style checks were added, and resulting warnings got fixed. 

Single keys are implemented and required refactoring of the code is done. 

Base64 encoding is added to make the cipher printable. Required methods for RSA crypter are implemented or updated accordingly.

Resulting broken unit tests are fixed. Manual testing was done to debug the code, and I made an extra command to the CLI to avoid having to type test inputs by hand every time.

I started to work on the documents. General info about unit testing was updated to the testing document. Implementation document now describes the implementation of the core classes. User guide has some basic info of the current state of the program.

I've been researching BigInteger to figure out how to implement it, mainly by reading source code and documentation for java.lang classes. 

#### Problems

Implementing BigInteger doesn't seem too simple. I'm still trying to figure out some conversions and I don't know yet how to work the arithmetic operations. 

#### Work hours record

Date | Time (h) | Progress
-----|----------|----------
3.6.| 6 | Adding more style checks, implementing keys and refactoring code, adding Base64 encoding, fixing broken tests, secret *test* command to CLI for manual testing
4.6.| 2,5 | Working on documentation
5.6.| 6,5 | Fixing markdown math, fixing bug from keygen, adding user guide, researching BigInteger implementation and reading source code
Total: | 15