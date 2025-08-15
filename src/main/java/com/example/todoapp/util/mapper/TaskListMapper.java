package com.example.todoapp.util.mapper;

import com.example.todoapp.enums.TaskStatus;
import com.example.todoapp.model.dto.TaskListDto;
import com.example.todoapp.model.entity.Task;
import com.example.todoapp.model.entity.TaskList;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;

@UtilityClass
public class TaskListMapper {
    public static TaskList toEntity(TaskListDto taskListDto) {
        return TaskList.builder()
                .id(taskListDto.id())
                .title(taskListDto.title())
                .description(taskListDto.description())
                .tasks(
                        Optional.ofNullable(taskListDto.tasks())
                                .map(tasks -> tasks.stream()
                                        .map(TaskMapper::toEntity)
                                        .toList())
                                .orElse(null)
                )
                .build();
    }

    public static TaskListDto toDTO(TaskList taskList) {
        return TaskListDto.builder()
                .id(taskList.getId())
                .title(taskList.getTitle())
                .description(taskList.getDescription())
                .count(
                        Optional.ofNullable(taskList.getTasks())
                                .map(List::size)
                                .orElse(0)
                )
                .progress(calculateProgress(taskList.getTasks()))
                .tasks(
                        Optional.ofNullable(taskList.getTasks())
                                .map(tasks -> tasks.stream()
                                        .map(TaskMapper::toDTO)
                                        .toList())
                                .orElse(null)
                )
                .build();
    }

    private double calculateProgress(List<Task> tasks) {
        return Optional.ofNullable(tasks)
                .filter(list -> !list.isEmpty())
                .map(list -> {
                    long doneTasks = list.stream()
                            .filter(task -> task.getStatus() == TaskStatus.CLOSED)
                            .count();
                    return (double) doneTasks / list.size();
                })
                .orElse(0.0);
    }

}
