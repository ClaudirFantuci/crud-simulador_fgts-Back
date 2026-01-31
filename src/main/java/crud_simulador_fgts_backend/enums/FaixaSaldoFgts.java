package crud_simulador_fgts_backend.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FaixaSaldoFgts {
    FAIXA_1(BigDecimal.ZERO, new BigDecimal("500.00"), new BigDecimal("0.50"), BigDecimal.ZERO),
    FAIXA_2(new BigDecimal("500.01"), new BigDecimal("1000.00"), new BigDecimal("0.40"), new BigDecimal("50.00")),
    FAIXA_3(new BigDecimal("1000.01"), new BigDecimal("5000.00"), new BigDecimal("0.30"), new BigDecimal("150.00")),
    FAIXA_4(new BigDecimal("5000.01"), new BigDecimal("10000.00"), new BigDecimal("0.20"), new BigDecimal("650.00")),
    FAIXA_5(new BigDecimal("10000.01"), new BigDecimal("15000.00"), new BigDecimal("0.15"), new BigDecimal("1150.00")),
    FAIXA_6(new BigDecimal("15000.01"), new BigDecimal("20000.00"), new BigDecimal("0.10"), new BigDecimal("1900.00")),
    FAIXA_7(new BigDecimal("20000.01"), new BigDecimal("999999999.99"), new BigDecimal("0.05"),
            new BigDecimal("2900.00"));

    private final BigDecimal valorMinimo;
    private final BigDecimal valorMaximo;
    private final BigDecimal aliquota;
    private final BigDecimal parcelaAdicional;

    public static FaixaSaldoFgts obterFaixa(BigDecimal saldo) {
        for (FaixaSaldoFgts faixa : values()) {
            if (saldo.compareTo(faixa.valorMinimo) >= 0 && saldo.compareTo(faixa.valorMaximo) <= 0) {
                return faixa;
            }
        }
        throw new IllegalArgumentException("Saldo inválido: " + saldo);
    }

    public BigDecimal calcularValorSaque(BigDecimal saldo) {
        return saldo.multiply(aliquota).add(parcelaAdicional).setScale(2, RoundingMode.HALF_UP);
    }
}
