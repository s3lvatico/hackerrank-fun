package org.gmnz.ipk;

import java.util.Scanner;

public class ArrayManipulation {

   /*
    * L'operazione consiste nel sommare il valore k ad ogni elemento dell'array in
    * posizione in [a, b] (estremi inclusi).
    * 
    * Il trucco è: invece di fare le somme all'interno dell'intervallo, conviene
    * registrare le variazioni. Ossia: in corrispondenza dell'indice "a" si avrà
    * una variazione +k, e in corrispondenza dell'indice "b+1" si avrà una
    * variazione -k. La variazione in sottrazione avviente in b+1 e non in b perché
    * l'operazione si considera includendo gli estremi.
    * 
    * Il problema chieda di determinare il massimo tra gli elementi dell'array dopo
    * che tutte le operazioni sono state eseguite. Se si applica la strategia
    * descritta sopra, poiché l'array inizialmente era composto di soli zeri, si
    * trova che la somma di tutti i suoi elementi sarà comunque zero, ma questa
    * somma avrà certamente un massimo assoluto non negativo all'interno dell'array
    * (k è per ipotesi non negativo)
    */

   private static void op(int[] arr, int startIdx, int endIdx, int k) {
      arr[startIdx - 1] += k;
      if (endIdx < arr.length) {
         arr[endIdx] -= k;
      }
   }

   public static void main(String[] args) {
      System.out.printf(">>> %s.main()", ArrayManipulation.class.getName());

      Scanner s = new Scanner(System.in);

      int n = s.nextInt();
      System.out.println("n : " + n);

      int m = s.nextInt();
      System.out.println("m : " + m);

      int[] arr = new int[n];

      for (int i = 1; i <= m; i++) {
         int a = s.nextInt();
         int b = s.nextInt();
         int k = s.nextInt();
         System.out.format("i=%d || (a, b) = (%d, %d) | k = %d%n", i, a, b, k);
         op(arr, a, b, k);
      }

      s.close();

      int max = 0;
      int sum = 0;
      for (int a : arr) {
         sum += a;
         if (sum > max) {
            max = sum;
         }
      }

      System.out.println(max);

      System.out.printf("<<< %s.main()", ArrayManipulation.class.getName());
   }
}