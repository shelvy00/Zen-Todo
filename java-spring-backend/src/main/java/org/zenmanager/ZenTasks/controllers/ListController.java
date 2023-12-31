package org.zenmanager.ZenTasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zenmanager.ZenTasks.data.TaskRepository;
import org.zenmanager.ZenTasks.data.UserRepository;
import org.zenmanager.ZenTasks.models.Task;

@Controller
@RequestMapping(value = "list")
public class ListController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;


    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "list";
    }

    @GetMapping("list/{taskId}")
    public String getId(Model model , @PathVariable int taskId){
        model.addAttribute("task", "task");
        model.addAttribute("task", taskRepository.findById(taskId));
        return "list";
    }

    @PostMapping("/{taskId}")
    public String email(@PathVariable int taskId) {
        Task task = taskRepository.findById(taskId).get();
//        PublishTopic.sendMessage(task.getName(),task.getDescription(),task.getStartDate().toString(),task.getDueDate().toString());
        return "redirect:/list";
    }
}

