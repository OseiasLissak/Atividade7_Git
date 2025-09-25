package exercicio6.modelo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa um item e sua quantidade dentro do carrinho. Imutável.
 */
public final class ItemCarrinho {

    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = Objects.requireNonNull(produto, "O produto não pode ser nulo.");

        // Validação: Quantidade deve ser > 0
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade do item deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Calcula o subtotal deste item (Preco * Quantidade).
     */
    public Dinheiro getSubtotal() {
        BigDecimal total = produto.getPrecoUnitario().getValor()
                .multiply(BigDecimal.valueOf(quantidade));

        // Retorna um novo Dinheiro para garantir escala e arredondamento corretos
        return Dinheiro.of(total, produto.getPrecoUnitario().getMoeda());
    }

    @Override
    public String toString() {
        return quantidade + "x " + produto.toString() + " = " + getSubtotal();
    }
}