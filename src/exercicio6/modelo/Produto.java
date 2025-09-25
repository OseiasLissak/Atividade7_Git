package exercicio6.modelo;

import java.util.Objects;

/**
 * Representa um produto. Imutável por padrão.
 */
public final class Produto {

    private final String id;
    private final String nome;
    private final Dinheiro precoUnitario;

    public Produto(String id, String nome, Dinheiro precoUnitario) {
        this.id = Objects.requireNonNull(id, "ID do produto é obrigatório.");
        this.nome = Objects.requireNonNull(nome, "Nome do produto é obrigatório.");
        this.precoUnitario = Objects.requireNonNull(precoUnitario, "Preço é obrigatório.");
    }

    public Dinheiro getPrecoUnitario() {
        return precoUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        // Para fins práticos, usamos o ID para definir igualdade.
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome + " (" + precoUnitario + ")";
    }
}