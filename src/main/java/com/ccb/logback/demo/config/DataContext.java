package com.ccb.logback.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataContext {

    private static DataContext context = new DataContext();

    private static ThreadLocal<Map<String, String>> contextLocal = new ThreadLocal<Map<String, String>>() {
        @Override
        protected Map<String, String> initialValue() {
            return new HashMap<String, String>();
        }
    };

    public static DataContext getContext() {
        return context;
    }

    public boolean put(String key, String value) {
        contextLocal.get().put(key, value);
        return true;
    }

    public String get(String key) {
        return contextLocal.get().get(key);
    }

    public Set<Map.Entry<String, String>> getAll() {
        return contextLocal.get().entrySet();
    }

    public String remove(String key) {
        return contextLocal.get().remove(key);
    }

    public void clear() {
        contextLocal.get().clear();
    }

}
