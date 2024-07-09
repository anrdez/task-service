package com.anrdez.taskservice.mapper;

import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.model.entity.Task;
import com.anrdez.taskservice.util.Constants;

import java.util.Objects;

/**
 * @author anrdez
 * @project task-service
 * <p>
 * Mapper class for converting between Task entity and TaskDto data transfer object.
 * Provides static methods for conversion with input validation.
 */
public class TaskMapper {

    /**
     * Converts Task entity to TaskDto.
     *
     * @param entity to convert
     * @return the corresponding TaskDto
     * @throws IllegalArgumentException if the entity is null
     */
    public static TaskDto EntityToDto(Task entity) {

        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException(Constants.ENTITY_NOTNULL);
        }

        return TaskDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    /**
     * Converts TaskDto to Task entity.
     *
     * @param dto the TaskDto to convert
     * @return the corresponding Task entity
     * @throws IllegalArgumentException if the dto is null
     */
    public static Task DtoToEntity(TaskDto dto) {

        if (Objects.isNull(dto)) {
            throw new IllegalArgumentException(Constants.DTO_NOTNULL);
        }

        return Task.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .createdAt(dto.getCreatedAt())
                .build();
    }


}
