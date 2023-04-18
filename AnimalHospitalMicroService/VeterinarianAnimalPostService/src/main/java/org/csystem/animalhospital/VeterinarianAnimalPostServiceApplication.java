package org.csystem.animalhospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.csystem", "com.metemengen"})
public class VeterinarianAnimalPostServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(VeterinarianAnimalPostServiceApplication.class, args);
    }

}
