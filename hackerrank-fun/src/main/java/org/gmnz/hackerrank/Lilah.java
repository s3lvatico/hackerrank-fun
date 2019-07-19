package org.gmnz.hackerrank;

public class Lilah {

    public static void main(String[] args) {
        String s = "acquaacquaacquaacquaacquaacquaacquaacquaacquaacquaacq";

        int idx = 0;
        int occurrencesOfA = 0;
        while (idx < s.length()) {
            if ('a' == s.charAt(idx++)) {
                occurrencesOfA++;
            }
        }

        System.out.println("occorrenze di \"a\" : " + occurrencesOfA);
    }

}