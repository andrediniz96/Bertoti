package com.DinizAndre.Coffee.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.DinizAndre.Coffee.model.Coffee;
import com.DinizAndre.Coffee.repository.CoffeeRepository;

@Service
public class CoffeeService {

    private final CoffeeRepository repository;

    public CoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }

    // Listar todos os cafés
    public List<Coffee> listarTodos() {
        return repository.findAll();
    }

    // Buscar café pelo ID
    public Coffee buscarPorId(Long id) {
        Optional<Coffee> optionalCoffee = repository.findById(id);
        return optionalCoffee.orElseThrow(() -> new RuntimeException("Café não encontrado com ID: " + id));
    }

    // Salvar ou atualizar café
    public Coffee salvar(Coffee coffee) {
        return repository.save(coffee);
    }

    // Deletar café pelo ID (opcional, caso queira)
    public void deletar(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Café não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}
