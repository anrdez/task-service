package com.anrdez.taskservice.service;

import com.anrdez.taskservice.mapper.TaskMapper;
import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.model.entity.Task;
import com.anrdez.taskservice.repository.TaskRepository;
import com.anrdez.taskservice.util.Constants;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author anrdez
 * @project task-service
 * <p>
 * Service implementation for managing tasks.
 * Provides methods for CRUD operations and additional business logic.
 */

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAll() {
        List<Task> entityList = taskRepository.findAll();

        return entityList.stream()
                .map(TaskMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTaskByTitle(String title) {

        List<Task> entityList = taskRepository.findByTitle(title);
        return entityList.stream()
                .map(TaskMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public TaskDto createTask(TaskDto dto) {

        if (Objects.isNull(dto)) {
            throw new IllegalArgumentException(Constants.DTO_NOTNULL);
        }

        Task task = TaskMapper.DtoToEntity(dto);
        task.setCreatedAt(new Date()); // set createdAt timestamp
        Task savedTask = taskRepository.save(task);
        return TaskMapper.EntityToDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format(Constants.TASK_NOT_FOUND, id)));

        return TaskMapper.EntityToDto(task);
    }

    @Transactional
    @Override
    public TaskDto updateTask(TaskDto dto) {

        if (Objects.isNull(dto)) {
            throw new IllegalArgumentException();
        }

        Task existingTask = taskRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException(String.format(Constants.TASK_NOT_FOUND, dto.getId())));

        existingTask.setTitle(dto.getTitle());
        existingTask.setDescription(dto.getDescription());

        Task updatedTask = taskRepository.save(existingTask);

        return TaskMapper.EntityToDto(updatedTask);
    }

    @Override
    public void deleteTaskById(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException(String.format(Constants.TASK_NOT_FOUND, id));
        }
        taskRepository.deleteById(id);

    }
}
