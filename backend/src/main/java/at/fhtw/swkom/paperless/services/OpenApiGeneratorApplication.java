package at.fhtw.swkom.paperless.services;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
    basePackages = {"at.fhtw.swkom.paperless.persistance", "at.fhtw.swkom.paperless.services", "at.fhtw.swkom.paperless.controller" , "at.fhtw.swkom.paperless.config"},
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@EnableJpaRepositories(
    basePackages = {"at.fhtw.swkom.paperless.persistance.repositories"}
)
@EntityScan(
    basePackages = {"at.fhtw.swkom.paperless.persistance.entities"}
)
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean(name = "at.fhtw.swkom.paperless.services.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}