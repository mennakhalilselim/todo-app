package com.example.todoapp.model.dto;

import com.example.todoapp.enums.TodoPriority;
import com.example.todoapp.enums.TodoStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record TodoDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TodoStatus status,
        TodoPriority priority
) {
}
