package com.Eugeo.gestion_restaurante.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Eugeo.gestion_restaurante.entity.Mesa;
import com.Eugeo.gestion_restaurante.repository.MesaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MesaService {
    private final MesaRepository repository;

    public List<Mesa> findAll() {
        return repository.findAll();
    }

    public Mesa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Mesa no encontrada"));
    }

    public List<Mesa> findByEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public Mesa create(Mesa mesa) {
        if (mesa.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "La mesa ya tiene ID");
        }
        return repository.save(mesa);
    }

    public Mesa update(Long id, Mesa mesa) {
        Mesa aux = findById(id);
        aux.setNumero(mesa.getNumero());
        aux.setCapacidad(mesa.getCapacidad());
        aux.setEstado(mesa.getEstado());
        return repository.save(aux);
    }

    public void delete(Long id) {
        Mesa mesa = findById(id);
        repository.deleteById(mesa.getId());
    }

}
