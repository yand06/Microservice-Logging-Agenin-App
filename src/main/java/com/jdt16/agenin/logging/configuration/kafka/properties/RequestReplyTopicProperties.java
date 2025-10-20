package com.jdt16.agenin.logging.configuration.kafka.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "request-reply-topic")
public class RequestReplyTopicProperties {
    private String createLogTopic;

    public String[] getTopics() {
        return new String[] {
                createLogTopic
        };
    }
}
