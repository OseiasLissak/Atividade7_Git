package exercicio8.modelo;

/**
 * Classe simples para representar um Cliente e seu CEP.
 */
public final class Cliente {
    private final String nome;
    private final String cep; // O CEP é crucial para a validação

    public Cliente(String nome, String cep) {
        this.nome = nome;
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public String getNome() {
        return nome;
    }
}