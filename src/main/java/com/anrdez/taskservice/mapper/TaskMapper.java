package com.anrdez.taskservice.mapper;

import com.anrdez.taskservice.model.dto.TaskDto;
import com.anrdez.taskservice.model.entity.Task;

/**
 * @author anrdez
 * @project task-service
 */
public class TaskMapper {


    public static TaskDto EntityToDto(Task entity) {

        return TaskDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .creationDate(entity.getCreationDate())
                .build();
    }


    public static Task DtoToEntity(TaskDto dto) {

        return Task.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .creationDate(dto.getCreationDate())
                .build();
    }


}
