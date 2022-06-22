package io.github.todolist.model;

import io.github.todolist.dto.form.TaskForm;
import io.github.todolist.enums.StatusTaskEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "TASKS")
public class TaskEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate dateCreation;
    private StatusTaskEnum status;
    @Column(name = "task_order")
    private Integer order;

    public void update(TaskForm form){
        this.name = form.getName();
        this.description = form.getDescription();
        this.dateCreation = form.getDateCreation();
        this.status = StatusTaskEnum.valueOf(form.getStatus());

    }
}


