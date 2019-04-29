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

    private void f1(int[] s, boolean[] cflags, int startIndex, int k) {
        if (!cflags[startIndex])
            return;
        int i = 0;
        boolean allSumsDividable = true;
        while (i < s.length) {
            if (i != startIndex) {
                int sum = s[startIndex] + s[i];
                boolean sumDividable = sum % k == 0;
                cflags[i] = !sumDividable;
                allSumsDividable &= sumDividable;
            }
            i++;
        }

        cflags[startIndex] = !allSumsDividable;

        /*
         * a questo punto l'array cflags vale true solo negli indici per i quali il
         * corrispondente valore su S ha somma con S[startIndex] non divisibile per k
         */
    }

    private int f2(int[] s, int k) {
        /**
         * ad ogni giro devi reimpostare l'array delle flag e dopo una chiamata a f1
         * devi controllare quante flag sono rimaste alzate. Quel numero dovrebbe
         * corrispondere alla cardinalità dell'insieme dei non-divisori.
         * 
         * trova poi la massima cardinalità, iniziando ogni volta da un elemento diverso
         * dell'array di partenza
         */

        /**
         * richiama f1() iniziando dal suo primo elemento, poi, dal secondo... infine
         * dall'n-esimo: a fine procedimento conta quanti true sono rimasti nelle cflags
         */

        int maximalCardinality = 0;
        for (int startIndex = 0; startIndex < s.length; startIndex++) {
            boolean[] cflags = new boolean[s.length];
            Arrays.fill(cflags, true);
            f1(s, cflags, startIndex, k);
            int cardinality = 0;
            for (boolean b : cflags) {
                if (b)
                    ++cardinality;
            }
            maximalCardinality = Math.max(maximalCardinality, cardinality);
            if (maximalCardinality == 1) {
                maximalCardinality = 0;
            }
        }
        return maximalCardinality;

    }

    public static void main(String[] args) {
        NonDivisibleSubset nds = new NonDivisibleSubset();
        // int rank = nds.nonDivisibleSubset(3, new int[] { 1, 7, 2, 4 });
        int rank = nds.f2(new int[] { 278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436 }, 7);
        System.out.println(rank);

    }
}