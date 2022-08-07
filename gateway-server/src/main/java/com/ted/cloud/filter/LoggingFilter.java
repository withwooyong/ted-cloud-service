package com.ted.cloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {
    public LoggingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            if (config.isPreLogger()) {
//                log.info("Logging PRE Filter Start: request LocalAddress -> {}", request.getLocalAddress());
//                log.info("Logging PRE Filter Start: request RemoteAddress -> {}", request.getRemoteAddress());
                // request -> /auth/token {userName=[token]}
                log.info("request -> {} {}", request.getPath(), request.getQueryParams());
//                log.info("Logging PRE Filter Start: request QueryParams -> {}", request.getQueryParams());
//                log.info("Logging PRE Filter Start: request Body -> {}", request.getBody());
//                log.info("request -> {}", request.getURI());
//                log.info("Logging PRE Filter Start: request -> {}", request);
            }

            //Custom Post Filter
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    // response code -> 200 OK
                    log.info("response code -> {} ", response.getStatusCode());
//                    log.info("response -> {} ", response.toString());
                }
            }));
        }, Ordered.HIGHEST_PRECEDENCE); // 우선순위 지정할 수 있다
        //LOWEST_PRECEDENCE

        return filter;
    }

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
