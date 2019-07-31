package org.gmnz.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Birthday
 */
public class Birthday {

   static int birthday(List<Integer> s, int d, int m) {
      Integer[] v = s.toArray(new Integer[] {});
      int goodDivisions = 0;
      int ms = 0;
      for (int i = 0; i < m; i++) {
         ms += v[i];
      }
      if (ms == d) {
         goodDivisions++;
      }
      for (int i = 1; i + m <= v.length; i++) {
         ms -= v[i - 1];
         ms += v[i + m - 1];
         if (ms == d) {
            goodDivisions++;
         }
      }
      return goodDivisions;
   }

   public static void main(String[] args) {
      List<Integer> s = Arrays.asList(3, 5, 4, 1, 2, 5, 3, 4, 3, 2, 1, 1, 2, 4, 2, 3, 4, 5, 3, 1, 2, 5, 4, 5, 4, 1, 1,
            5, 3, 1, 4, 5, 2, 3, 2, 5, 2, 5, 2, 2, 1, 5, 3, 2, 5, 1, 2, 4, 3, 1, 5, 1, 3, 3, 5);
      int d = 18;
      int m = 6;
      int z = Birthday.birthday(s, d, m);
      System.out.println(z);
   }

}