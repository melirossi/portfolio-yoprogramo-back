package com.portfolio.melisa.Controller;

import com.portfolio.melisa.Entity.Educacion;
import com.portfolio.melisa.Security.Controller.Mensaje;
import com.portfolio.melisa.Service.SEducacion;
import com.portfolio.melisa.dto.dtoEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")

// Connection with front:
@CrossOrigin(origins = {"https://melisa-portfolio.web.app","http://localhost:4200"})

public class CEducacion {
    
    // Llamar servicio:
    @Autowired
    SEducacion sEducacion;
    
    // Obtener lista de educacion:
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    // Obtener educacion por ID:    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    // Eliminar educacion por ID:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    // Crear educacion:
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getCursoEdu())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByCursoEdu(dtoeducacion.getCursoEdu())){
            return new ResponseEntity(new Mensaje("Ese curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoeducacion.getImageEdu(), dtoeducacion.getCursoEdu(), dtoeducacion.getFechaEdu(), dtoeducacion.getInstiEdu(), dtoeducacion.getDescrpEdu());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }
    
    // Modificar educacion por ID:
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByCursoEdu(dtoeducacion.getCursoEdu()) && sEducacion.getByCursoEdu(dtoeducacion.getCursoEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getCursoEdu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setImageEdu(dtoeducacion.getImageEdu());
        educacion.setCursoEdu(dtoeducacion.getCursoEdu());
        educacion.setFechaEdu(dtoeducacion.getFechaEdu());
        educacion.setInstiEdu(dtoeducacion.getInstiEdu());
        educacion.setDescrpEdu(dtoeducacion.getDescrpEdu());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación modificada"), HttpStatus.OK);
    }    
}
