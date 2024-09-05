package com.coderscampus.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/welcome")
    public String getWelcome(Model model) {
        List<String> channels = List.of("General", "Random", "Tech");
        model.addAttribute("channels", channels);
        return "welcome";
    }

    @PostMapping("/welcome")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        User savedUser = userRepository.saveUser(user);
        return savedUser;
    }
}
