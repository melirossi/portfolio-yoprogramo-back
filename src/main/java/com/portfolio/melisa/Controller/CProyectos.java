package com.portfolio.melisa.Controller;

import com.portfolio.melisa.Entity.Proyectos;
import com.portfolio.melisa.Security.Controller.Mensaje;
import com.portfolio.melisa.Service.SProyectos;
import com.portfolio.melisa.dto.dtoProyectos;
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
@RequestMapping("/proyectos")

// Connection with front:
@CrossOrigin(origins = {"https://melisa-portfolio.web.app","http://localhost:4200"})

public class CProyectos {
    
    // Llamar servicio:
    @Autowired
    SProyectos sProyectos;
    
    // Obtener lista de proyectos:
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    // Obtener proyecto por ID:
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    // Eliminar proyecto por ID:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No extiste el ID"), HttpStatus.NOT_FOUND);
        } 
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    // Crear proyecto:
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getTituloProy())){
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProyectos.existsByTituloProy(dtoproyectos.getTituloProy())){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = new Proyectos(dtoproyectos.getImagenProy(), dtoproyectos.getTituloProy(), dtoproyectos.getDescripProy(), dtoproyectos.getTecnoProy(), dtoproyectos.getFechaProy(), dtoproyectos.getUrlProy());
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);        
    }
    
    // Modificar proyecto por ID:
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        } 
        if(sProyectos.existsByTituloProy(dtoproyectos.getTituloProy()) && sProyectos.getByTituloProy(dtoproyectos.getTituloProy()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getTituloProy())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setImagenProy(dtoproyectos.getImagenProy());
        proyectos.setTituloProy(dtoproyectos.getTituloProy());
        proyectos.setDescripProy(dtoproyectos.getDescripProy());
        proyectos.setTecnoProy(dtoproyectos.getTecnoProy());
        proyectos.setFechaProy(dtoproyectos.getFechaProy());
        proyectos.setUrlProy(dtoproyectos.getUrlProy());       
       
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
