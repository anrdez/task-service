package com.anrdez.taskservice.service;

import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.model.entity.Task;

import java.util.List;

/**
 * @author anrdez
 * @project task-service
 * <p>
 * Service interface for managing tasks.
 * Provides methods for CRUD operations and additional business logic.
 */

public interface TaskService {

    /**
     * Get all tasks.
     *
     * @return list of TaskDto
     */
    List<TaskDto> getAll();

    /**
     * Get tasks by title.
     *
     * @param title of the tasks to retrieve
     * @return list of TaskDto
     */
    List<TaskDto> getTaskByTitle(String title);

    /**
     * Create a new task.
     *
     * @param dto the task data transfer object
     * @return the created TaskDto
     */
    TaskDto createTask(TaskDto dto);

    /**
     * Get a task by its ID.
     *
     * @param id of the task to retrieve
     * @return the TaskDto
     */
    TaskDto getTaskById(Long id);

    /**
     * Update an existing task.
     *
     * @param dto the taskDto
     * @return the updated TaskDto
     */
    TaskDto updateTask(TaskDto dto);

    /**
     * Delete a task by its ID.
     *
     * @param id the ID of the task to delete
     */
    void deleteTaskById(Long id);
}
