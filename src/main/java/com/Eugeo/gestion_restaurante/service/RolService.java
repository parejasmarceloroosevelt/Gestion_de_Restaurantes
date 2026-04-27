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

    public Rol findById(Long id){
        return repository.findById(id)
            .orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Rol no encontrado"));
    }

    public Rol create(Rol rol){
        if (rol.getId() != null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El rol ya tiene ID"
            );
        }
        return repository.save(rol);
    }

    public Rol update(Long id, Rol rol){
        Rol aux = findById(id);
        aux.setNombre(rol.getNombre());
        return repository.save(aux);
    }

    public void delete(Long id){
        Rol rol = findById(id);
        repository.deleteById(rol.getId());
    }
}
