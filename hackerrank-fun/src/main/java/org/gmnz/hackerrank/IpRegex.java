package org.gmnz.hackerrank;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        /*
         * Scanner in = new Scanner(System.in); while (in.hasNext()) { String IP =
         * in.next(); System.out.println(IP.matches(new MyRegex().pattern)); }
         * in.close();
         */

        String[] test = {

                "259.259.259.259", "266.266.266.266", "255.255.255.255", "555.555.555.555", "666.666.666.666",
                "249.249.249.249", "249.249.249.256"

        };

        // String IP = "141.250.25.6";
        String IP = "249.249.249.249";
        System.out.println(IP.matches(new MyRegex().pattern));

        for (String ip : test) {
            System.out.format("%s - %s%n", ip, ip.matches(new MyRegex().pattern));
        }
    }
}

// Write your code here
class MyRegex {
    private static final String OCTET = "(([01]?[0-9]{1,2})|(25[0-5])|(2[0-4][0-9]))";
    final String pattern0 = "^((([01]?[0-9]{1,2})|(25[0-5])|(2[0-4][0-9]))\\.){3}([01]?[0-9]{1,2})|(25[0-5])|(2[0-4][0-9])$";

    final String pattern = "^" +

            "(" + OCTET + "\\.){3}" + OCTET + "$";
}