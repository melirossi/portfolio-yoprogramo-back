package com.portfolio.melisa.Service;

import com.portfolio.melisa.Entity.Persona;
import com.portfolio.melisa.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpPersonaService {
    
    // Llamar repositorio:
    @Autowired 
    IPersonaRepository ipersonaRepository;
    
    // Obtener lista de personas:
    public List<Persona> list(){
        return ipersonaRepository.findAll();
    }
    
    // Obtener una persona por ID:
    public Optional<Persona> getOne(int id){
        return ipersonaRepository.findById(id);
    }
    
    // Encontrar a una persona por su nombre:
    public Optional<Persona> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }
    
    // Crear una persona:
    public void save(Persona persona){
        ipersonaRepository.save(persona);
    }
    
    // Eliminar una persona por ID:
    public void delete(int id){
        ipersonaRepository.deleteById(id);
    }
    
    // Ver si una persona existe por ID:
    public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
    }
    
    // Ver si una persona existe por nombre:
    public boolean existsByNombre(String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }
}
