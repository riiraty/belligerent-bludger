## Week 5

#### Progress

I worked on my own <code>BigInt</code> and made unit tests for it. Fixed occurring bugs. I can't really find much else than the [source code](http://hg.openjdk.java.net/jdk/jdk11/file/tip/src/java.base/share/classes/java/math/BigInteger.java) to work with.

Some time was also spent on getting started with performance testing. 

#### Problems

I'm having a difficult time with <code>BigInteger</code> and bit manipulations etc. Right now I'm storing one digit at a time, which seems wasteful. And my RSA crypter does <code>String</code> <--> <code>BigInteger</code> conversions through <code>byte[]</code> but I don't know how to implement the needed constructor and conversion method. 

#### Work hours record

Date | Time (h) | Progress
-----|----------|----------
9.6.| 5 | Researching and implementing BigInt
11.6.| 3 | Peer review 1
12.6.| 4 | Preliminary performance testing, implementing BigInt and writing unit tests
Total: | 12 