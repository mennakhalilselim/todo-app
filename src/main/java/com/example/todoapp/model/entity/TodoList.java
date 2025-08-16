package com.example.todoapp.model.entity;

import com.example.todoapp.model.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo_lists")
public class TodoList extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    @OneToMany(mappedBy = "todoList", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Todo> todos;
}
