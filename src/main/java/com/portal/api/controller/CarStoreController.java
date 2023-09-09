package com.portal.api.controller;

import com.portal.api.dto.CarDTO;
import com.portal.api.message.KafkaProducerMessage;
import com.portal.api.service.CarStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarStoreController {

    @Autowired
    protected CarStoreService carStoreService;

    @Autowired
    protected KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/posts")
    public ResponseEntity<Void> carSale(@RequestBody CarDTO carDTO) {

        kafkaProducerMessage.send(carDTO);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarDTO>> getCarSales() {

        return ResponseEntity.status(HttpStatus.FOUND).body(carStoreService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarSale(@RequestBody CarDTO carDTO, @PathVariable String id) {

        carStoreService.changeCarForSale(carDTO, id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarForSale(@PathVariable String id) {

        carStoreService.removeCarForSale(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
