package exercicio8.modelo;

import exercicio8.frete.CalculoFreteStrategy;
import exercicio8.frete.CepInvalidoException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa um Pedido que utiliza o Padrão Strategy para calcular seu frete.
 */
public class Pedido {

    private final Cliente cliente;
    private final BigDecimal valorTotalItens; // Simplificação: Apenas o valor total dos itens

    // A ESTRATÉGIA é um campo mutável, permitindo a "troca em tempo de execução"
    private CalculoFreteStrategy estrategiaFrete;

    public Pedido(Cliente cliente, BigDecimal valorTotalItens, CalculoFreteStrategy estrategiaInicial) {
        this.cliente = Objects.requireNonNull(cliente, "Cliente é obrigatório.");
        this.valorTotalItens = Objects.requireNonNull(valorTotalItens, "Valor total dos itens é obrigatório.");
        this.estrategiaFrete = Objects.requireNonNull(estrategiaInicial, "Estratégia inicial é obrigatória.");
    }

    // --- Injeção / Troca da Estratégia ---
    public void setEstrategiaFrete(CalculoFreteStrategy novaEstrategia) {
        this.estrategiaFrete = Objects.requireNonNull(novaEstrategia, "A estratégia não pode ser nula.");
        System.out.println("-> Estratégia de frete atualizada para: " + novaEstrategia.getClass().getSimpleName());
    }

    // --- Uso da Estratégia ---
    /**
     * Delega o cálculo do frete à estratégia atual.
     */
    public BigDecimal calcularFrete() throws CepInvalidoException {
        System.out.println("\n--- Calculando Frete para " + this.cliente.getNome() + " (CEP: " + this.cliente.getCep() + ")");
        return this.estrategiaFrete.calcular(this);
    }

    // --- Getters ---
    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValorTotalItens() {
        return valorTotalItens;
    }
}