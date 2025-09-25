package exercicio7;

import java.util.Optional;

public class Principal {
    public static void main(String[] args) {
        // --- Repositório de Produto ---
        System.out.println("--- Repositório de Produto ---");
        IRepository<Produto, Integer> produtoRepository = new InMemoryRepository<>();

        Produto produto1 = new Produto(1, "Caneta", 2.50);
        Produto produto2 = new Produto(2, "Caderno", 15.00);

        produtoRepository.salvar(produto1);
        produtoRepository.salvar(produto2);

        System.out.println("Produtos no repositório:");
        produtoRepository.listarTodos().forEach(System.out::println);

        Optional<Produto> produtoEncontrado = produtoRepository.buscarPorId(1);
        produtoEncontrado.ifPresent(p -> System.out.println("\nProduto encontrado: " + p));

        try {
            System.out.println("\nRemovendo produto com ID 2...");
            produtoRepository.remover(2);
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Produtos no repositório após remoção:");
        produtoRepository.listarTodos().forEach(System.out::println);

        // Tentativa de remover um produto que não existe para testar a exceção
        try {
            System.out.println("\nTentando remover produto com ID 99...");
            produtoRepository.remover(99);
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(e.getMessage());
        }

        // --- Repositório de Funcionário ---
        System.out.println("\n--- Repositório de Funcionário ---");
        IRepository<Funcionario, String> funcionarioRepository = new InMemoryRepository<>();

        Funcionario f1 = new Funcionario("A101", "Maria Silva", "Gerente");
        Funcionario f2 = new Funcionario("B202", "João Santos", "Analista");

        funcionarioRepository.salvar(f1);
        funcionarioRepository.salvar(f2);

        System.out.println("Funcionários no repositório:");
        funcionarioRepository.listarTodos().forEach(System.out::println);
    }
}