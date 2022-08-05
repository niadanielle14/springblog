package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;
=======

import java.util.Random;

>>>>>>> jpa
@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String diceRollGuess() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String diceRollResults(@PathVariable int guess, Model vModel) {
        Random rn = new Random();
        int roll = rn.nextInt(6) + 1;
        vModel.addAttribute("roll", roll);
        vModel.addAttribute("guess", guess);
<<<<<<< HEAD
        return "class-exercises/roll-results";
=======
        return "roll-results";
>>>>>>> jpa
    }
}

