package com.atguigu.cloud.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @Author：daxue0929
 * @Date：2024/3/14 13:34
 * desc: http://localhost:9527/pay/gateway/filter?daxuetest=123
 *  query参数中，携带了daxuetest的键，就会被拦截掉(在yaml中配置)
 */
@Component
@Slf4j
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {


    public static final String STATUS = "status";

    public MyGatewayFilterFactory() {
        super(MyGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(STATUS);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("进入了自定义过滤器: MyGatewayGatewayFilterFactory, status: {}", config.getStatus());
                ServerHttpRequest request = exchange.getRequest();
                if (request.getQueryParams().containsKey(config.getStatus())) {
                    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                    return exchange.getResponse().setComplete();
                }
                return chain.filter(exchange);
            }
        };
    }

    public static class Config {
        @Getter@Setter
        private String status;

    }
}
