package com.example.demo;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfiguration {
    @Bean
    @ServiceConnection
    @RestartScope
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>("postgres:16");
    }

    @Bean
    @ServiceConnection
    @RestartScope
    RabbitMQContainer rabbitContainer() {
        try (RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:3.13")) {
            return rabbitMQContainer
                    .withExposedPorts(5672, 15672);
        }
    }
}
