package com.FoodSpringApp.FoodSpringApp.service;

import com.FoodSpringApp.FoodSpringApp.model.Cliente;
import com.FoodSpringApp.FoodSpringApp.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }
}
