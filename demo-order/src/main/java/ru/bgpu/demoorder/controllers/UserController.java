package ru.bgpu.demoorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bgpu.demoorder.models.User;
import ru.bgpu.demoorder.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> index() {
        return userService.list();
    }
}
