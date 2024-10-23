package com.FoodSpringApp.FoodSpringApp.Controller;


import com.FoodSpringApp.FoodSpringApp.Model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable int id, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(clienteDetails.getNombre());
            cliente.setEmail(clienteDetails.getEmail());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable int id) {
        clienteRepository.deleteById(id);
    }
}
