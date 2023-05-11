package com.portfolio.melisa.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadesDuras {
    
    
    // Atributos: 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHD;

    // Constructores:
    
    public HabilidadesDuras() {
    }

    public HabilidadesDuras(String nombreHD) {
        this.nombreHD = nombreHD;
    }

    // Getters y Setters:
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHD() {
        return nombreHD;
    }

    public void setNombreHD(String nombreHD) {
        this.nombreHD = nombreHD;
    }    
    
}
