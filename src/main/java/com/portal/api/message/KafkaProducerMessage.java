package com.portal.api.message;

import com.portal.api.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    protected KafkaTemplate<String, CarDTO> kafkaTemplate;

    private static final String KAFKA_TOPIC = "car-topic";

    public void send(CarDTO carDTO) {

        kafkaTemplate.send(KAFKA_TOPIC, carDTO);
    }
}
