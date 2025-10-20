package edu.fra.uas.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.hello.noten.GradeService;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}


	@Bean
    CommandLineRunner run(GradeService service) {
        return args -> {
            service.addGrade("Mathe", 1.3, 5);
            service.addGrade("Programmierung", 2.0, 10);

            System.out.println("🧮 Notendurchschnitt:");
            System.out.println("Ungewichtet: " + service.average());
            System.out.println("Gewichtet:   " + service.weightedAverage());
        };
	}
}
