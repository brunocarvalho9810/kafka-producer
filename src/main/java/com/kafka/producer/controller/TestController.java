package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Classe responsável por receber solicitações API REST
 * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
 */
@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Responsável por receber uma solicitação Http do tipo GET e enviar uma mensagem para o topic-1
     * @return ResponseEntity<?>
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @GetMapping("send")
    public ResponseEntity<?> send(){
        kafkaTemplate.send("topic-1", "Envio de : " + LocalDateTime.now());
        return ResponseEntity.ok().build();
    }
}