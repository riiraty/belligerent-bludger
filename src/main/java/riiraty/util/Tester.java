package riiraty.util;

import riiraty.keys.KeyPairGenerator;

public class Tester {
    private long[] times = new long[10];

    public void run() {
        long t;
        for (int i = 0; i < 10; i++) {
            t = System.nanoTime();
            new KeyPairGenerator();
            t = System.nanoTime() - t;
            times[i] = t;
        }
    }

    private double getAverage(long[] times) {
        double total = 0;
        for (long time : times) {
            total += time;
        }
        return total / 10.0;
    }

    @Override
    public String toString() {
        return "Average for generating a KeyPair: " + getAverage(times) / 1000000.0 + " ms";
    }

}
