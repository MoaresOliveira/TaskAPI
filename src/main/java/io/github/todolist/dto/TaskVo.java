package io.github.todolist.dto;

import io.github.todolist.enums.StatusTaskEnum;
import io.github.todolist.model.TaskEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TaskVo {

    private Long id;
    private String name;
    private String description;
    private LocalDate dateCreation;
    private StatusTaskEnum status;
    private Integer index;

    public TaskVo(TaskEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.dateCreation = entity.getDateCreation();
        this.status = entity.getStatus();
        this.index = entity.getIndex();
    }

    public static List<TaskVo> toVoList(List<TaskEntity> entities){
        return entities.stream().map(TaskVo::new).collect(Collectors.toList());
    }
}
