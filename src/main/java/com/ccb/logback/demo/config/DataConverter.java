package com.ccb.logback.demo.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.util.OptionHelper;

import java.util.Iterator;
import java.util.Map;

public class DataConverter extends ClassicConverter {

    private String key;
    private String defaultValue = "";

    @Override
    public void start() {
        String[] keyInfo = OptionHelper.extractDefaultReplacement(this.getFirstOption());
        this.key = keyInfo[0];
        if (keyInfo[1] != null) {
            this.defaultValue = keyInfo[1];
        }

        super.start();
    }

    @Override
    public void stop() {
        this.key = null;
        super.stop();
    }

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        DataContext context = DataContext.getContext();
        if (context == null) {
            return this.defaultValue;
        } else if (this.key == null) {
            return this.outputContextForAllKeys(context);
        } else {
            String value = context.get(this.key);
            return value != null ? value : this.defaultValue;
        }
    }

    private String outputContextForAllKeys(DataContext context) {
        StringBuilder buf = new StringBuilder();
        boolean first = true;
        Map.Entry entry;
        for (Iterator var5 = context.getAll().iterator(); var5.hasNext(); buf.append((String) entry.getKey()).append('=').append((String) entry.getValue())) {
            entry = (Map.Entry) var5.next();
            if (first) {
                first = false;
            } else {
                buf.append(", ");
            }
        }
        return buf.toString();
    }

}
