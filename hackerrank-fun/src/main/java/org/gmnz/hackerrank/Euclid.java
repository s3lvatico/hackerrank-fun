package org.gmnz.hackerrank;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * L'algoritmo euclideo.
 * <p>
 * Vedi anche https://en.wikipedia.org/wiki/Euclidean_algorithm
 */
public class Euclid {

	private static final Logger logger = LogManager.getLogger("HelloWorld");



	/**
	 * Massimo comune divisore.
	 * <p>
	 * L'algoritmo prosegue finché <code>r_k > 0</code>
	 * <p>
	 * <code>r_(k-2) = q_k * r_(k-1) + r_k</code>
	 * <p>
	 * E per <code>k = 0</code> si pone <code>r_(k-2) = a</code> e
	 * <code>r_(k-1) = b</code>
	 * <p>
	 * Ad ogni passaggio ciò che occorre davvero determinare è il resto r_k
	 */
	static long gcd(long a, long b) {
		if (a < b) {
			return gcd(b, a);
		}
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