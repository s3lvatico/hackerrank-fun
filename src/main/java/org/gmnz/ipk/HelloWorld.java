package org.gmnz.ipk;

public class HelloWorld {

    public String getEnvironmentValue(String envVarName) {
        return System.getenv(envVarName);
    }

    public String sayHello() {
        return "Hello world";
    }

}