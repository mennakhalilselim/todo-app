package com.example.todoapp.util.mapper;

import com.example.todoapp.model.dto.TaskDto;
import com.example.todoapp.model.entity.Task;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskMapperImpl {
    public static Task toEntity(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.id())
                .title(taskDto.title())
                .description(taskDto.description())
                .dueDate(taskDto.dueDate())
                .status(taskDto.status())
                .priority(taskDto.priority())
                .taskList(null)
                .build();
    }

    public static TaskDto toDTO(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .priority(task.getPriority())
                .build();
    }
}
