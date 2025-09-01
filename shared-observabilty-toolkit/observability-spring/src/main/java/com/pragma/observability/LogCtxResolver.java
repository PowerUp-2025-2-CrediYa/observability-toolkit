package com.pragma.observability;

import reactor.core.publisher.Mono;

public class LogCtxResolver {

    public static Mono<LogCtx> current() {
        return Mono.deferContextual(Mono::just)
                .map(ctx -> new LogCtx(
                        ctx.getOrDefault(CorrelationFilter.CORRELATION_KEY, null),
                        (String) ctx.getOrDefault("userId", null),
                        (String) ctx.getOrDefault("tenantId", null)
                ));
    }

}
