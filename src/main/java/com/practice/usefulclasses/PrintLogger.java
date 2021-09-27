package com.practice.usefulclasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintLogger.class);

    public void printLogger(Boolean input) {
        if (input.equals(Boolean.TRUE)) {
            LOGGER.info("Value is true");
        }
        if (input.equals(Boolean.FALSE)) {
            LOGGER.warn("Value is false");
        }
    }
}
