package com.Eugeo.gestion_restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eugeo.gestion_restaurante.entity.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEstado(String estado); // listar pedidos por estado

    List<Pedido> findByUsuarioId(Long usuarioId); // listar pedidos por usuario

    List<Pedido> findByMesaId(Long mesaId); // listar pedido por mesa
}
