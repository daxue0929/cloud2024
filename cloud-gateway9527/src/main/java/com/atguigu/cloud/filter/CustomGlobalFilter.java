package com.atguigu.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @Author：daxue0929
 * @Date：2024/3/14 12:58
 * desc: gateway网关层面的全局过滤器
 *  1. 做一些接口耗时的统计操作
 */
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    public static final String BEGIN_VISIT_TIME = "begin_visit_time";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Map<String, Object> attributes = exchange.getAttributes();
        // 记录下来访问开始的时间
        attributes.put(BEGIN_VISIT_TIME, System.currentTimeMillis());
        // 返回统计的各个结果给后台
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long beginVisitTime = exchange.getAttribute(BEGIN_VISIT_TIME);
            if (beginVisitTime != null) {
                ServerHttpRequest request = exchange.getRequest();
                log.info("访问接口主机: {}, 端口: {}, URL: {}, 参数: {}, cost: {} 毫秒",
                        request.getURI().getHost(),
                        request.getURI().getPort(),
                        request.getURI().getPath(),
                        request.getURI().getRawQuery(),
                        System.currentTimeMillis() - beginVisitTime);
                log.info("========================分割线=======================");
            }
        }));
    }

    // 值越小，优先级越高
    @Override
    public int getOrder() {
        return -1;
    }
}
