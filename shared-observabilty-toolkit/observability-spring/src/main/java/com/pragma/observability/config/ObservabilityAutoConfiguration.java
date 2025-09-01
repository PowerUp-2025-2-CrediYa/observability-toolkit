package com.pragma.observability.config;

import com.pragma.observability.AppLogger;
import com.pragma.observability.CorrelationFilter;
import com.pragma.observability.Slf4jAppLogger;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

@AutoConfiguration
public class ObservabilityAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(AppLogger.class)
    AppLogger appLogger() {
        return new Slf4jAppLogger();
    }

    @Bean
    @ConditionalOnMissingBean(name = "correlationFilter")
    WebFilter correlationFilter() {
        return new CorrelationFilter();
    }

}
