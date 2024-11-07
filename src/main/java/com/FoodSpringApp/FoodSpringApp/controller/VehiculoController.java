package com.FoodSpringApp.FoodSpringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FoodSpringApp.FoodSpringApp.model.Vehiculo;
import com.FoodSpringApp.FoodSpringApp.service.VehiculoService;

@Controller
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;
     
    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "formularioCrearVehiculo";  
    }

    @PostMapping("/guardar")
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        vehiculoService.save(vehiculo);  
        return "redirect:/vehiculos";  
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Vehiculo vehiculo = vehiculoService.findById(id);
        model.addAttribute("vehiculo", vehiculo);
        return "formularioEditarVehiculo"; // Nombre de la plantilla Thymeleaf para editar
    }

 
    @PostMapping("/actualizar")
    public String actualizarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        vehiculoService.save(vehiculo);
        return "redirect:/vehiculos"; 
    }

    
    @GetMapping("/eliminar/{id}")
    public String eliminarVehiculo(@PathVariable int id) {
        vehiculoService.deleteById(id);
        return "redirect:/vehiculos";  
    }
}
