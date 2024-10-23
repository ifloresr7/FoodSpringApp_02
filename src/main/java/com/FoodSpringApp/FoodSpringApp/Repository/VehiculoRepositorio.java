package com.FoodSpringApp.FoodSpringApp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodSpringApp.FoodSpringApp.Model.Vehiculo;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {
    // Puedes agregar métodos de consulta personalizados aquí si es necesario
    
}
