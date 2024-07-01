package com.example.taskmanagement.repository;

import com.example.taskmangement.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
