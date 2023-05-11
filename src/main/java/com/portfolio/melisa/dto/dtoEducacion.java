package com.portfolio.melisa.dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    
    // Atributos:
    @NotBlank
    private String imageEdu;
    @NotBlank
    private String cursoEdu;
    @NotBlank
    private String fechaEdu;
    @NotBlank
    private String instiEdu;
    @NotBlank
    private String descrpEdu;

    // Constructores:
    public dtoEducacion() {
    }

    public dtoEducacion(String imageEdu, String cursoEdu, String fechaEdu, String instiEdu, String descrpEdu) {
        this.imageEdu = imageEdu;
        this.cursoEdu = cursoEdu;
        this.fechaEdu = fechaEdu;
        this.instiEdu = instiEdu;
        this.descrpEdu = descrpEdu;
    }

    // Getters and Setters:
    public String getImageEdu() {
        return imageEdu;
    }

    public void setImageEdu(String imageEdu) {
        this.imageEdu = imageEdu;
    }

    public String getCursoEdu() {
        return cursoEdu;
    }

    public void setCursoEdu(String cursoEdu) {
        this.cursoEdu = cursoEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public String getInstiEdu() {
        return instiEdu;
    }

    public void setInstiEdu(String instiEdu) {
        this.instiEdu = instiEdu;
    }

    public String getDescrpEdu() {
        return descrpEdu;
    }

    public void setDescrpEdu(String descrpEdu) {
        this.descrpEdu = descrpEdu;
    }
        
}
