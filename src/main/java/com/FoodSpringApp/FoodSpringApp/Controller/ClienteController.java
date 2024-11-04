package com.FoodSpringApp.FoodSpringApp.Controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.FoodSpringApp.FoodSpringApp.Model.Cliente;
import com.FoodSpringApp.FoodSpringApp.Service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Mostrar formulario de creación de cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formularioCrearCliente"; // Nombre de la plantilla Thymeleaf
    }

    // Guardar el cliente enviado desde el formulario y redirigir a la lista de clientes
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente); // Guardar el cliente en la base de datos
        return "redirect:/clientes"; // Redirige a la lista de clientes
    }

    // Mostrar formulario de edición de cliente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "formularioEditarCliente"; // Nombre de la plantilla Thymeleaf para editar
    }

    // Actualizar un cliente existente y redirigir a la lista de clientes
    @PostMapping("/actualizar")
    public String actualizarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes"; // Redirige a la lista de clientes
    }

    // Eliminar un cliente y redirigir a la lista de clientes
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id) {
        clienteService.deleteById(id);
        return "redirect:/clientes"; // Redirige a la lista de clientes
    }
}