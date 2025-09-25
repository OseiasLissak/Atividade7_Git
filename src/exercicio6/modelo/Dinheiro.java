package exercicio6.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {

    private static final int ESCALA = 2;
    private static final RoundingMode ARREDONDAMENTO = RoundingMode.HALF_EVEN;

    private final BigDecimal valor;
    private final Moeda moeda;

    private Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor monetário não pode ser negativo.");
        }

        this.valor = valor.setScale(ESCALA, ARREDONDAMENTO);
        this.moeda = Objects.requireNonNull(moeda, "A moeda não pode ser nula.");
    }

    public static Dinheiro of(BigDecimal valor, Moeda moeda) {
        return new Dinheiro(valor, moeda);
    }

    // --- Getters ---
    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    // --- Métodos de Operação (Retornam NOVO Dinheiro) ---

    public Dinheiro adicionar(Dinheiro outro) {
        if (this.moeda != outro.moeda) {
            throw new IllegalArgumentException("Não é possível somar moedas diferentes.");
        }
        BigDecimal novoValor = this.valor.add(outro.valor);
        return Dinheiro.of(novoValor, this.moeda);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        if (this.moeda != outro.moeda) {
            throw new IllegalArgumentException("Não é possível subtrair moedas diferentes.");
        }
        if (this.valor.compareTo(outro.valor) < 0) {
            throw new IllegalArgumentException("O resultado da subtração não pode ser negativo.");
        }
        BigDecimal novoValor = this.valor.subtract(outro.valor);
        return Dinheiro.of(novoValor, this.moeda);
    }

    /**
     * Aplica uma porcentagem de desconto.
     * @param percentual O percentual a aplicar (ex: 0.15).
     * @return Novo objeto Dinheiro com o valor final (valor - desconto).
     */
    public Dinheiro aplicarDesconto(BigDecimal percentual) {
        // 1. Calcula o valor do desconto: valor * percentual
        BigDecimal valorDesconto = this.valor.multiply(percentual);

        // 2. Aplica arredondamento bancário ao valor do DESCONTO
        valorDesconto = valorDesconto.setScale(ESCALA, ARREDONDAMENTO);

        // 3. Subtrai o desconto para obter o novo valor final
        BigDecimal novoValor = this.valor.subtract(valorDesconto);

        // 4. Retorna um NOVO objeto Dinheiro (imutabilidade)
        return Dinheiro.of(novoValor, this.moeda);
    }

    // --- equals/hashCode/toString ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return valor.compareTo(dinheiro.valor) == 0 && moeda == dinheiro.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return moeda.getSimbolo() + " " + valor.toPlainString();
    }
}