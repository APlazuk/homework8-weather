package pl.aplazuk.homework8weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Homework8WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(Homework8WeatherApplication.class, args);
    }

}
