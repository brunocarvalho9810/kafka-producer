package com.kafka.producer.controller;

import com.kafka.producer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.stream.IntStream;

/**
 * Classe responsável por receber solicitações API REST
 * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
 */
@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    /**
     * Responsável por receber uma solicitação Http do tipo GET e enviar uma mensagem para o topic-1
     * @return ResponseEntity<?>
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @GetMapping("send")
    public ResponseEntity<?> send(){
        IntStream.range(1, 50)
                .boxed()
                .forEach(numero -> kafkaTemplate.send("topic-1", "Numero: " + numero));
        return ResponseEntity.ok().build();
    }

    /**
     * Responsável por receber uma solicitação Http do tipo GET e enviar um objeto do tipo Person para o topic-1
     * @return ResponseEntity<?>
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @GetMapping("send-person")
    public ResponseEntity<?> sendPerson(){
        var name = "Bruno Carvalho";
        var age = 26;

        var person = new Person(name, age);
        jsonKafkaTemplate.send("person-topic", person);
        return ResponseEntity.ok().build();
    }
}