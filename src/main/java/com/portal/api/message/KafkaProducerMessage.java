package com.portal.api.message;

import com.portal.api.dto.CarDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerMessage.class);

    private static final String KAFKA_TOPIC = "car-topic";

    @Autowired
    protected KafkaTemplate<String, CarDTO> kafkaTemplate;

    public void send(CarDTO carDTO) {
        LOG.info("API PORTAL - Producer Car Post information: {}", carDTO);

        kafkaTemplate.send(KAFKA_TOPIC, carDTO);
    }
}
