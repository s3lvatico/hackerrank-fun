package org.gmnz.hackerrank;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Array1D {

   private int[] game;

   private int leap;
   private int n;
   private boolean[] visited;

   Array1D(int[] arr, int leap) {
      game = arr;
      visited = new boolean[game.length];
      Arrays.fill(visited, false);
      n = game.length;
      this.leap = leap;
   }

   public boolean canWin() {
      return canWin(0);
   }

   private boolean canWin(int pos) {
      if (pos >= n)
         return true;
      if (pos < 0 || visited[pos] || game[pos] == 1)
         return false;
      visited[pos] = true;

      return canWin(pos + leap) || canWin(pos + 1) || canWin(pos - 1);
   }

   public static void main(String[] args) throws Exception {
      Scanner s = new Scanner(Array1D.class.getResourceAsStream("/array1dpt2-testcase-3.txt"));

      int queries = s.nextInt();
      s.skip(s.delimiter());

      URL u0 = Array1D.class.getResource("/array1dpt2-testcase-3.txt");

      String targetPath = u0.getPath();
      StringBuilder sb = new StringBuilder(targetPath.substring(0, targetPath.lastIndexOf("/") + 1));
      sb.append("array1dpt2-testcase-3-results-").append(System.currentTimeMillis()).append(".txt");

      PrintWriter pw = new PrintWriter(new File(sb.toString()));

      for (int i = 0; i < queries; i++) {
         int gameSize = s.nextInt();
         // System.out.println("gamesize : " + gameSize);

         int leap = s.nextInt();
         // System.out.println("leap : " + leap);

         int[] game = new int[gameSize];
         // System.out.println("game array initialized");

         for (int j = 0; j < gameSize; j++) {
            game[j] = s.nextInt();
         }
         // System.out.println("game array completed:");
         // for (int j = 0; j < gameSize; j++) {
         // System.out.print(game[j] + " ");
         // }
         // System.out.println("\n");

         String canWin = new Array1D(game, leap).canWin() ? "YES" : "NO";
         System.out.println(canWin);
         pw.println(canWin);
      }

      pw.close();
      s.close();
   }

}