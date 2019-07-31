package org.gmnz.hackerrank;

/**
 * Utils
 */
class Utils {

    static int findMax(int[] integers) {
        int max = 0;
        for (int i : integers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    static int mcm(int a, int b) {
        int min = a <= b ? a : b;
        int max = a > b ? a : b;
        int x = 0;
        for (int i = 1; i <= min; i++) {
            x = max * i;
            if (x % min == 0) {
                return x;
            }
        }
        return -1;
    }

    static void printArray(int[] integers) {
        System.out.println(toString(integers));
    }

    static String toString(int[] integers) {
        int maxValue = findMax(integers);
        double log10Max = Math.log10(maxValue);
        long stringMargin = (long) Math.ceil(log10Max) + 3;
        String numFormatString = "%-" + stringMargin + "d";
        StringBuilder sb = new StringBuilder("[  ");
        for (int i : integers) {
            sb.append(String.format(numFormatString, i));
        }
        sb.append("]");
        return sb.toString();
    }

}
