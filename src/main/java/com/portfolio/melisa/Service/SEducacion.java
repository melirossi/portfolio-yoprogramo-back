package com.portfolio.melisa.Service;

import com.portfolio.melisa.Entity.Educacion;
import com.portfolio.melisa.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    
    // Llamar repositorio:
    @Autowired
    REducacion rEducacion;
    
    // Obtener lista de educacion:
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    // Buscar una educacion por ID:
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    // Buscar una educacion por nombre del curso:
    public Optional<Educacion> getByCursoEdu(String cursoEdu){
        return rEducacion.findByCursoEdu(cursoEdu);
    }
    
    // Crear una educacion:
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    // Eliminar una educacion por ID:
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    // Buscar si existe una educacion por ID:
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    // Buscar si existe una educacion por nombre del curso:
    public boolean existsByCursoEdu(String cursoEdu){
        return rEducacion.existsByCursoEdu(cursoEdu);
    }
}
