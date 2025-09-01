package com.pragma.observability;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

public final class CorrelationFilter implements WebFilter {

    static final String CORRELATION_KEY = "correlationId";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String headerCid = exchange.getRequest().getHeaders().getFirst("X-Correlation-Id");
        final String cid = (headerCid == null || headerCid.isBlank())
                ? UUID.randomUUID().toString()
                : headerCid;

        exchange.getResponse().getHeaders().set("X-Correlation-Id", cid);

        return chain.filter(exchange)
                .contextWrite(ctx -> ctx.put(CORRELATION_KEY, cid));
    }

}
