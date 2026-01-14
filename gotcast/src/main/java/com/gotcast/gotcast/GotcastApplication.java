package com.gotcast.gotcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.gotcast.gotcast.entities")
@EnableJpaRepositories("com.gotcast.gotcast.repositories")
@ComponentScan(basePackages = {"com.gotcast.gotcast"})
public class GotcastApplication {
	public static void main(String[] args) {
		SpringApplication.run(GotcastApplication.class, args);
	}
}
