package com.netec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class McrPedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McrPedidoApplication.class, args);
	}

}
