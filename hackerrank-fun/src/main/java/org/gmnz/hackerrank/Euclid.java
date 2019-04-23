package org.gmnz.hackerrank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * L'algoritmo euclideo.
 * <p>
 * Vedi anche https://en.wikipedia.org/wiki/Euclidean_algorithm
 */
public class Euclid {

	private static final Logger logger = LogManager.getLogger(Euclid.class);

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
	 * Ad ogni passaggio ciò che occorre davvero determinare è il resto r_k. Risulta
	 * r_k = a mod b. E questa è la parte semplice. Nel passaggio tra un passo e il
	 * successivo puoi vedere che i resti - o, meglio ancora, dalla condizione
	 * iniziale, i numeri a, b, r_0 - "scorrono" a sinistra. "a" diventa ciò che
	 * prima era "b". "b" diventa ciò che prima era il resto trovato con
	 * l'operazione di modulo.
	 * <p>
	 * I passaggi, quindi, diventano: memorizza temporaneamente b, aggiorna b,
	 * aggiorna a con il valore memorizzato.
	 */
	static long gcd(long a, long b) {
		if (a < b) {
			logger.debug("reinvocazione con valori nell'ordine giusto");
			return gcd(b, a);
		}
		logger.info("mcd(%d, %d)", a, b);
		while (b > 0) {
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	/**
	 * Calcolo del MCD di un insieme di interi positivi.
	 * 
	 * @param input array di interi positivi
	 * @return
	 */
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