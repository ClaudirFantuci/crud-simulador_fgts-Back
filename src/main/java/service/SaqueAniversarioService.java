package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.SaqueAniversario;
import repository.SaqueAniversarioRepository;

@Service
public class SaqueAniversarioService {

    @Autowired
    SaqueAniversarioRepository repository;

    public SaqueAniversario criar(SaqueAniversario saqueAniversario) {

        return repository.save(saqueAniversario);
    }

    public SaqueAniversario alterar(Long id, SaqueAniversario dados) {
        SaqueAniversario saqueSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrada"));

        saqueSalvo.setNome(dados.getNome());
        saqueSalvo.setSaldoFgts(dados.getSaldoFgts());
        saqueSalvo.setMesAniversario(dados.getMesAniversario());
        saqueSalvo.setDataSimulacao(dados.getDataSimulacao());
        return repository.save(saqueSalvo);
    }

    public void excluir(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrada")));
    }

    public List<SaqueAniversario> listarTodos() {
        return repository.findAllByOrderByIdDesc();
    }
}
