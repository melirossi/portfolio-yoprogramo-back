package com.portfolio.melisa.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    // Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imageEdu;
    private String cursoEdu;
    private String fechaEdu;
    private String instiEdu;
    private String descrpEdu;

    // Constructores:
    public Educacion() {
    }

    public Educacion(String imageEdu, String cursoEdu, String fechaEdu, String instiEdu, String descrpEdu) {
        this.imageEdu = imageEdu;
        this.cursoEdu = cursoEdu;
        this.fechaEdu = fechaEdu;
        this.instiEdu = instiEdu;
        this.descrpEdu = descrpEdu;
    }

    // Getters y Setters:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
