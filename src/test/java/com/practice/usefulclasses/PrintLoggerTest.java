package com.practice.usefulclasses;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class PrintLoggerTest {

    @Test
    public void testForTrueValuePrintLogger() {
        Logger logger = (Logger) LoggerFactory.getLogger(PrintLogger.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        PrintLogger printLogger = new PrintLogger();
        printLogger.printLogger(Boolean.TRUE);
        printLogger = new PrintLogger();
        printLogger.printLogger(Boolean.FALSE);

        Assertions.assertThat(listAppender.list)
                .extracting(ILoggingEvent::getMessage, ILoggingEvent::getLevel)
                .containsAll(Arrays.asList(
                        Tuple.tuple("Value is true", Level.INFO),
                        Tuple.tuple("Value is false", Level.WARN)
                ));

    }
}
