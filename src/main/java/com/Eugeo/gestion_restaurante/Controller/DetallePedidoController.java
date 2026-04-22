package com.Eugeo.gestion_restaurante.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eugeo.gestion_restaurante.Entity.DetallePedido;
import com.Eugeo.gestion_restaurante.Service.DetallePedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detalle-pedidos")
@RequiredArgsConstructor
public class DetallePedidoController {
    private final DetallePedidoService service;

    @GetMapping
    public List<DetallePedido> findAll() {
        return service.findAll();
    }
}
