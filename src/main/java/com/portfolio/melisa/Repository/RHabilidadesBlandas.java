package com.portfolio.melisa.Repository;

import com.portfolio.melisa.Entity.HabilidadesBlandas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidadesBlandas extends JpaRepository<HabilidadesBlandas, Integer>{
    public Optional<HabilidadesBlandas> findByNombreHB(String nombreHB);
    public boolean existsByNombreHB(String nombreHB);
}
