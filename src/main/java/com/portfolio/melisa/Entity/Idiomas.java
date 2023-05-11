package com.portfolio.melisa.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Idiomas {
    
    // Atributos:
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreI;
    private String descripI;

    // Constructores: 
    
    public Idiomas() {
    }

    public Idiomas(String nombreI, String descripI) {
        this.nombreI = nombreI;
        this.descripI = descripI;
    }

    // Getters y Setters:
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public String getDescripI() {
        return descripI;
    }

    public void setDescripI(String descripI) {
        this.descripI = descripI;
    }
    
    
}
