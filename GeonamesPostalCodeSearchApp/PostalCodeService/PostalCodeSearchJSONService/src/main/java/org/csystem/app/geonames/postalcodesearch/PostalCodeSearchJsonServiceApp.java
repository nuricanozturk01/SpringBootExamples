package org.csystem.app.geonames.postalcodesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.csystem")
@EnableJpaRepositories("org.csystem")
@EntityScan("org.csystem")
public class PostalCodeSearchJsonServiceApp
{

	public static void main(String[] args) {
		SpringApplication.run(PostalCodeSearchJsonServiceApp.class, args);
	}

}
