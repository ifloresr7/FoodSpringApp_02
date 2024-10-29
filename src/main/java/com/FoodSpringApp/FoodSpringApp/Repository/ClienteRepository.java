package com.FoodSpringApp.FoodSpringApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodSpringApp.FoodSpringApp.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
