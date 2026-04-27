package com.Eugeo.gestion_restaurante.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eugeo.gestion_restaurante.Entity.Rol;
import com.Eugeo.gestion_restaurante.Service.RolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolController {
    
    private final RolService service;

    @GetMapping
    public List<Rol> findAll(){
        return service.findAll();
    }

    
}
