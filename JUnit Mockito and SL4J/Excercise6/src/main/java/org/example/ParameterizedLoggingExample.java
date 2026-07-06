package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "John";
        int age = 25;

        logger.info("User Name : {}", name);

        logger.info("User Age : {}", age);

        logger.info("User Name : {} and Age : {}", name, age);

    }

}