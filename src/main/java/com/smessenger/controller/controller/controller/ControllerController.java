package com.smessenger.controller.controller.controller;

import com.smessenger.controller.controller.dao.DeleteMessageRequestDao;
import com.smessenger.controller.controller.service.DeleteMessageService;
import com.smessenger.controller.shared.controller.MainController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ControllerController extends MainController {
    private final DeleteMessageService deleteMessageService;

    @DeleteMapping("/message")
    public Mono<Void> deleteMessage(@Valid @RequestBody DeleteMessageRequestDao deleteMessageRequestDao) {
        return deleteMessageService.deleteMessage(deleteMessageRequestDao);
    }
}
