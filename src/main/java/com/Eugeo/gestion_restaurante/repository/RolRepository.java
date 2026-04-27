package com.Eugeo.gestion_restaurante.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eugeo.gestion_restaurante.Entity.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
}
