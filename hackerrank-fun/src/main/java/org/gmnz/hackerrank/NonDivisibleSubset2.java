package org.gmnz.hackerrank;

/**
 * NonDivisibleSubset
 * 
 * Può voler dire studiare la struttura algebrica (N/k, +).
 * 
 * 
 */
public class NonDivisibleSubset2 {

    static int nonDivisibleSubset(int k, int[] S) {
        /*
         * trovo la distribuzione dell'array iniziale S. Definisco l'array distr tale
         * che distr[i] indica quanti elementi di S sono modulo k
         */

        int[] distr = new int[k];
        for (int s : S) {
            distr[s % k]++;
        }
        Utils.printArray(distr);

        /*
         * Ora devo studiare l'insieme dei non-divisori. Trovare un insieme di
         * cardinalità massima composto da elementi tali che la loro somma non è
         * divisibile per k. Questo equivale a dire che la somma di due elmenti
         * qualsiasi di S non si trova in classe [0]
         */

        /*
         * ora va costruito l'insieme e determinata la sua cardinalità. data la regola
         * per la quale [r] + [s] = [r+s], comincio a domandarmi: l'insieme che cerco
         * può contenere elementi di classe [0]? Al più uno. Se per assurdo ne
         * contenesse due, la loro somma sarebbe ancora in [0] e violerebbe la regola.
         */
        int maxSubsetSize = distr[0] == 0 ? 0 : 1;
        /*
         * per determinare la cardinalità massima continuo a chiedermi se elementi delle
         * altre classi possono stare nell'insieme che cerco. Le classi sono esattamente
         * k, cioè [0], [1], [2], ..., [k-1]. Se prendo elementi di [1] allora non posso
         * prendere elementi di [k-1], perché la loro somma sta in [0]. Inoltre, se
         * [k/2] è non vuoto, si deve prendere al più un solo elemento anche da [k/2];
         * se, anche qui per assurdo, se ne prendessero due, la loro somma starebbe in
         * [0].
         * 
         */
        for (int i = 1; i < k / 2; i++) {
            maxSubsetSize += Math.max(distr[i], distr[k - i]);
        }
        if (k % 2 == 0) {
            maxSubsetSize += 1;
        } else {
            maxSubsetSize += Math.max(distr[k / 2], distr[k - k / 2]);
        }
        return maxSubsetSize;
    }

    public static void main(String[] args) {

        // test case -1
        // int[] S = new int[] { 19, 10, 12, 10, 24, 25, 22 };
        // int k = 4;

        // test case 0 (exp 3)
        // int[] S = new int[] { 1, 7, 2, 4 };
        // int k = 4;

        // test case 1 (exp 5)
        // int[] S = new int[] { 2, 7, 12, 17, 22 };
        // int k = 5;

        // test case 16 (exp 11)
        // int[] S = new int[] { 278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282,
        // 718, 771, 575, 436 };
        // int k = 7;

        // test case 7 (exp 5)
        int[] S = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 4;

        System.out.format("S = %s%n", Utils.toString(S));
        System.out.format("k = %d%n%n", k);
        int rank = NonDivisibleSubset2.nonDivisibleSubset(k, S);

        System.out.println(rank);

    }
}