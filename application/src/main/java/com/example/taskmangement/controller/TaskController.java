package com.example.taskmangement.controller;

import com.example.taskmangement.Task;
import com.example.taskmangement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("tasks", taskService.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String addTaskForm(Model model){
		model.addAttribute("task", new Task());
		return "add-task";
	}

	@PostMapping("/add")
	public String addTask(Task task){
		taskService.save(task);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editTaskForm(@PathVariable Long id, Model model){
		model.addAttribute("task", taskService.findById(id));
		return "edit-task";
	}

	@PostMapping("/edit")
	public String editTask(Task task){
		taskService.save(task);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable Long id){
		taskService.deleteById(id);
		return "redirect:/";
	}
}
