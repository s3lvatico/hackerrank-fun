package org.gmnz.ipk;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayManipulation {

   private static final Logger log = LogManager.getLogger();

   private static void op(int[] arr, int startIdx, int endIdx, int k) {

   }

   public static void main(String[] args) {

      System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
      log.info("le main!");

      Scanner s = new Scanner(System.in);

      int n = s.nextInt();
      log.info("n : " + n);
      System.out.println("n : " + n);

      int m = s.nextInt();
      log.info("m : " + m);
      System.out.println("m : " + m);

      int[] arr = new int[n];

      System.out.println("bububug");

      for (int i = 1; i <= m; i++) {
         int a = s.nextInt();
         int b = s.nextInt();
         int k = s.nextInt();
         log.info("(a, b) = ({}, {}) | k = {}", a, b, k);
         System.out.println("i = " + i);
         op(arr, a, b, k);
      }

      s.close();

      // TODO max{arr[i]}

   }
}