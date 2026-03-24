package com.Att.Gerenciamento.de.Departamentos.controller;

import com.Att.Gerenciamento.de.Departamentos.entity.Departamento;
import com.Att.Gerenciamento.de.Departamentos.service.DepartamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public Departamento criar(@RequestBody Departamento departamento) {
        return service.salvar(departamento);
    }

    @GetMapping
    public List<Departamento> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Departamento buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}