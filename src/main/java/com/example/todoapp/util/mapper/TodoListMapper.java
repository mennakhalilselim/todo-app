package com.example.todoapp.util.mapper;

import com.example.todoapp.enums.TodoStatus;
import com.example.todoapp.model.dto.TodoListDto;
import com.example.todoapp.model.entity.Todo;
import com.example.todoapp.model.entity.TodoList;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;

@UtilityClass
public class TodoListMapper {
    public static TodoList toEntity(TodoListDto todoListDto) {
        return TodoList.builder()
                .id(todoListDto.id())
                .title(todoListDto.title())
                .description(todoListDto.description())
                .todos(
                        Optional.ofNullable(todoListDto.todos())
                                .map(todos -> todos.stream()
                                        .map(TodoMapper::toEntity)
                                        .toList())
                                .orElse(null)
                )
                .build();
    }

    public static TodoListDto toDTO(TodoList todoList) {
        return TodoListDto.builder()
                .id(todoList.getId())
                .title(todoList.getTitle())
                .description(todoList.getDescription())
                .count(
                        Optional.ofNullable(todoList.getTodos())
                                .map(List::size)
                                .orElse(0)
                )
                .progress(calculateProgress(todoList.getTodos()))
                .todos(
                        Optional.ofNullable(todoList.getTodos())
                                .map(todos -> todos.stream()
                                        .map(TodoMapper::toDTO)
                                        .toList())
                                .orElse(null)
                )
                .build();
    }

    private double calculateProgress(List<Todo> todos) {
        return Optional.ofNullable(todos)
                .filter(list -> !list.isEmpty())
                .map(list -> {
                    long doneTodos = list.stream()
                            .filter(todo -> todo.getStatus() == TodoStatus.CLOSED)
                            .count();
                    return (double) doneTodos / list.size();
                })
                .orElse(0.0);
    }

}
