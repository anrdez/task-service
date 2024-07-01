package com.anrdez.taskservice.service;

import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.model.entity.Task;

import java.util.List;

/**
 * @author anrdez
 * @project task-service
 */

public interface TaskService {

    List<TaskDto> getAll();

    List<TaskDto> getTaskByTitle(String title);

    TaskDto createTask(TaskDto dto);

    TaskDto getTaskById(Long id);

    TaskDto updateTask(TaskDto dto);

    void deleteTaskById(Long id);
}
