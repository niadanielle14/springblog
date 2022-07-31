package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

// Establishes that this class is a controller
@Controller

public class HelloController {

    @GetMapping("/hello") // defines a method that should be invoked when a GET request is received for the specified URI
    @ResponseBody // tells Spring that whatever is returned from this method should be the body of our response
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/nia")
    @ResponseBody
    public String nina() {
        return "Ninatopia!";
    }

    @GetMapping("/increment/{number}")
    @ResponseBody
    public String increment(@PathVariable int number) {
        return number + " plus one = " + (number + 1) + "!";
    }
}

