package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.debug("Debug Message");

        logger.info("Information Message");

        logger.warn("Warning Message");

        logger.error("Error Message");

    }

}