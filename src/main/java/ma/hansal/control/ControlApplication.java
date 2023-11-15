package ma.hansal.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@SpringBootApplication
@EntityScan (basePackages = "ma.hansal.entities")
@ComponentScan(basePackages = {"ma.hansal.controllers","ma.hansal.services"})
@EnableJpaRepositories(basePackages = "ma.hansal.repository")
public class ControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlApplication.class, args);
	}

}
