package com.example.taskmangement.service;

import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmangement.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Iterable<Task> findAll(){
		return taskRepository.findAll();
	}
	public Task save(Task task){
		return taskRepository.save(task);
	}
	public void deleteById(Long id){
		taskRepository.deleteById(id);
	}
	public Task findById(Long id){
		return taskRepository.findById(id).orElse(null);
	}
}
