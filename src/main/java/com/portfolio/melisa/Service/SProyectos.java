package com.portfolio.melisa.Service;

import com.portfolio.melisa.Entity.Proyectos;
import com.portfolio.melisa.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
    
    // Llamar al repositorio:
    @Autowired
    RProyectos rProyectos;
    
    // Obtener la lista de proyectos:
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }
    
    // Obtener poryecto por ID:
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    // Obtener poryecto por titulo:
    public Optional<Proyectos> getByTituloProy(String tituloProy){
        return rProyectos.findByTituloProy(tituloProy);
    }
    
    // Crear proyecto:
    public void save(Proyectos proyectos){
       rProyectos.save(proyectos);
    }
    
    // Eliminar proyecto por ID:
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    // Buscar si existe proyecto por ID:
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    // Buscar si existe proyecto por titulo:
    public boolean existsByTituloProy(String tituloProy){
        return rProyectos.existsByTituloProy(tituloProy);
    }
}
