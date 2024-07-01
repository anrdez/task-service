package com.anrdez.taskservice.service;

import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.repository.TaskRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author anrdez
 * @project task-service
 */

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAll() {
        return null;
    }

    @Override
    public List<TaskDto> getTaskByTitle(String title) {
        return null;
    }

    @Override
    public TaskDto createTask(TaskDto dto) {
        return null;
    }

    @Override
    public TaskDto getTaskById(Long id) {
        return null;
    }

    @Override
    public TaskDto updateTask(TaskDto dto) {

        if (Objects.isNull(dto)) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);

    }
}
