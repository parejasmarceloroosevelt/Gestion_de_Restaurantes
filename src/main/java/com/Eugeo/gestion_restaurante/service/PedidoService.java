package com.Eugeo.gestion_restaurante.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gestionrestaurante.gestion.entity.Pedido;
import com.gestionrestaurante.gestion.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pedido no encontrado"));
    }

    public List<Pedido> findByEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public Pedido create(Pedido pedido) {
        if (pedido.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El pedido ya tiene ID");
        }
        pedido.setFecha(LocalDateTime.now());
        return repository.save(pedido);
    }

    public Pedido update(Long id, Pedido pedido) {
        Pedido aux = findById(id);
        aux.setEstado(pedido.getEstado());
        aux.setTotal(pedido.getTotal());
        aux.setMesa(pedido.getMesa());
        aux.setUsuario(pedido.getUsuario());
        return repository.save(aux);
    }

    public void delete(Long id) {
        Pedido pedido = findById(id);
        repository.deleteById(pedido.getId());
    }
}
