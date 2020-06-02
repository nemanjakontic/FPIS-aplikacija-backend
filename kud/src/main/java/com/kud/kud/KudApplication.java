package com.kud.kud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"modeli"})
@ComponentScan(basePackages = {"repozitorijumi"})
@EnableJpaRepositories(basePackages = {"repozitorijumi"})
public class KudApplication {

	public static void main(String[] args) {
		SpringApplication.run(KudApplication.class, args);
	}

}
