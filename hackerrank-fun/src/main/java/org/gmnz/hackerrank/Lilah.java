package org.gmnz.hackerrank;

public class Lilah {

    public static void main(String[] args) {

        String s = "XcqXa";
        String composition = "XcqXaXcqXaXcqXaXcq";

        int occurrencesOfA = 0;
        int occurrencesInBasicString = 0;
        int occurrencesInRemainder = 0;
        int remainder = composition.length() % s.length();

        int idx = 0;
        while (idx < s.length()) {
            if ('X' == s.charAt(idx)) {
                occurrencesInBasicString++;
                if (idx < remainder) {
                    occurrencesInRemainder++;
                }
            }
            idx++;
        }

        occurrencesOfA = (composition.length() / s.length()) * occurrencesInBasicString + occurrencesInRemainder;

        System.out.println("occorrenze di \"a\" : " + occurrencesOfA);
    }

}