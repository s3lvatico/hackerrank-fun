package org.gmnz.hackerrank;

/**
 * Combinatorics
 */
public class Combinatorics {

    public long dispositions(int n, int k) {
        Factorial fact = new Factorial();
        return fact.of(n) / fact.of(n - k);
    }

    public long combinations(int n, int k) {
        Factorial fact = new Factorial();
        long dispositions = dispositions(n, k);
        return dispositions / fact.of(k);
    }
}