# Testing of the project

## Unit testing

Unit tests are written with JUnit. Main.java, UI and Tester.java have no tests and are excluded from coverage reports. Getters, setters and toStrings are not tested either.

Test coverage report is put together with Jacoco and can be viewed in [Codecov](https://codecov.io/gh/riiraty/belligerent-bludger). 

[![codecov](https://codecov.io/gh/riiraty/belligerent-bludger/branch/master/graph/badge.svg)](https://codecov.io/gh/riiraty/belligerent-bludger)

## Integration testing

Integration testing has been done manually through the CLI. 

## Performance testing

The program has a command <code>test</code> that allows the user to specify how many rounds the <code>Tester</code> runs. The results are given as milliseconds.

The <code>Tester</code> generates the given amount of keys and calculates an average time for creating a single <code>KeyPair</code>.

The <code>Tester</code> creates a <code>String[]</code> of given input size where each element is a random <code>String</code> of length 64 consisting of the allowed characters (a-zA-Z0-9!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~).
The encryption is tested by encrypting these elements and calculating an average time for single encryption. The resulting ciphers are stored in a <code>String[]</code> and used to test the decryption in a similar way.

The total time spent initializing and running the <code>Tester</code> is displayed at the end.

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/test-10.png "example with 10 rounds")

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/test-1000.png "example with 1000 rounds")

![alt text](https://github.com/riiraty/belligerent-bludger/blob/master/documentation/pics/test-100000.png "example with 100000 rounds")
