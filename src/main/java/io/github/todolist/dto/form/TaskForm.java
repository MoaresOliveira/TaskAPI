package io.github.todolist.dto.form;

import io.github.todolist.model.TaskEntity;
import lombok.Data;
import org.springframework.scheduling.config.Task;

@Data
public class TaskForm {

    private String description;

    public TaskEntity toEntity(){
        TaskEntity entity = new TaskEntity();
        entity.setDescription(description);

        return entity;
    }
}
