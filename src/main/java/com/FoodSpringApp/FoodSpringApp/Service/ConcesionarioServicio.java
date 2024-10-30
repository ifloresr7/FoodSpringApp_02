    
package com.FoodSpringApp.FoodSpringApp.service;

import org.springframework.stereotype.Service;

@Service
public class ConcesionarioServicio {
    public String obtenerSaludo() {
        return "Hola desde el servicio del nuevo concesionario!";
    }
}
