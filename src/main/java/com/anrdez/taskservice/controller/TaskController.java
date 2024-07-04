package com.anrdez.taskservice.controller;

import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.service.TaskService;
import com.anrdez.taskservice.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

/**
 * @author anrdez
 * @project task-service
 * <p>
 * Implementation of TaskApi interface.
 */
@Controller
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<TaskDto> createTask(TaskDto dto) {

        if (Objects.isNull(dto)) {
            throw new IllegalArgumentException(Constants.DTO_NOTNULL);
        }

        TaskDto createdTask = taskService.createTask(dto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TaskDto>> getAll() {

        List<TaskDto> tasks = taskService.getAll();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<TaskDto> getById(Long id) {
        try {
            TaskDto task = taskService.getTaskById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<TaskDto> updateTask(TaskDto dto) {

        if (Objects.isNull(dto)) {
            throw new IllegalArgumentException(Constants.DTO_NOTNULL);
        }
        TaskDto updatedTask = taskService.updateTask(dto);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTask(Long id) {

        try {
            taskService.deleteTaskById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
