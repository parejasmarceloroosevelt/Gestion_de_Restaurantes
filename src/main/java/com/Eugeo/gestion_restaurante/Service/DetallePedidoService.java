package com.Eugeo.gestion_restaurante.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Eugeo.gestion_restaurante.Entity.DetallePedido;
import com.Eugeo.gestion_restaurante.Repository.DetallePedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetallePedidoService {
    private final DetallePedidoRepository repository;

    public List<DetallePedido> findAll() {
        return repository.findAll();
    }

    public DetallePedido findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Detalle no encontrado"));
    }

    public List<DetallePedido> findByPedido(Long pedidoId) {
        return repository.findByPedidoId(pedidoId);
    }

    public DetallePedido create(DetallePedido detalle) {
        if (detalle.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El detalle ya tiene ID");
        }
        return repository.save(detalle);
    }

    public DetallePedido update(Long id, DetallePedido detalle) {
        DetallePedido aux = findById(id);
        aux.setCantidad(detalle.getCantidad());
        aux.setSubtotal(detalle.getSubtotal());
        aux.setPedido(detalle.getPedido());
        aux.setProducto(detalle.getProducto());
        return repository.save(aux);
    }

    public void delete(Long id) {
        DetallePedido detalle = findById(id);
        repository.deleteById(detalle.getId());
    }
}