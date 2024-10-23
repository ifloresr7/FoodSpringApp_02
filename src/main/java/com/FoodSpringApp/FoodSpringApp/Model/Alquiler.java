package com.FoodSpringApp.FoodSpringApp.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // es auntoincrento pero  tiene getter no setter

    private int clienteId;
    private int vehiculoId;  
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    private double precio;


    
    public int getId() {
        return id;
    }
    public int getClienteId() {
        return clienteId;
    }
    public int getVehiculoId() {
        return vehiculoId;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }


        
     
    

    
}
