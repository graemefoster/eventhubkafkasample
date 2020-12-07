package com.graeme.ehkafka.ehkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static Logger LOG = LoggerFactory
            .getLogger(MyService.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    MyService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void run() {
        LOG.info("Welcome to the world!");
        for (int i = 0; i < 100; i++) {
            this.kafkaTemplate.send("kafkaehtest", "MyTestKey", String.format("TestMessage:%s", i));
        }
        LOG.info("My messages are sent!");
    }
}
