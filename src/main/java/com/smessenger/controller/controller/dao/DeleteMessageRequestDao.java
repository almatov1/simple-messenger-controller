package com.smessenger.controller.controller.dao;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeleteMessageRequestDao {
    @NotNull
    private String messageId;
}
