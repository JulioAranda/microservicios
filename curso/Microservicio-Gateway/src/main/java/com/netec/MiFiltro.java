package com.netec;

import java.util.Optional;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MiFiltro implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		exchange.getRequest().mutate().headers(c -> c.add("token", "12345"));
		
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
			
			Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token"))
			.ifPresent(t -> exchange.getResponse().getHeaders().add("token", t));
		}));
	}

}
