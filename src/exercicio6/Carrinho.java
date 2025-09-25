package exercicio6;

import exercicio6.modelo.Dinheiro;
import exercicio6.modelo.ItemCarrinho;
import exercicio6.modelo.Moeda;
import exercicio6.modelo.Produto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public final class Carrinho {

    private final List<ItemCarrinho> itens;
    private final BigDecimal percentualDesconto;

    private static final BigDecimal LIMITE_MAXIMO_CUPOM = new BigDecimal("0.30");
    private static final Moeda MOEDA_PADRAO = Moeda.BRL;

    private Carrinho(List<ItemCarrinho> itens, BigDecimal percentualDesconto) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.percentualDesconto = percentualDesconto.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static Carrinho criarVazio() {
        return new Carrinho(List.of(), BigDecimal.ZERO);
    }

    // --- Operações que retornam um NOVO Carrinho ---

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva para adicionar.");
        }

        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        Optional<ItemCarrinho> itemExistente = novaLista.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst();

        if (itemExistente.isPresent()) {
            ItemCarrinho itemVelho = itemExistente.get();
            ItemCarrinho itemNovo = new ItemCarrinho(produto, itemVelho.getQuantidade() + quantidade);
            novaLista.remove(itemVelho);
            novaLista.add(itemNovo);
        } else {
            novaLista.add(new ItemCarrinho(produto, quantidade));
        }

        return new Carrinho(novaLista, this.percentualDesconto);
    }

    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novaLista = this.itens.stream()
                .filter(item -> !item.getProduto().equals(produto))
                .toList();

        return new Carrinho(novaLista, this.percentualDesconto);
    }

    public Carrinho aplicarCupom(BigDecimal percentual) {
        // Validação: Limitar cupons a 30%
        if (percentual.compareTo(LIMITE_MAXIMO_CUPOM) > 0) {
            throw new IllegalArgumentException("O cupom excede o limite máximo de 30%.");
        }
        if (percentual.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O percentual de desconto não pode ser negativo.");
        }

        return new Carrinho(this.itens, percentual);
    }

    // --- Cálculos (CORRIGIDOS) ---

    public Dinheiro getSubtotal() {
        BigDecimal soma = this.itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .map(Dinheiro::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Dinheiro.of(soma, MOEDA_PADRAO);
    }

    public Dinheiro getDescontoTotal() {
        if (percentualDesconto.compareTo(BigDecimal.ZERO) == 0) {
            return Dinheiro.of(BigDecimal.ZERO, MOEDA_PADRAO);
        }

        Dinheiro subtotal = getSubtotal();

        // CORREÇÃO: Aplica o desconto ao subtotal para obter o valor FINAL
        Dinheiro totalComDesconto = subtotal.aplicarDesconto(percentualDesconto);

        // O valor do desconto é a diferença entre o subtotal e o total com desconto
        return subtotal.subtrair(totalComDesconto);
    }

    public Dinheiro getTotalFinal() {
        // CORREÇÃO: Usa o método que calcula o valor com desconto
        Dinheiro subtotal = getSubtotal();

        return subtotal.aplicarDesconto(percentualDesconto);
    }

    // --- Visualização ---

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--- CARRINHO ATUAL ---\n");
        if (itens.isEmpty()) {
            sb.append("Carrinho vazio.\n");
        } else {
            itens.forEach(item -> sb.append("- ").append(item).append("\n"));
        }
        sb.append("----------------------\n");
        sb.append(String.format("Subtotal: %s\n", getSubtotal()));
        sb.append(String.format("Desconto (%.2f%%): %s\n", percentualDesconto.multiply(new BigDecimal("100")), getDescontoTotal()));
        sb.append(String.format("Total Final: %s\n", getTotalFinal()));
        return sb.toString();
    }
}