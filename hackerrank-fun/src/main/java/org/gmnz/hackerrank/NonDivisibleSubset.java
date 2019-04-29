package org.gmnz.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * NonDivisibleSubset
 */
public class NonDivisibleSubset {

    static class Factorial {

        private Map<Integer, Long> fMap = new HashMap<>();

        {
            fMap.put(0, 1L);
            fMap.put(1, 1L);
        }

        long of(int n) {
            if (!fMap.containsKey(n)) {
                fMap.put(n, n * of(n - 1));
            }
            return fMap.get(n);
        }

    }

    static class Combinatorics {

        long dispositions(int n, int k) {
            Factorial fact = new Factorial();
            return fact.of(n) / fact.of(n - k);
        }

        long combinations(int n, int k) {
            Factorial fact = new Factorial();
            long dispositions = dispositions(n, k);
            return dispositions / fact.of(k);
        }
    }

    /*
    
    
    */
    int nonDivisibleSubset(int k, int[] S) {
        int n = S.length;
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, Boolean.TRUE);

        /* doppio ciclo for per generare tutte le combinazioni */
        for (int i = 0; i < n - 1; i++) {
            int sum;
            for (int j = i + 1; j < n; j++) {
                if (sieve[i] && sieve[j]) {
                    sum = S[i] + S[j];
                    sieve[j] = (sum % k) != 0;                    
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sieve[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonDivisibleSubset nds = new NonDivisibleSubset();
        int rank = nds.nonDivisibleSubset(3, new int[] { 1, 7, 2, 4 });
        System.out.println(rank);
    }
}