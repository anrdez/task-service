package com.anrdez.taskservice.repository;

import com.anrdez.taskservice.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
