package org.zenmanager.ZenTasks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("")
public class AboutController {

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
}