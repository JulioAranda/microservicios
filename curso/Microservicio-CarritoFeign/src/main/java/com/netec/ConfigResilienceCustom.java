package com.netec;



import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@Configuration
public class ConfigResilienceCustom {

	public Customizer<Resilience4JCircuitBreakerFactory> config() {
		return factory -> factory.configureDefault(id -> {
			
			if(id.equals("circuito1")) {
				return new Resilience4JConfigBuilder(id)
						.circuitBreakerConfig(CircuitBreakerConfig.custom()
								.slidingWindowSize(10)
								.failureRateThreshold(5)
								.waitDurationInOpenState(Duration.ofSeconds(10L))
								.permittedNumberOfCallsInHalfOpenState(5)
								.build())
						.build();
				//return null;		
				
			} else {
				return  new Resilience4JConfigBuilder(id)
						.circuitBreakerConfig(CircuitBreakerConfig.custom()
							.slidingWindowSize(20)
							.failureRateThreshold(50)
							.waitDurationInOpenState(Duration.ofSeconds(20L))
							.permittedNumberOfCallsInHalfOpenState(10)
							.build())
				.build();
			}
		});
	}
}
