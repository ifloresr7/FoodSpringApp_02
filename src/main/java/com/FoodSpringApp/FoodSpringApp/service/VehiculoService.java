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
    /**
     * para actualizar el vehiculo
     * @param vehiculo
     * @return
     */
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }


    public Vehiculo findById(int id) {
        return vehiculoRepository.findById(id).orElse(null);
    }


    /**
     * 
     * @param id  es id o Pk id unico
     * @param autonomia_km  autonomia en km 
     * @param color  es un string para color
     * @param marca  es un string para la marca
     * @param potencia_cv es un int para la potencia
     * @param puertas es un int para las pueras
     * @param actualizaVehiculo  es el "@Sutowired" VehiculoRepository  vehiculoRepository
     * @return
     */
    public Vehiculo actualizarVehiculo(Integer id, int autonomia_km, String color, String marca, int potencia_cv, int puertas,  Vehiculo actualizaVehiculo) {

        if (vehiculoRepository.existsById(id) )  // recibe id si existe lo modifica
        {
            actualizaVehiculo.setAutonomia_km(autonomia_km); 
            actualizaVehiculo.setColor(color);
            actualizaVehiculo.setMarca(marca);
            actualizaVehiculo.setPotencia_cv(potencia_cv);
            actualizaVehiculo.setPuertas(puertas);

            return vehiculoRepository.save(actualizaVehiculo);
        }
        return null; // O lanza una excepción si no existe
    }

    /**
     * por su id si existe se borra
     * @param id
     */
    public void deleteById(int id) {
        vehiculoRepository.deleteById(id);
    }
    
}
