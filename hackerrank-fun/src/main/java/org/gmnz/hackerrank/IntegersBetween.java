package org.gmnz.hackerrank;

public class IntegersBetween {

    /*
     * gli interi di mezzo tra due insiemi sono quelli per i quali:
     * 
     * dati due insiemi di interi positivi ogni elemento del primo insieme divide
     * l'intero di mezzo l'intero di mezzo divide ogni elemento del secondo insieme
     */

    /*
     * 
     * [ 2 4 ] [ 16 32 96]
     * 
     * 2^1, 2^2 2^4, 2^5, 2^5 * 3
     * 
     * lui inizia a risolvere dicendo che i numeri candidati per l'insieme di mezzo
     * potrebbero essere 4, 8, 12 e 16. E da questi, teoricamente, si può facilmente
     * determinare quali sono divisori di ogni elemento del secondo insieme. Da come
     * sono stati elencati verrebbe da pensare che l'algoritmo usato per ipotizzarli
     * consista nel determinare il mcm degli elementi del primo insieme e includere
     * questo e tutti i suoi multipli nell'insieme dei candidati, finché ci si
     * mantiene non maggiori del primo elemento del secondo insieme.
     * 
     */

    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        // TODO da finire!
        return -1;
    }

    public static void main(String[] args) {

    }
}