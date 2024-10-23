package com.FoodSpringApp.FoodSpringApp.Model;
 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 id	int(11) autoincremento
nombre	varchar(100)
apellidos	varchar(100)
email	varchar(100)
telefono	int(15)
direccion	varchar(255)
 */

@Entity 
public class Cliente {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // es auntoincrento pero  tiene getter
 
    private String nombre;  //	varchar(100)
    private String apellidos;   //	varchar(100)
    private String email;	//varchar(100)
    private int telefono; 	//int(15)
    private String direccion;	 //varchar

    
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getEmail() {
        return email;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
 
    
  
}
