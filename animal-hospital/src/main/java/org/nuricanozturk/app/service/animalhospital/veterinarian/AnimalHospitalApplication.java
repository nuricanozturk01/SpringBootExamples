package org.nuricanozturk.app.service.animalhospital.veterinarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.metemengen", "org.nuricanozturk"})
public class AnimalHospitalApplication
{
    public static void main(String[] args) {
        SpringApplication.run(AnimalHospitalApplication.class, args);
    }

}
