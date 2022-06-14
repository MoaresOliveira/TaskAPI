package io.github.todolist.dto.form;

import io.github.todolist.enums.StatusTaskEnum;
import io.github.todolist.model.TaskEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TaskForm {

    private String name;
    private String description;
    private Date dateCreation;
    private String status;

    public TaskEntity toEntity(){
        TaskEntity entity = new TaskEntity();
        entity.setName(name);
        entity.setDescription(description);
        entity.setDateCreation(dateCreation);
        entity.setStatus(StatusTaskEnum.valueOf(status));

        return entity;
    }
}
