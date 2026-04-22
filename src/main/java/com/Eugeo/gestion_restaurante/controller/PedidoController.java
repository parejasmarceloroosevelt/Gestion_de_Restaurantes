package com.Eugeo.gestion_restaurante.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestionrestaurante.gestion.entity.Pedido;
import com.gestionrestaurante.gestion.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @GetMapping
    public List<Pedido> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/estado")
    public List<Pedido> findByEstado(@RequestParam String estado) {
        return service.findByEstado(estado);
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return service.create(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido) {
        return service.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
