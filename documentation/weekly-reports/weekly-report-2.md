## Week 2

#### Progress

Project configurations are done: Checkstyle is in use and has some basic checks. I also configured CircleCi and Codecov to monitor the project. Jacoco is configured to exlude Main and ui. 

I did more research on the required data structures and algorithms and tried to come up with the time complexity estimates. The [Requirements document]((https://github.com/riiraty/belligerent-bludger/blob/master/documentation/requirements-document.md)) is updated. Also looked into character encoding standards and planned options for storing the keys.

A lot of time was spent on designin the structure and naming of the packages and the classes. I had some trouble trying to figure out the big picture, and eventually started to actually write the code to get a grasp.

Simple implementation of the crypter is done with java.math.BigInteger. I also started working on the keygenerator. 

I have done some manual testing with the CLI. 

#### Problems

Converting plain text to numbers and back is done with char values. The encryption might convert the chararcter into an unprintable one, which results the user not being able to read the string or copy it to decrypt it. I was looking into this (base64 mainly), but I'm not sure what would be the best way to go around this. 

I don't have the unit tests for the implemented code. I didn't finish the keygenerator, and can't really manually make valid and big enough keys. I had a working keypair for manual testing, but it had a modulus too small to correctly encrypt and then decrypt back anything, I had done the math by hand to see if it works. 

I'm planning to add style checks for the javadoc comments, but is there something else missing from the checkstyle configuration?

#### Work hours record

Date | Time (h) | Progress
-----|----------|----------
19.5.| 5 | Configurations and badges to README
20.5.| 5 | Research and design, simple CLI implementation
21.5.| 6,5 | Starting on javadoc, doing maths on paper, research, implementing crypter
22.5.| 7 | Research, starting on keygen implementation, updating documentation
Total:| 23,5