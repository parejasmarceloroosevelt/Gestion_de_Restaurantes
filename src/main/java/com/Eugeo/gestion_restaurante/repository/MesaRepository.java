package com.Eugeo.gestion_restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eugeo.gestion_restaurante.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{

    List<Mesa> findByEstado(String estado);
    
}
