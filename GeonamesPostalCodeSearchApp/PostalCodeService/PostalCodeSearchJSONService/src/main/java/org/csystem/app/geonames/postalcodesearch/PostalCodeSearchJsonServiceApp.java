package org.csystem.app.geonames.postalcodesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.csystem")
public class PostalCodeSearchJsonServiceApp
{

	public static void main(String[] args) {
		SpringApplication.run(PostalCodeSearchJsonServiceApp.class, args);
	}

}
