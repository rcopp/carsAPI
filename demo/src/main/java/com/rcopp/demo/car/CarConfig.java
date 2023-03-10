package com.rcopp.demo.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner(CarRepository repository){
        return args -> {

            Car hilux = new Car(
                    "AE722XO",
                    "Toyota",
                    "Hilux",
                    "SRV",
                    2021,
                    35000
            );

            Car vento = new Car(
                    "OBO508",
                    "Volkswagen",
                    "Vento",
                    "Luxury",
                    2014,
                    75000
            );

            repository.saveAll(
                    List.of(hilux, vento)
            );

        };
    }
}
