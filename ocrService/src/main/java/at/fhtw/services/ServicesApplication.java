package at.fhtw.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication
@ComponentScan(
		basePackages = {"at.fhtw.config.comm", "at.fhtw.persistance", "at.fhtw.services.comm", "at.fhtw.config.elasticsearch", "at.fhtw.services.elasticsearch"},
		nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class ServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}
}
