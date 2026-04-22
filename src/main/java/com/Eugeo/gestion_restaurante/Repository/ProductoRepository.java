package com.Eugeo.gestion_restaurante.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eugeo.gestion_restaurante.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long>{
    
    List<Producto> findByTipo(String tipo);

    List<Producto> findByStockLessThan(Integer stock);
}

