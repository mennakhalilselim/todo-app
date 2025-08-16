package com.example.todoapp.model.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record TodoListDto(
        UUID id,
        String title,
        String description,
        Integer count,
        Double progress,
        List<TodoDto> todos
) {
}
