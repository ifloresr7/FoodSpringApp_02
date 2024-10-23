package com.FoodSpringApp.FoodSpringApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * id	int(11)  es un autoincremento que  lo tratará el MySql, para poder alquilar debe existir un id asociado a un coche pero hay get()
 * color	varchar(50)
 * marca	varchar(50)
 * puertas	int(11)
 * autonomiaKm	int(11)
 * potenciaCv	int(11)
 */
@Entity
 public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marca;
    private String color;
    private int puertas;
    private int autonomiaKm;
    private int potenciaCv;


    // aunque es autoincrementeo se obtiene el id del cliente en la select
    public int getId() {
        return id;
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getPuertas() {
        return puertas;
    }
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
    public int getAutonomiaKm() {
        return autonomiaKm;
    }
    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }
    public int getPotenciaCv() {
        return potenciaCv;
    }
    public void setPotenciaCv(int potenciaCv) {
        this.potenciaCv = potenciaCv;
    }
     
  

}
