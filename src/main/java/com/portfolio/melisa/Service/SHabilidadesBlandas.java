package com.portfolio.melisa.Service;

import com.portfolio.melisa.Entity.HabilidadesBlandas;
import com.portfolio.melisa.Repository.RHabilidadesBlandas;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SHabilidadesBlandas {
    
    // Llamar repositorio:
    @Autowired
    RHabilidadesBlandas rHabilidadesBlandas;
    
    // Obtener lista de habilidades blandas:
    public List<HabilidadesBlandas> list(){
        return rHabilidadesBlandas.findAll();
    }
    
    // Obtener habilidad blanda por ID:
    public Optional<HabilidadesBlandas> getOne(int id){
        return rHabilidadesBlandas.findById(id);
    }
    
    // Obtener habilidad blanda por nombre:
    public Optional<HabilidadesBlandas> getByNombreHB(String nombreHB){
        return rHabilidadesBlandas.findByNombreHB(nombreHB);
    }
    
    // Crear habilidad blanda:
    public void save(HabilidadesBlandas habilidadesBlandas){
       rHabilidadesBlandas.save(habilidadesBlandas);
    }
    
    // Eliminar habilidad blanda por ID:
    public void delete(int id){
        rHabilidadesBlandas.deleteById(id);
    }
    
    // Buscar si existe habilidad blanda por ID:
    public boolean existsById(int id){
        return rHabilidadesBlandas.existsById(id);
    }
    
    // Buscar si existe habilidad blanda por nombre:
    public boolean existsByNombreHB(String nombreHB){
        return rHabilidadesBlandas.existsByNombreHB(nombreHB);
    }
    
}
