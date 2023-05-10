package com.portfolio.melisa.dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidadesDuras {
    
    // Atributos:
    @NotBlank
    private String nombreHD;

    // Constructores:
    public dtoHabilidadesDuras() {
    }

    public dtoHabilidadesDuras(String nombreHD) {
        this.nombreHD = nombreHD;
    }

    // Getters and Setters:
    public String getNombreHD() {
        return nombreHD;
    }

    public void setNombreHD(String nombreHD) {
        this.nombreHD = nombreHD;
    }
    
    
}
