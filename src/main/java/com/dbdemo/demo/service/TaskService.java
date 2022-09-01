package com.dbdemo.demo.service;

import com.dbdemo.demo.dto.TaskDto;
import com.dbdemo.demo.entity.Task;
import com.dbdemo.demo.exception.ResourceNotFoundException;
import com.dbdemo.demo.repo.TaskRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    TaskRepo taskRepo;
    ModelMapper modelMapper;

    public TaskService(TaskRepo taskRepo, ModelMapper modelMapper) {
        this.taskRepo = taskRepo;
        this.modelMapper = modelMapper;
    }

    // get All Tasks
    public List<TaskDto> getAllTasks() {
        List<TaskDto> list;

        list = taskRepo.findAll().stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
        return list;
    }

    // get single task
    public TaskDto getTaskById(Long Id) {
        return modelMapper.map(taskRepo.findById(Id), TaskDto.class);
    }

    //create Task
    public TaskDto createTask(TaskDto taskDto) {
        return modelMapper.map(
                taskRepo.save(modelMapper.map(taskDto, Task.class))
                , TaskDto.class);
    }

    public TaskDto updateTask(Long id, TaskDto taskDto) {
        if (taskRepo.existsById(id)) {
           // Task taskToUpdate = modelMapper.map(taskDto, Task.class);
            Task taskToUpdate = taskRepo.findById(id).get();
            taskRepo.save(taskToUpdate);
            return modelMapper.map(taskToUpdate, TaskDto.class);
        } else {
            throw new ResourceNotFoundException("Task not present");
        }
    }

}
