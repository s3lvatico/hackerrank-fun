package org.gmnz.ipk;

public class HelloWorldMain {

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        String hello = hw.sayHello();
        System.out.printf("hello string : %s%n", hello);
        String envVar = hw.getEnvironmentValue("OUTPUT_PATH");
        System.out.printf("envVar : %s%n", envVar);
        System.out.printf("sysVar : %s%n", System.getProperty("OUTPUT_PATH"));
    }

}