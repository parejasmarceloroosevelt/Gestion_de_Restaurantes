package com.gestionrestaurante.gestion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionrestaurante.gestion.entity.Rol;
import com.gestionrestaurante.gestion.service.RolService;

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

    @GetMapping("/{id}")
    public Rol findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol){
        return service.create(rol);
    }

    @PutMapping("/{id}")
    public Rol update(@PathVariable Long id,@RequestBody Rol rol){
        return service.update(id, rol);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
