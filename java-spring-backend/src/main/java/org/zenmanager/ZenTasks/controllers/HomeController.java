package org.zenmanager.ZenTasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zenmanager.ZenTasks.data.UserRepository;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String displayHomepage() {
        return "index";
    }

//    @PostMapping()
//    public String toggleTheme(Principal principal) {
//        User user = userRepository.findByUsername(principal.getName());
//        user.setDarkTheme(user.isDarkTheme());
//        userRepository.save(user);
//        return "index";
//    }
}
