package org.csystem.app.service.animalhospital.owner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.csystem", "com.metemengen"})
@EnableJpaRepositories(basePackages = "com.metemengen")
@EntityScan(basePackages = "com.metemengen")
public class OwnerGetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnerGetServiceApplication.class, args);
	}

}
