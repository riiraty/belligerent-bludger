## Final week

#### Progress

I found a major bug in <code>KeyPairGenerator</code>, a line has been missing since the beginning from <code>generateE()</code>. It did not actually cause problems, since I had a default value as backup, but it is much faster now that it doesn't loop for fun...

More unit tests were added, especially to <code>KeyPairGenerator</code>. Now it is tested that the methods produce desired values.

Major part of working hours was spent on the documentation this week.

The program now works in a way that was intented, and the UI is finished.

#### Problems

I finally figured out how to implement the BigInt but didn't have time to actually write it.

There was a plan to just implement a prime generator instead, but that didn't get done either. 

#### Work hours record

Date | Time (h) | Progress
-----|----------|----------
23.6.| 4 | Researching BigInteger, peer review 2, improving UI, discussing with the instructor in Zoom
24.6.| 5 | Demo, more unit tests, major bug fix in keygen
25.6.| 5,5 | More unit tests, working on performance testing
27.6.| 6,5 | Working on documentation and missing javadocs, doing manual testing
Total: | 21
