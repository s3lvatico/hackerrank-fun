package org.gmnz.hackerrank;

/**
 * NewYearChaos
 */
public class NewYearChaos {

    static int minimumBribes(int[] q) {

        int l = q.length;

        // creazione array dei minimi dinamici
        // per iniziare prendo gli ultimi tre elementi della coda
        int[] pivots = new int[] { q[l - 1], q[l - 2], q[l - 3] };

        // invece di ordinare l'array tengo traccia degli indici dove si trovano il
        // minimo e il massimo: automaticamente conoscerò anche l'indice del minimo di
        // mezzo.

        // indice del maggiore tra i minimi incontrati finora
        int hi = 0;
        // indice del minore tra i minimi incontrati finora
        int lo = 0;
        {
            // valore minimo corrente
            int pMin = pivots[0];
            // valore massimo corrente
            int pMax = pivots[0];
            for (int i = 0; i < 3; i++) {
                // scorrendo l'array dei minimi
                if (pivots[i] < pMin) {
                    // aggiornamento minimo più piccolo
                    pMin = pivots[i];
                    // e relativo indice
                    lo = i;
                }
                if (pivots[i] > pMax) {
                    // aggiornamento del minimo più grande
                    pMax = pivots[i];
                    // e relativo indice
                    hi = i;
                }
            }
        }
        // ricavo l'indice del minimo "di mezzo"
        int mid = 3 - (lo + hi);

        // numero di corruzioni
        int b = 0;

        // il passo iniziale non prevede l'aggiornamento dell'array dei minimi, dovendo
        // controllare solo il penultimo e il terzultimo elemento

        for (int i = l - 3; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (q[i] > q[j]) {
                    b++;
                }
            }
        }

        // a partire dal quartultimo elemento devo anche aggiornare eventualmente
        // l'array dei minimi
        for (int i = l - 4; i >= 0; i--) {
            int x = q[i];
            int jumps = 0;
            // dedurre se è nella posizione giusta
            if (x > i + 1) {
                // controllo solo se è maggiore dell'elemento che dovrebbe occupare quella
                // posizione. Se trovassi un numero minore di quello che dovrebbe esserci vuol
                // dire che qualcuno più avanti ha spinto il numero corrente nella posizione
                // attuale. Ricorda che devi trovare la causa, non l'effetto.

                // Essendo maggiore di ciò che dovrei trovare vuol dire che ha scavalcato.
                // Quanti posti ha scavalcato? Dipende dal numero di elementi minimi trovati
                // finora rispetto ai quali il numero corrente è maggiore
                if (x > pivots[lo]) {
                    jumps++;
                    if (x > pivots[mid]) {
                        jumps++;
                        if (x > pivots[hi]) {
                            // ha "saltato" troppo, quindi coda troppo caotica, e ritorno
                            System.out.println("Too chaotic");
                            return -2;
                        }
                    }
                }
                b += jumps;
            }

            // a prescindere dall'eventuale numero di salti conteggiati va comunque
            // aggiornato l'array dei minimi

            if (pivots[mid] < x && x < pivots[hi]) {
                // --- lo --- mid --- hi
                // ----------------x
                // se x è qui, scarto il minimo più grande
                pivots[hi] = x;
            } else if (pivots[lo] < x && x < pivots[mid]) {
                // --- lo --- mid --- hi
                // --------x
                // se si trova qui il nuovo array dei minimi è |lo|x|mid|
                pivots[hi] = pivots[mid];
                pivots[mid] = x;
            } else if (x < pivots[lo]) {
                // --- lo --- mid --- hi
                // -x
                // se si trova qui il nuovo array dei minimi è |x|lo|mid|
                pivots[hi] = pivots[mid];
                pivots[mid] = pivots[lo];
                pivots[lo] = x;
            }
        }

        return b;
    }

}