package com.dbdemo.demo.controller;

import com.dbdemo.demo.dto.TaskDto;
import com.dbdemo.demo.entity.Task;
import com.dbdemo.demo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
        public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping("")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task){
        return ResponseEntity.ok().body(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id,@RequestBody TaskDto task){
        return ResponseEntity.ok().body(taskService.updateTask(id,task));
    }

}
