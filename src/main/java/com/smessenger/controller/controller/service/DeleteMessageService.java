package com.smessenger.controller.controller.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smessenger.controller.controller.dao.DeleteMessageRequestDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteMessageService {
    private final AmqpTemplate amqpTemplate;

    public Mono<Void> deleteMessage(DeleteMessageRequestDao deleteMessageRequestDao) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            log.info("msg sended");
            amqpTemplate.convertAndSend("messages", objectMapper.writeValueAsString(deleteMessageRequestDao));
        } catch (JsonProcessingException e) {
            log.error("json problem");
        }

        return Mono.empty();
    }

}
