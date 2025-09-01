package com.pragma.observability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public final class Slf4jAppLogger implements AppLogger{

    private static final Logger log = LoggerFactory.getLogger("app");

    private Map<String, Object> base(LogCtx ctx) {
        Map<String, Object> m = new HashMap<>();
        if (ctx != null) {
            if (ctx.correlationId() != null) m.put("correlationId", ctx.correlationId());
            if (ctx.userId() != null)        m.put("userId", ctx.userId());
            if (ctx.tenantId() != null)      m.put("tenantId", ctx.tenantId());
        }
        return m;
    }

    @Override
    public void info(String event, String message, LogCtx ctx, Map<String, Object> kv) {

        Map<String,Object> data = base(ctx);
        if (kv != null) data.putAll(kv);
        data.put("event", event);
        log.info("{} | {}", message, data);
    }

    @Override
    public void warn(String event, String message, LogCtx ctx, Map<String, Object> kv) {
        Map<String,Object> data = base(ctx);
        if (kv != null) data.putAll(kv);
        data.put("event", event);
        log.warn("{} | {}", message, data);
    }

    @Override
    public void error(String event, String message, LogCtx ctx, Throwable ex, Map<String, Object> kv) {
        Map<String,Object> data = base(ctx);
        if (kv != null) data.putAll(kv);
        data.put("event", event);
        log.error("{} | {}", message, data, ex);
    }
}
