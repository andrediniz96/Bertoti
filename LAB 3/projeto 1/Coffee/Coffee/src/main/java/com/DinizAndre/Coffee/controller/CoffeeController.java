package com.DinizAndre.Coffee.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.DinizAndre.Coffee.model.Coffee;
import com.DinizAndre.Coffee.service.CoffeeService;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    private final CoffeeService service;

    public CoffeeController(CoffeeService service) {
        this.service = service;
    }

    // Listar todos os cafés
    @GetMapping
    public List<Coffee> listar() {
        return service.listarTodos();
    }

    // Buscar café pelo id
    @GetMapping("/{id}")
    public Coffee buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Criar novo café
    @PostMapping
    public Coffee criar(@RequestBody Coffee coffee) {
        return service.salvar(coffee);
    }

    // Atualizar café existente
    @PutMapping("/{id}")
    public Coffee atualizar(@PathVariable Long id, @RequestBody Coffee coffee) {
        coffee.setId(id);
        return service.salvar(coffee);
    }

    // Deletar café
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
