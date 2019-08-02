package org.gmnz.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

    private Map<Integer, Long> fMap = new HashMap<>();

    {
        fMap.put(0, 1L);
        fMap.put(1, 1L);
    }

    public long of(int n) {
        if (!fMap.containsKey(n)) {
            fMap.put(n, n * of(n - 1));
        }
        return fMap.get(n);
    }

}