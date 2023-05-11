package com.portfolio.melisa.Service;

import com.portfolio.melisa.Entity.HabilidadesDuras;
import com.portfolio.melisa.Repository.RHabilidadesDuras;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SHabilidadesDuras {
    
    // Llamar repositorio:
    @Autowired
    RHabilidadesDuras rHabilidadesDuras;
    
    // Ver lista de habilidades duras
    public List<HabilidadesDuras> list(){
        return rHabilidadesDuras.findAll();
    }
    
    // Obtener habilidad dura por ID:
    public Optional<HabilidadesDuras> getOne(int id){
        return rHabilidadesDuras.findById(id);
    }
    
    // Obtener habilidad dura por nombre:
    public Optional<HabilidadesDuras> getByNombreHD(String nombreHD){
        return rHabilidadesDuras.findByNombreHD(nombreHD);
    }
    
    // Crear habilidad dura:
    public void save(HabilidadesDuras habilidadesDuras){
       rHabilidadesDuras.save(habilidadesDuras);
    }
    
    // Eliminar habilidad dura por ID:
    public void delete(int id){
        rHabilidadesDuras.deleteById(id);
    }
    
    // Buscar si existe habilidad dura por ID:
    public boolean existsById(int id){
        return rHabilidadesDuras.existsById(id);
    }
    
    // Buscar si existe habilidad dura por nombre:
    public boolean existsByNombreHD(String nombreHD){
        return rHabilidadesDuras.existsByNombreHD(nombreHD);
    }
}
