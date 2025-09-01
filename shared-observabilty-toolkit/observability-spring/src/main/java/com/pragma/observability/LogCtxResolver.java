package com.pragma.observability;

import reactor.core.publisher.Mono;

public class LogCtxResolver {

    private LogCtxResolver(){}

    public static Mono<LogCtx> current() {
        return Mono.deferContextual(Mono::just)
                .map(ctx -> new LogCtx(
                        ctx.getOrDefault(CorrelationFilter.CORRELATION_KEY, null),
                        ctx.getOrDefault("userId", null),
                        ctx.getOrDefault("tenantId", null)
                ));
    }

}
