## Week 6

#### Progress

I refactored the keys to remove copy paste code. There is now a feature for user input keys. For this I made the keys printable and added a constructor which creates a key from that print. <code>Base64</code> scheme was used for this, so I refactored the encoding and decoding methods from <code>Crypter</code> to a separate class. 

The default <code>KeyPair</code> is now of 1024 bit size, which means 128 characters max input, as input is handled as single <code>String</code> and not blocks. User guide was updated to match the current state of the program. The unit tests were added and updated accordingly. 

The CLI was improved to handle exceptions with invalid input and updated for the new key input feature. The UI code was split to command methods.


#### Problems

I did not have enough time this week to progress my <code>BigInt</code>, still having same problems.

The documentation needs work before the final deadline. I suspect there will be trouble with figuring out time complexities again.

The performance testing needs more work also.

#### Work hours record

Date | Time (h) | Progress
-----|----------|----------
17.6.| 5,5 | Refactoring code, adding key input feature, improving CLI and refactoring UI code, updating to bigger default key, fixing broken tests and checkstyle violations, updating user guide, manual testing
18.6.| 4,5 | Maintainging codecoverage, Checkstyle config, research, catching exceptions from invalid input, updating user guide
Total: | 10