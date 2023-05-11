package com.portfolio.melisa.Controller;

import com.portfolio.melisa.Entity.HabilidadesBlandas;
import com.portfolio.melisa.Security.Controller.Mensaje;
import com.portfolio.melisa.Service.SHabilidadesBlandas;
import com.portfolio.melisa.dto.dtoHabilidadesBlandas;
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
@RequestMapping("/habblandas")

// Connection with front:
@CrossOrigin(origins = {"https://melisa-portfolio.web.app","http://localhost:4200"})

public class CHabilidadesBlandas {
    
    // Llamar servicio:
    @Autowired
    SHabilidadesBlandas sHabilidadesBlandas;
    
    // Obtener lista de habilidades blandas:
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesBlandas>> list(){
        List<HabilidadesBlandas> list = sHabilidadesBlandas.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    // Obtener habilidad blanda por ID:
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesBlandas> getById(@PathVariable("id") int id){
        if(!sHabilidadesBlandas.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.BAD_REQUEST);
        }
        HabilidadesBlandas habilidadesBlandas = sHabilidadesBlandas.getOne(id).get();
        return new ResponseEntity(habilidadesBlandas, HttpStatus.OK);
    }
    
    // Eliminar habilidad blanda por ID:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHabilidadesBlandas.existsById(id)){
            return new ResponseEntity(new Mensaje("No extiste el ID"), HttpStatus.NOT_FOUND);
        } 
        sHabilidadesBlandas.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Blanda eliminada"), HttpStatus.OK);
    }
    
    // Crear habilidad blanda:
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody dtoHabilidadesBlandas dtohabilidadesblandas){
        if(StringUtils.isBlank(dtohabilidadesblandas.getNombreHB())){
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHabilidadesBlandas.existsByNombreHB(dtohabilidadesblandas.getNombreHB())){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        HabilidadesBlandas habilidadesBlandas = new HabilidadesBlandas(dtohabilidadesblandas.getNombreHB(), dtohabilidadesblandas.getDescripHB());
        sHabilidadesBlandas.save(habilidadesBlandas);
        return new ResponseEntity(new Mensaje("Habilidad Blanda creada"), HttpStatus.OK);        
    }
    
    // Modificar habilidad blanda por ID:
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidadesBlandas dtohabilidadesblandas){
        if(!sHabilidadesBlandas.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        } 
        if(sHabilidadesBlandas.existsByNombreHB(dtohabilidadesblandas.getNombreHB()) && sHabilidadesBlandas.getByNombreHB(dtohabilidadesblandas.getNombreHB()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohabilidadesblandas.getNombreHB())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        HabilidadesBlandas habilidadesBlandas = sHabilidadesBlandas.getOne(id).get();
        habilidadesBlandas.setNombreHB(dtohabilidadesblandas.getNombreHB());
        habilidadesBlandas.setDescripHB(dtohabilidadesblandas.getDescripHB());
        
        sHabilidadesBlandas.save(habilidadesBlandas);
        
        return new ResponseEntity(new Mensaje("Habilidad Blanda actualizada"), HttpStatus.OK);
    }
    
}
