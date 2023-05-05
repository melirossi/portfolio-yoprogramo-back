package com.portfolio.melisa.dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidadesDuras {
    @NotBlank
    private String nombreHD;

    public dtoHabilidadesDuras() {
    }

    public dtoHabilidadesDuras(String nombreHD) {
        this.nombreHD = nombreHD;
    }

    public String getNombreHD() {
        return nombreHD;
    }

    public void setNombreHD(String nombreHD) {
        this.nombreHD = nombreHD;
    }
    
    
}
