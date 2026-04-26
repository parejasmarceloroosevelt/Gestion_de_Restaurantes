package com.gestionrestaurante.gestion.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gestionrestaurante.gestion.entity.Rol;
import com.gestionrestaurante.gestion.repository.RolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository repository;

    public List<Rol> findAll(){
        return repository.findAll();
    }

}
