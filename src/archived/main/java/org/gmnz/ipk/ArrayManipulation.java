package org.gmnz.ipk;

import java.util.Scanner;

public class ArrayManipulation {

   private static void op(int[] arr, int startIdx, int endIdx, int k) {

   }

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      int n = s.nextInt();
      int m = s.nextInt();

      int [] arr = new int[n];

      for (int i = 1; i <= m; i++) {
         int a = s.nextInt();
         int b = s.nextInt();
         int k = s.nextInt();
         System.out.printf("(a, b) = (%d, %d) | k = %d%n", a, b, k);
         op(arr, a, b, k);
      }

      s.close();

      // TODO max{arr[i]}

   }
}