package com.pragma.observability;

public record LogCtx(String correlationId, String userId, String tenantId) {

    public static LogCtx empty() {
        return new LogCtx(null, null, null);
    }
}
