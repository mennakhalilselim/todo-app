package com.example.todoapp.util.mapper;

import com.example.todoapp.model.dto.TodoDto;
import com.example.todoapp.model.entity.Todo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TodoMapper {
    public static Todo toEntity(TodoDto todoDto) {
        return Todo.builder()
                .id(todoDto.id())
                .title(todoDto.title())
                .description(todoDto.description())
                .dueDate(todoDto.dueDate())
                .status(todoDto.status())
                .priority(todoDto.priority())
                .todoList(null)
                .build();
    }

    public static TodoDto toDTO(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .dueDate(todo.getDueDate())
                .status(todo.getStatus())
                .priority(todo.getPriority())
                .build();
    }
}
