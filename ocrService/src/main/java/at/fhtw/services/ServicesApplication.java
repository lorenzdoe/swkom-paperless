package at.fhtw.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(
		nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@EnableElasticsearchRepositories(basePackages = "at.fhtw.persistance")

@ComponentScan(
		basePackages = {"at.fhtw.config.comm", "at.fhtw.config.elasticsearch", "at.fhtw.persistance", "at.fhtw.services.elasticsearch"},
		nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
//@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = "at.fhtw.persistance")
//@ComponentScan(basePackages = {"at.fhtw"})
public class ServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}
}