package com.anrdez.taskservice.controller;

import com.anrdez.taskservice.model.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author anrdez
 * @project task-service
 */
@RequestMapping(value = "/task")
public interface TaskApi {

    @PostMapping
    ResponseEntity<TaskDto> createTask(@RequestBody TaskDto dto);

    ResponseEntity<List<TaskDto>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<TaskDto> getById(@PathVariable("id") Long id);

    @PutMapping
    ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable("id") Long id);

}
