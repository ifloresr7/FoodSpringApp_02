package com.FoodSpringApp.FoodSpringApp.Service;

import com.FoodSpringApp.FoodSpringApp.Model.Alquiler;
import com.FoodSpringApp.FoodSpringApp.Repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerService {
    @Autowired
    private static AlquilerRepository alquilerRepository;
    public static List<Alquiler> obtenerTodosAlquileres() {
        return alquilerRepository.findAll();
    }
}