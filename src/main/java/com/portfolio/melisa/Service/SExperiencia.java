package com.portfolio.melisa.Service;

import com.portfolio.melisa.Entity.Experiencia;
import com.portfolio.melisa.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    
    // Llamar repositorio:
    @Autowired
    RExperiencia rExperiencia;
    
    // Ver la lista de experiencias:
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    // Buscar experiencia por ID:
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    // Buscar experiencia por nombre de la empresa:
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);
    }
    
    // Crear experiencia:
    public void save(Experiencia expe){
        rExperiencia.save(expe);
    }
    
    // Eliminar experiencia por ID:
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    // Ver si existe experiencia por ID:
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    // Ver si existe experiencia por nombre de la empresa:
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);
    }
    
}
