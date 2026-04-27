package com.Eugeo.gestion_restaurante.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Eugeo.gestion_restaurante.Service.PedidoService;
import com.Eugeo.gestion_restaurante.Entity.Pedido;

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

}
