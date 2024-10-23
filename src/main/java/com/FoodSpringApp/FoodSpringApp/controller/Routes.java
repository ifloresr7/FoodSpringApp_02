package com.FoodSpringApp.FoodSpringApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController; 


@RestController
public class Routes {
    @GetMapping("/")
    public String home() {
        return "Welcome to FoodSpringApp ¡Hola Mundo!";
    }
}