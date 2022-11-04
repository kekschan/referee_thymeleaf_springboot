package ru.dnsbo.referee.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan("ru.dnsbo.referee.web")
@EnableJpaRepositories(basePackages = "ru.dnsbo.referee.repository")
@EntityScan(basePackages = {"ru.dnsbo.referee.models"})
public class RefereeThymeleafSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(RefereeThymeleafSpringApplication.class, args);
    }

}
