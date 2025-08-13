package com.example.todoapp.model.dto;

import com.example.todoapp.enums.TaskPriority;
import com.example.todoapp.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
