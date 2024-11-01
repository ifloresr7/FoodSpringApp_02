package com.FoodSpringApp.FoodSpringApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodSpringApp.FoodSpringApp.model.Vehiculo;
import com.FoodSpringApp.FoodSpringApp.repository.VehiculoRepository;

@Service
public class VehiculoService{

    @Autowired
    private VehiculoRepository  vehiculoRepository;

    public List<Vehiculo> obtenerTodosVehiculos() {
        return vehiculoRepository.findAll();
    }
}
