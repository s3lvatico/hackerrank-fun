package org.gmnz.ipk;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation2 {

   private static void printArray(int[] arr) {
      for (int x : arr) {
         System.out.printf("%d ", x);
      }
      System.out.println();
   }

   // Complete the arrayManipulation function below.
   static long arrayManipulation(int n, int[][] queries) {
      long[] arr = new long[n];

      for (int qi = 0; qi < queries.length; qi++) {
         int[] query = queries[qi];

         System.out.print("query : ");
         printArray(query);

         int startIdx = query[0] - 1;

         // System.out.println(startIdx);

         int endIdx = query[1];

         // System.out.println(startIdx);

         int k = query[2];

         // System.out.println(k);

         arr[startIdx] += k;
         if (endIdx < arr.length) {
            arr[endIdx] -= k;
         }
      }

      long max = 0;
      long sum = 0;
      for (long a : arr) {
         sum += a;
         if (sum > max) {
            max = sum;
         }
      }

      System.out.println("max value after all queries : " + max);

      return max;
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {

      String outFile = System.getenv("OUTPUT_PATH");
      // System.out.println("output file : " + outFile);

      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile));

      String[] nm = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nm[0]);

      // System.out.println("n = " + n);

      int m = Integer.parseInt(nm[1]);

      // System.out.println("m = " + m);

      int[][] queries = new int[m][3];

      for (int i = 0; i < m; i++) {
         String[] queriesRowItems = scanner.nextLine().split(" ");
         scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

         for (int j = 0; j < 3; j++) {
            int queriesItem = Integer.parseInt(queriesRowItems[j]);
            queries[i][j] = queriesItem;
            // System.out.printf("queries[%d][%d] = %d%n", i, j, queriesItem);
         }
      }

      long result = arrayManipulation(n, queries);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
   }
}