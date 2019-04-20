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

    static void printArray(int[] integers) {
        int maxValue = findMax(integers);
        double log10Max = Math.log10(maxValue);
        long stringMargin = (long) Math.ceil(log10Max) + 2;
        String numFormatString = "%-" + stringMargin + "d";
        StringBuilder sb = new StringBuilder("[  ");
        for (int i : integers) {
            sb.append(String.format(numFormatString, i));
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}
