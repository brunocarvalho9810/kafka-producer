package com.kafka.producer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Classe responsável pelas configurações do Kafka Producer
 * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
 */
@Configuration
public class ProducerKafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties; // Configuracoes do Kafka

    /**
     * Responsável por gerar ProducerFactory, onde consiste todas configurações do kafka producer
     * @return ProducerFactory<String, String>
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @Bean
    public ProducerFactory<String, String> pruducerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers()); // Pega informacao no application.properties
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);  // Como deseja serializar as mensagens
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // Como deseja serializar a chave da mensagem
        return new DefaultKafkaProducerFactory<>(configs);
    }

    /**
     * Responsável por gerar KafkaTemplate, onde consiste na produção de mensagens em tópicos do Apache Kafka
     * @return KafkaTemplate<String, String>
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(pruducerFactory());
    }

    /**
     * Responsável por gerar ProducerFactory, onde consiste todas configurações do kafka producer
     * @return ProducerFactory<String, Object>
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @Bean
    public ProducerFactory<String, Serializable> jsonPruducerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers()); // Pega informacao no application.properties
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);  // Como deseja serializar as mensagens
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Como deseja serializar a chave da mensagem
        return new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new JsonSerializer<>());
    }

    /**
     * Responsável por gerar KafkaTemplate, onde consiste na produção de mensagens em tópicos do Apache Kafka
     * @return KafkaTemplate<String, Serializable>
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @Bean
    public KafkaTemplate<String, Serializable> jsonKafkaTemplate() {
        return new KafkaTemplate<>(jsonPruducerFactory());
    }

    /**
     * Responsável por gerar KafkaAdmin, que permite a administração, criação, exclusão e configuração de tópicos do Apache Kafka.
     * @return KafkaAdmin
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    /**
     * Responsável por gerar NewTopic, utilizado para criar tópicos no ‘cluster’ do Apache Kafka por meio da API do Kafka Admin.
     * @return NewTopic
     * @apiNote Esse metodo não é necessário se o topico kafka ja foi criado
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @Bean
    public NewTopic topic1() {
        return new NewTopic("topic-1", 10, Short.parseShort("1"));
    }

    /**
     * Responsável por gerar NewTopics, utilizado para criar mais de um tópico no ‘cluster’ do Apache Kafka
     * por meio da API do Kafka Admin.
     * @return NewTopic
     * @apiNote Esse metodo é uma outra maneira de criar topicos pela API do Kafka, não e necessario se o topico
     * ja foi configurado via docker
     * @author <a href="https://github.com/brunocarvalho9810/"> Bruno Carvalho </a>
     */
    @Bean
    public KafkaAdmin.NewTopics topicPerson() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("person-topic").partitions(10).build()
        );
    }

}