package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/firstview")
    public String returnFirstView(Model vModel) {
        vModel.addAttribute("name", "Nia");
        return "first-view";
    }
    @GetMapping("/city")
    public String returnSearchForm() {
        return "city";
    }

    @PostMapping("/city")
    public String returnSearchResults(@RequestParam String query, Model vModel) {
        vModel.addAttribute("city", query);
        return "city-results";
    }
}
