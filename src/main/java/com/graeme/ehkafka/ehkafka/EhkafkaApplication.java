package com.graeme.ehkafka.ehkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EhkafkaApplication implements CommandLineRunner {

    @Autowired
    private MyService directoryMonitorService;

    private static Logger LOG = LoggerFactory
            .getLogger(EhkafkaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EhkafkaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        directoryMonitorService.run();
    }

}
