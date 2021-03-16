package ru.bgpu.demoorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(path = "/{name}",method = RequestMethod.GET)
    public String hello(
            @PathVariable(name = "name") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "hello";
    }
}
