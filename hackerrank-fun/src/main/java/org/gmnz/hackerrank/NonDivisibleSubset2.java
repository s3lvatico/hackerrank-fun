package org.gmnz.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * NonDivisibleSubset
 */
public class NonDivisibleSubset2 {

    static class Nds {

        private final int k;
        private final Set<Integer> _set;

        Nds(int k) {
            this.k = k;
            _set = new HashSet<>();
        }

        boolean canBeAdded(int n) {
            if (_set.size() == 0) {
                return true;
            } else {
                int sum;
                for (int s : _set) {
                    sum = s + n;
                    if (sum % k == 0) {
                        return false;
                    }
                }
                return true;
            }
        }

        int getSize() {
            return _set.size();
        }

        void add(int n) {
            _set.add(n);
        }
    }

    static int nonDivisibleSubset(int k, int[] s) {
        int maxCardinality = 0;
        int l = s.length;

        for (int i = 0; i < l; i++) {
            Nds nds = buildNds(s, i, k);
            maxCardinality = Math.max(maxCardinality, nds.getSize());
        }
        return maxCardinality;
    }

    private static Nds buildNds(int[] s, int idx, int k) {
        Nds nds = new Nds(k);
        nds.add(s[idx]);

        int j = 0;
        while (j < s.length) {
            if (j != idx && nds.canBeAdded(s[j])) {
                nds.add(s[j]);
            }
            j++;
        }
        return nds;
    }

    public static void main(String[] args) {
        // NonDivisibleSubset nds = new NonDivisibleSubset();
        // int rank = nds.nonDivisibleSubset(3, new int[] { 1, 7, 2, 4 });
        // int rank = nds.f2(new int[] { 278, 576, 496, 727, 410, 124, 338, 149, 209,
        // 702, 282, 718, 771, 575, 436 }, 7);
        int rank = NonDivisibleSubset2.nonDivisibleSubset(7,
                new int[] { 278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436 });
        System.out.println(rank);

    }
}