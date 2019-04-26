package org.gmnz.hackerrank;

import java.util.Arrays;

/**
 * Scomposizione di un numero in fattori primi
 */
public class Decomposition {
    @SuppressWarnings("deprecation")
    void decompose(int n) {
        System.out.println("scompongo: " + n);
        int[] primeNumbers = new PrimeNumbers().findPrimes(n);

        int[] exponents = new int[primeNumbers.length];
        Arrays.fill(exponents, 0);

        // debug
        // Utils.printArray(primeNumbers);

        for (int i = 0; i < primeNumbers.length; i++) {
            int dd = n;
            while (dd % primeNumbers[i] == 0) {
                ++exponents[i];
                dd /= primeNumbers[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exponents.length; i++) {
            if (exponents[i] != 0) {
                if (sb.length() != 0) {
                    sb.append(" * ");
                }
                sb.append(primeNumbers[i]);
                if (exponents[i] > 1) {
                    sb.append("^" + exponents[i]);
                }
            }
        }
        System.out.println(n + " = " + sb.toString());

    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0) {
            n = 132300;
        } else {
            n = Integer.parseInt(args[0]);
        }
        Decomposition d = new Decomposition();
        d.decompose(n);
    }

}