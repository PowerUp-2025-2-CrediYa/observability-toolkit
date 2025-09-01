package com.pragma.observability;

import java.util.Map;

public interface AppLogger {

    void info(String event, String message, LogCtx ctx, Map<String, Object> kv);
    void warn(String event, String message, LogCtx ctx, Map<String, Object> kv);
    void error(String event, String message, LogCtx ctx, Throwable ex, Map<String, Object> kv);
}
