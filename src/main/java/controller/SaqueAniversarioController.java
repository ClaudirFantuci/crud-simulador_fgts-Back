package controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.SaqueAniversario;
import service.SaqueAniversarioService;

@RestController
@RequestMapping("/api/SaqueAniversario")
@CrossOrigin
public class SaqueAniversarioController {

    public SaqueAniversarioService service;

    @PostMapping
    public SaqueAniversario criar(@RequestBody SaqueAniversario saqueAniversario) {
        return service.criar(saqueAniversario);
    }

    @GetMapping
    public List<SaqueAniversario> buscarTodos() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public SaqueAniversario alterar(@PathVariable Long id, @RequestBody SaqueAniversario saqueAniversario) {
        return service.alterar(id, saqueAniversario);
    }

    @DeleteMapping("/{id}")
    public void exluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
