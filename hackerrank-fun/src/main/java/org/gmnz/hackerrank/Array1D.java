package org.gmnz.hackerrank;

import java.util.Arrays;

public class Array1D {

   private int[] game;
   private int pos = 0;
   private int leap;
   private int n;
   private boolean[] visited;

   Array1D(int[] arr, int leap) {
      game = arr;
      visited = new boolean[game.length];
      Arrays.fill(visited, false);
      n = game.length;
      this.leap = leap;
      System.out.println("can win? " + canWin(pos));
   }

   private boolean canWin(int pos) {
      if (pos >= n || pos + 1 >= n || pos + leap >= n)
         return true;
      visited[pos] = true;
      if (game[pos + leap] == 0 && !visited[pos + leap])
         return canWin(pos + leap);
      if (game[pos + 1] == 0 && !visited[pos + 1])
         return canWin(pos + 1);
      if (pos-1 >= 0 && game[pos - 1] == 0 && !visited[pos - 1])
         return canWin(pos - 1);
      return false;
   }

   public static void main(String[] args) {
      int[] arr = { 0, 0, 0, 1, 1, 1 };
      new Array1D(arr, 5);

      arr = new int[] { 0, 0, 1, 1, 1, 0 };
      new Array1D(arr, 3);

   }

}