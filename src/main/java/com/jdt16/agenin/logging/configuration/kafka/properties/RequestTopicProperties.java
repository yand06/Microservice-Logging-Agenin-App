package com.jdt16.agenin.logging.configuration.kafka.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "request-topic")
public class RequestTopicProperties {
    private String createLogTopic;
}

