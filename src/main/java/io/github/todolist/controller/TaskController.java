package io.github.todolist.controller;

import io.github.todolist.dto.TaskVo;
import io.github.todolist.dto.form.TaskForm;
import io.github.todolist.exception.TaskNotFoundException;
import io.github.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/new",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskVo> createTask(@RequestBody TaskForm form){
        System.out.println(form);
        TaskVo task = taskService.createTask(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping(value ="/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskVo> createTask(@RequestBody TaskForm form, @PathVariable("id")Long id){
        TaskVo task = taskService.updateTask(form, id);
        if(task != null){
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value ="/delete/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id")Long id){
        try {
            taskService.deleteTask(id);
            return ResponseEntity.status(HttpStatus.FOUND).build();
        } catch (TaskNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskVo>> getAllTasks(){
        List<TaskVo> tasks = taskService.getAllTasks();
        if(tasks.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(value ="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskVo> getTaskById(@PathVariable("id")Long id){
        TaskVo task = taskService.getTaskById(id);
        if(task == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(task);
    }

}
