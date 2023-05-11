package com.portfolio.melisa.dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidadesBlandas {
    
    // Atributos:
    @NotBlank
    private String nombreHB;
    @NotBlank
    private String descripHB;

    // Constructores:
    public dtoHabilidadesBlandas() {
    }

    public dtoHabilidadesBlandas(String nombreHB, String descripHB) {
        this.nombreHB = nombreHB;
        this.descripHB = descripHB;
    }

    // Getters and Setters:
    public String getNombreHB() {
        return nombreHB;
    }

    public void setNombreHB(String nombreHB) {
        this.nombreHB = nombreHB;
    }

    public String getDescripHB() {
        return descripHB;
    }

    public void setDescripHB(String descripHB) {
        this.descripHB = descripHB;
    }
    
    
}
