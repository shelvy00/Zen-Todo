package org.zenmanager.ZenTasks.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.zenmanager.ZenTasks.data.TaskRepository;
import org.zenmanager.ZenTasks.data.UserRepository;
import org.zenmanager.ZenTasks.models.Task;
import org.zenmanager.ZenTasks.models.TaskProgress;
import org.zenmanager.ZenTasks.models.User;

import java.time.LocalDate;
import java.util.Optional;

//@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/task")
public class TaskController {

    @Autowired
    private AuthenticationController authenticationController;


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("add")
    public String displayAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("enums", TaskProgress.values());
        return "add";
    }

    @PostMapping("add")
    public String processAddTaskForm (@ModelAttribute @Valid Task newTask, Model model, @NotNull Errors errors, HttpSession session){
        if(errors.hasErrors()) {
            model.addAttribute("task", "Add Task");
            LocalDate startDate = newTask.getStartDate();
            LocalDate dueDate = newTask.getDueDate();
            return "add";
        }

        Optional<User> result = userRepository.findById(authenticationController.getUserFromSession(session).getId());
        if (result.isPresent()) {
            User user = result.get();
            newTask.setUser(user);
        }

        taskRepository.save(newTask);
        return "redirect:/list";
    }

    @GetMapping("delete/{taskId}")
    public String displayDeleteTask(Model model, @PathVariable int taskId){
        model.addAttribute("task", "Delete Task");
        model.addAttribute("task", taskRepository.findById(taskId));
        return"delete";
    }


    @PostMapping("delete")
    public String processDeleteTaskForm(Integer id, String name, String description, String startDate, String dueDate){
        Task deleteTask = taskRepository.findById(id).get();
        deleteTask.setName(name);
        deleteTask.setDescription(description);
        deleteTask.setStartDate(LocalDate.parse(startDate));
        deleteTask.setDueDate(LocalDate.parse(dueDate));
        taskRepository.deleteById(id);

        return"redirect:/list";
    }

    @GetMapping("edit/{taskId}")
    public String displayEditForm(Model model , @PathVariable int taskId){
        model.addAttribute("task", "Edit Task");
        model.addAttribute("task", taskRepository.findById(taskId));
        return "edit";
    }

    @PostMapping("edit")
    public String processEditForm(Integer id, String name, String description, String startDate, String dueDate, String taskProgressEnum) {
        Task task = taskRepository.findById(id).get();
        task.setName(name);
        task.setDescription(description);
        task.setStartDate(LocalDate.parse(startDate));
        task.setDueDate(LocalDate.parse(dueDate));
        System.out.println(taskProgressEnum);
        task.setTaskProgressEnum(TaskProgress.valueOf(taskProgressEnum));
        taskRepository.save(task);
        return "redirect:/list";
    }
}