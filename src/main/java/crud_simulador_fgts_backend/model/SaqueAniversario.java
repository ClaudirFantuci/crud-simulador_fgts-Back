package crud_simulador_fgts_backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import crud_simulador_fgts_backend.enums.FaixaSaldoFgts;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(name = "simulacaoSaqueAniversario")
public class SaqueAniversario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Positive
    private BigDecimal SaldoFgts;
    private int mesAniversario;
    private BigDecimal valorDisponivel;
    private FaixaSaldoFgts faixa;
    private LocalDateTime dataSimulacao;
}
