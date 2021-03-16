package ru.bgpu.demoorder.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("development")
@Configuration
public class DevelopmentConfiguration {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    CommandLineRunner developmentInit() {
        return args -> {
            logger.error("DEV INIT!");
        };
    }

}
