package com.portfolio.melisa.Service;

import com.portfolio.melisa.Entity.Idiomas;
import com.portfolio.melisa.Repository.RIdiomas;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SIdiomas {
    
    // Llamar repositorio:
    @Autowired
    RIdiomas rIdiomas;
    
    // Ver lista de idiomas:
    public List<Idiomas> list(){
        return rIdiomas.findAll();
    }
    
    // Obtener un idioma por ID:
    public Optional<Idiomas> getOne(int id){
        return rIdiomas.findById(id);
    }
    
    // Obtener un idioma por nombre:
    public Optional<Idiomas> getByNombreI(String nombreI){
        return rIdiomas.findByNombreI(nombreI);
    }
    
    // Crear un idioma
    public void save(Idiomas idiomas){
       rIdiomas.save(idiomas);
    }
    
    // Eliminar un idioma por ID:
    public void delete(int id){
        rIdiomas.deleteById(id);
    }
    
    // Buscar si existe un idioma por ID:
    public boolean existsById(int id){
        return rIdiomas.existsById(id);
    }
    
    // Buscar si existe un idioma por nombre:
    public boolean existsByNombreI(String nombreI){
        return rIdiomas.existsByNombreI(nombreI);
    }
}
