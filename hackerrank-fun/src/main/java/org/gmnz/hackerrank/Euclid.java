package org.gmnz.hackerrank;

/**
 * L'algoritmo euclideo.
 * <p>
 * Vedi anche https://en.wikipedia.org/wiki/Euclidean_algorithm
 */
public class Euclid {

    static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    static long gcd(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++)
            result = gcd(result, input[i]);
        return result;
    }

    /**
     * 
     * https://en.wikipedia.org/wiki/Least_common_multiple#Reduction_by_the_greatest_common_divisor
     */
    static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++)
            result = lcm(result, input[i]);
        return result;
    }

}