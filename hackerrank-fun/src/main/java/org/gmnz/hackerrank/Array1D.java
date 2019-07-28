package org.gmnz.hackerrank;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Array1D {

   private static boolean[] visited;

   public static boolean canWin(int leap, int[] game) {
      int n = game.length;
      visited = new boolean[n];
      Arrays.fill(visited, false);
      if (leap >= n - 1)
         return true;
      return canWin(game, n, leap, 1) || canWin(game, n, leap, leap);

   }

   private static boolean canWin(int[] game, int n, int leap, int pos) {
      if (pos >= n)
         return true;
      if (pos < 0 || visited[pos] || game[pos] == 1)
         return false;
      visited[pos] = true;

      return canWin(game, n, leap, pos + leap) || canWin(game, n, leap, pos + 1) || canWin(game, n, leap, pos - 1);
   }

   public static void main(String[] args) throws Exception {

      InputStream inStream;
      if (args.length == 0) {
         inStream = System.in;
      } else {
         String inputResource = "/" + args[0];
         inStream = Array1D.class.getResourceAsStream(inputResource);
      }
      Scanner scan = new Scanner(inStream);
      int q = scan.nextInt();
      while (q-- > 0) {
         int n = scan.nextInt();
         int leap = scan.nextInt();

         int[] game = new int[n];
         for (int i = 0; i < n; i++) {
            game[i] = scan.nextInt();
         }

         System.out.println((canWin(leap, game)) ? "YES" : "NO");
      }
      scan.close();
   }

}