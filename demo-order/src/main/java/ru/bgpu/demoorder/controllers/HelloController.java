package ru.bgpu.demoorder.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(path = "/{name}",method = RequestMethod.GET)
    public String hello(@PathVariable(name = "name") String name) {
        return "Привет "+name+"!";
    }
}
