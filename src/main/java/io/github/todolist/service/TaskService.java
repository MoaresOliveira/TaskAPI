package io.github.todolist.service;

import io.github.todolist.dto.TaskVo;
import io.github.todolist.dto.form.TaskForm;
import io.github.todolist.exception.TaskNotFoundException;
import io.github.todolist.model.TaskEntity;
import io.github.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskVo createTask(TaskForm form){
        TaskEntity entityToSave = form.toEntity();
        TaskEntity entitySaved = taskRepository.save(entityToSave);
        return new TaskVo(entitySaved);
    }

    public TaskVo updateTask(TaskForm form, Long id){
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            TaskEntity entityToUpdate = optionalTask.get();
            entityToUpdate.setDescription(form.getDescription());
            TaskEntity entityUpdated = taskRepository.save(entityToUpdate);
            return new TaskVo(entityUpdated);
        }
        return null;
    }

    public void deleteTask(Long id) throws TaskNotFoundException {
        Optional<TaskEntity> entity = taskRepository.findById(id);
        if (entity.isPresent()){
            taskRepository.delete(entity.get());
        }else {
            throw new TaskNotFoundException("Task with ID: "+id+ " not found");
        }
    }

    public List<TaskVo> getAllTasks(){
        List<TaskEntity> entities = taskRepository.findAll();
        return TaskVo.toVoList(entities);
    }

    public TaskVo getTaskById(Long id){
        Optional<TaskEntity> optEntity = taskRepository.findById(id);
        if(optEntity.isPresent()){
            return new TaskVo(optEntity.get());
        }
        return null;
    }

}
