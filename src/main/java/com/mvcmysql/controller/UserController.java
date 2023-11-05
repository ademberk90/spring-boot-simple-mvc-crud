package com.mvcmysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvcmysql.entity.User;
import com.mvcmysql.services.UserService;

@Controller
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "homepage";
    }

    @GetMapping("/add-user")
    public String getAddUserPage(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/"; 
    }

    @GetMapping("/update-user")
    public String updateUser(Model model, @RequestParam("userId") Integer userId){
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "addUser";
    }

     @GetMapping("/delete-user")
    public String deleteUser(@RequestParam("userId") Integer userId){
        userService.deleteById(userId);
        return "redirect:/"; 
    }
}
