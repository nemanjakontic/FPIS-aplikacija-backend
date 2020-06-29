package com.kud.kud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan(basePackages = {"modeli"})
@ComponentScan(basePackages = {"repozitorijumi", "controller", "security", "service"})
@EnableJpaRepositories(basePackages = {"repozitorijumi"})
@EnableAsync
//@Configuration
//@EnableScheduling
public class KudApplication {

	public static void main(String[] args) {
		SpringApplication.run(KudApplication.class, args);
	}

}
