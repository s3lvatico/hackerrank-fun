package org.gmnz.hackerrank;

import java.util.Arrays;

/**
 * PrimeNumbers
 */
public class PrimeNumbers {

    int[] findPrimes(int upperBound) {
        boolean[] sieve = new boolean[upperBound + 1];
        Arrays.fill(sieve, true);
        for (int i = 2; i < sieve.length / 2; i++) {
            if (!sieve[i]) {
                continue;
            }
            for (int n = i; n <= upperBound; n += i) {
                if (n == i)
                    continue;
                sieve[n] = false;
            }
        }
        // già a questo punto sieve[] contiene un true nell'indice che corrisponde a un
        // numero primo (eccezion fatta per gli indici 0 e 1 che in questo contesto non
        // hanno significato)
        int primeCount = 0;
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                primeCount++;
            }
        }

        int[] primeNumbers = new int[primeCount];
        int pidx = 0;
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                primeNumbers[pidx] = i;
                pidx++;
            }
        }

        return primeNumbers;
    }

    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();
        int[] primeNumbers = pn.findPrimes(100);
        Utils.printArray(primeNumbers);
    }

}