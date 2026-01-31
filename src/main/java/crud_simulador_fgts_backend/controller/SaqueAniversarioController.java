package crud_simulador_fgts_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud_simulador_fgts_backend.model.SaqueAniversario;
import crud_simulador_fgts_backend.service.SaqueAniversarioService;

@RestController
@RequestMapping("/api/SaqueAniversario")
@CrossOrigin
public class SaqueAniversarioController {

    @Autowired
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
