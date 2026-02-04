package crud_simulador_fgts_backend.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud_simulador_fgts_backend.enums.FaixaSaldoFgts;
import crud_simulador_fgts_backend.model.SaqueAniversario;
import crud_simulador_fgts_backend.repository.SaqueAniversarioRepository;

@Service
public class SaqueAniversarioService {

    @Autowired
    SaqueAniversarioRepository repository;

    public SaqueAniversario criar(SaqueAniversario saqueAniversario) {
        FaixaSaldoFgts faixa = FaixaSaldoFgts.obterFaixa(saqueAniversario.getSaldoFgts());
        BigDecimal valor = faixa.calcularValorSaque(saqueAniversario.getSaldoFgts());
        saqueAniversario.setValorDisponivel(valor);
        saqueAniversario.setFaixa(faixa.aliquota);
        saqueAniversario.setDataSimulacao(LocalDateTime.now());
        return repository.save(saqueAniversario);
    }

    public SaqueAniversario alterar(Long id, SaqueAniversario dados) {
        SaqueAniversario saqueSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrada"));

        saqueSalvo.setNome(dados.getNome());
        saqueSalvo.setSaldoFgts(dados.getSaldoFgts());
        saqueSalvo.setMesAniversario(dados.getMesAniversario());
        return criar(saqueSalvo);
    }

    public void excluir(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrada")));
    }

    public List<SaqueAniversario> listarTodos() {
        return repository.findAll();
    }
}
