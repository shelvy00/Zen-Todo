package org.zenmanager.ZenTasks.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zenmanager.ZenTasks.data.TaskRepository;
import org.zenmanager.ZenTasks.data.UserRepository;
import org.zenmanager.ZenTasks.models.User;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(value = "profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AuthenticationController authenticationController;



    @GetMapping("")
    public String Profile(Model model, HttpSession session, String username, String firstName, String profilePicture) {

        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("first name", user.getFirstName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("profilePicture", profilePicture);
        model.addAttribute("user", user);

        //list all tasks
        model.addAttribute("tasks", taskRepository.findAll());

        return "profile";
    }


    @GetMapping("picture")
    public String displayChooseProfilePicture(Model model, User user) {
        model.addAttribute("profilePicture", "Edit Profile Picture");
        return "picture";
    }

    @PostMapping("picture")
    public String processChooseProfilePicture(HttpSession session, String profilePicture) {
        User user = authenticationController.getUserFromSession(session);
        user.setProfilePicture(profilePicture);
        userRepository.save(user);
        return "redirect:/profile";
    }

    @PostMapping("update-theme")
    public String updateTheme(HttpSession session, @RequestParam boolean darkTheme){
        User user = authenticationController.getUserFromSession(session);
        user.setDarkTheme(darkTheme);
        userRepository.save(user);
        return "redirect:/profile";
    }

}
