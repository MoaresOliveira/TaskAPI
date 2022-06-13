package io.github.todolist.dto.form;

import io.github.todolist.model.TaskEntity;
import lombok.Data;
import org.springframework.scheduling.config.Task;

import java.time.LocalDate;
import java.util.Date;

@Data
public class TaskForm {

    private String name;
    private String description;
    private Date dateCreation;

    public TaskEntity toEntity(){
        TaskEntity entity = new TaskEntity();
        entity.setName(name);
        entity.setDescription(description);
        entity.setDateCreation(dateCreation);

        return entity;
    }
}
