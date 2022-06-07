package com.waw.common;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

// TODO JWT 토큰 인증 개발 이후 진행 예정
@Component
public class AuthGatewayFilter extends AbstractGatewayFilterFactory<AuthGatewayFilter.Config> {

	private final String TOKEN = "token";
	
	public AuthGatewayFilter() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();
			
			// Request Header에 token이 존재하지 않을 때
			if (!request.getHeaders().containsKey(TOKEN)) {
				response.setStatusCode(HttpStatus.UNAUTHORIZED);
				return response.setComplete();
			}
			
			// Request Header에서 token 문자열 받아오기
			List<String> token = request.getHeaders().get(TOKEN);
			String tokenString = Objects.requireNonNull(token).get(0);
			
			// 토큰 검증
			if (!tokenString.equals("asdf")) {
				response.setStatusCode(HttpStatus.UNAUTHORIZED);
				return response.setComplete();
			}
			
			return chain.filter(exchange);
		});
	}

	public static class Config {
		
	}
}
