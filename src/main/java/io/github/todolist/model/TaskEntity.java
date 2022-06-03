package io.github.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TASKS")
public class TaskEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

}
