package com.ccb.logback.demo.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MyConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return DataContext.getContext().get("id") == null ? "" : DataContext.getContext().get("id");
    }
}
