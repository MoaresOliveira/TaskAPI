package io.github.todolist.dto.form;

import io.github.todolist.enums.StatusTaskEnum;
import io.github.todolist.model.TaskEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskForm {

    private String name;
    private String description;
    private LocalDate dateCreation;
    private String status;
    private Integer index;

    public TaskEntity toEntity(){
        TaskEntity entity = new TaskEntity();
        entity.setName(name);
        entity.setDescription(description);
        entity.setDateCreation(dateCreation);
        entity.setStatus(StatusTaskEnum.valueOf(status));
        entity.setIndex(index);

        return entity;
    }
}
