package org.gmnz.hackerrank;

/**
 * NewYearChaos
 */
public class NewYearChaos {

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    static int minimumBribes(int[] q) {

        /*
         * la coda, in condizioni iniziali, è ordinata.
         * 
         * Cioè, ogni elemento è strettamente minore del successivo.
         * 
         * Il massimo è in fondo alla coda, il minimo è in cima.
         * 
         * Detto l = q.length ==> max = q[l-1] et min=q[0];
         * 
         * Ogni elemento può scambiare posto solo con quello immediatamente precedente.
         * Ogni elemento può scambiare posto non più di 2 volte.
         * 
         * ==> il minimo non può mai scambiare posto
         * 
         * ==> il massimo può trovarsi al più al posto l-3 (se ha scambiato due volte
         * partendo dalla posizione l-1).
         * 
         * Il "movimento" verso dx di un elemento è un effetto; la causa è, dalla
         * regola, il movimento verso sx di un altro elemento. Chi sono gli elementi che
         * si possono muovere? Tutti tranne q[0]. Cioè a cominciare dal massimo valore
         * (che si trova in q[l-1] fino a q[1]).
         * 
         * ==> dovrei guardare la coda dalla sua fine, dal suo punto più lontano,
         * dall'indice massimo.
         * 
         * Indice massimo... se porta un valore pari all'indice ==> non c'è stato
         * scambio. Se porta un valore minore vuol dire che qualcuno ce l'ha "spinto" a
         * causa di uno scambio. Chi è quel qualcuno? non posso saperlo a priori perché
         * può essere più di uno. Resta solo la possibilità che se ad un certo indice
         * c'è un valore maggiore di quello che dovrebbe esserci, quel valore è lì
         * perché ha eseguito almeno uno scambio
         * 
         * MA PIU' IMPORTANTE ANCORA... il fatto che ci sia un valore maggiore di quel
         * che mi aspetto indica che dietro quel valore, verso indici crescenti, ci sono
         * valori MINORI (STRETTAMENTE minori!)
         * 
         * [1 2 5 3 7 8 6 4]
         */

        int l = q.length;
        int[] pivots = new int[] { q[l - 1], q[l - 2], q[l - 3] };

        int hi = 0;
        int lo = 0;

        {
            int tMin = pivots[0];
            int tMax = pivots[0];
            for (int i = 0; i < 3; i++) {
                if (pivots[i] < tMin) {
                    tMin = pivots[i];
                    lo = i;
                }
                if (pivots[i] > tMax) {
                    tMax = pivots[i];
                    hi = i;
                }
            }
        }

        int mid = 3 - (lo + hi);
        // 1 2 3 5 4 6 7 8
        int b = 0;
        for (int i = l - 1; i >= 0; i--) {
            int x = q[i];
            if (x != i + 1) {
                // x non è dove dovrebbe essere. Cerchiamo di capire se è un corruttore o se è
                // stato corrotto.
                int jumps = 0;
                if (x > pivots[hi]) {
                    jumps++;
                }
                if (x > pivots[mid]) {
                    jumps++;
                }
                if (x > pivots[lo]) {
                    jumps++;
                }

                if (jumps > 2) {
                    System.out.println("Too chaotic");
                    return -2;
                } else {
                    b += jumps;
                }
            }

            if (pivots[mid] < x && x < pivots[hi]) {
                pivots[hi] = x;
            } else if (pivots[lo] < x && x < pivots[mid]) {
                // lo mid hi
                // --x--
                pivots[hi] = pivots[mid];
                pivots[mid] = x;
            } else if (x < pivots[lo]) {
                // x lo mid hi
                pivots[hi] = pivots[mid];
                pivots[mid] = pivots[lo];
                pivots[lo] = x;
            }

        }

        return b;
    }

}