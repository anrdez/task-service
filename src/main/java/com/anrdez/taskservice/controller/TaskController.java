package com.anrdez.taskservice.controller;

import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author anrdez
 * @project task-service
 */
@Controller
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<TaskDto> createTask(TaskDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<List<TaskDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(TaskDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteTask(Long id) {
        return null;
    }
}
