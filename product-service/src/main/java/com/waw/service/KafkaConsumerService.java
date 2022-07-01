package com.waw.service;

import com.waw.exception.KafkaDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "waw", groupId = "order-data")
    public void consumer(String message) throws KafkaDataException {
        log.info("============================");
        log.info("KAFKA MESSAGE :: {}", message);
        log.info("============================");
    }
}
