package io.github.todolist.dto;

import io.github.todolist.model.TaskEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TaskVo {

    private Long id;
    private String description;

    public TaskVo(TaskEntity entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
    }

    public static List<TaskVo> toVoList(List<TaskEntity> entities){
        return entities.stream().map(TaskVo::new).collect(Collectors.toList());
    }
}
