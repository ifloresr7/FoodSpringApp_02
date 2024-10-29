package com.FoodSpringApp.FoodSpringApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Página de Inicio");
        model.addAttribute("description", "¡Bienvenido a FoodSpringApp!");
        model.addAttribute("currentPage", "home");
        return "home";
    }
    
    @GetMapping("/vehiculos")
    public String vehiculosPage(Model model) {
        model.addAttribute("title", "Vehículos");
        model.addAttribute("description", "Aquí puedes ver todos los vehículos.");
        model.addAttribute("currentPage", "vehiculos");
        return "vehiculos";
    }
    
    @GetMapping("/clientes")
    public String clientesPage(Model model) {
        model.addAttribute("title", "Clientes");
        model.addAttribute("description", "Aquí puedes ver todos los clientes.");
        model.addAttribute("currentPage", "clientes");
        return "clientes";
    }
    
    @GetMapping("/alquileres")
    public String alquileresPage(Model model) {
        model.addAttribute("title", "Alquileres");
        model.addAttribute("description", "Aquí puedes ver todos los alquileres.");
        model.addAttribute("currentPage", "alquileres");
        return "alquileres";
    }
}
