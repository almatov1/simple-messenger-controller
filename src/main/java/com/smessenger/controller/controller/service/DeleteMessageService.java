package com.smessenger.controller.controller.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smessenger.controller.controller.dao.DeleteMessageRequestDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteMessageService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Mono<Void> deleteMessage(DeleteMessageRequestDao deleteMessageRequestDao) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            kafkaTemplate.send("messageTopic2", objectMapper.writeValueAsString(deleteMessageRequestDao));
            log.info("msg sended to kafka");
        } catch (JsonProcessingException e) {
            log.error("json problem");
        }

        return Mono.empty();
    }
}
