package exercicio6;

import exercicio6.modelo.Dinheiro;
import exercicio6.modelo.Moeda;
import exercicio6.modelo.Produto;
import java.math.BigDecimal;

public class SimuladorCarrinho {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("EXERCÍCIO 6: CARRINHO DE COMPRAS IMUTÁVEL");
        System.out.println("=================================================");

        // 1. Definição de Produtos
        Dinheiro precoNotebook = Dinheiro.of(new BigDecimal("2500.50"), Moeda.BRL);
        Dinheiro precoMouse = Dinheiro.of(new BigDecimal("50.01"), Moeda.BRL);
        Dinheiro precoCabo = Dinheiro.of(new BigDecimal("10.99"), Moeda.BRL);

        Produto notebook = new Produto("N001", "Notebook XPro", precoNotebook);
        Produto mouse = new Produto("M001", "Mouse Óptico", precoMouse);
        Produto cabo = new Produto("C001", "Cabo HDMI 2m", precoCabo);

        // 2. Criação e Adição de Itens (Cria novos carrinhos)
        Carrinho carrinhoVazio = Carrinho.criarVazio();

        Carrinho carrinho1 = carrinhoVazio.adicionarItem(notebook, 1);
        Carrinho carrinho2 = carrinho1.adicionarItem(mouse, 2);
        Carrinho carrinho3 = carrinho2.adicionarItem(cabo, 5);
        Carrinho carrinho4 = carrinho3.adicionarItem(notebook, 1); // Soma a quantidade do notebook

        System.out.println("\n[Passo 3] Carrinho Final Antes do Cupom (Carrinho 4):");
        System.out.println(carrinho4);

        // 4. Aplicação de Cupom de 15% (Cria Carrinho 5)
        BigDecimal desconto15Porcento = new BigDecimal("0.15");
        Carrinho carrinho5 = carrinho4.aplicarCupom(desconto15Porcento);

        System.out.println("\n[Passo 4] Carrinho Final (Carrinho 5 com 15% de Desconto):");
        System.out.println(carrinho5);

        // 5. Demonstração de Validações e Exceções
        System.out.println("\n[Passo 5] Testando Validações de Negócio:");

        // a) Tentar aplicar cupom acima de 30%
        try {
            carrinho5.aplicarCupom(new BigDecimal("0.35"));
        } catch (IllegalArgumentException e) {
            System.out.println("-> ERRO de Cupom: " + e.getMessage());
        }

        // b) Tentar adicionar quantidade inválida
        try {
            carrinho5.adicionarItem(cabo, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("-> ERRO de Quantidade: " + e.getMessage());
        }

        // c) Tentar criar Dinheiro negativo
        try {
            Dinheiro.of(new BigDecimal("-10.00"), Moeda.BRL);
        } catch (IllegalArgumentException e) {
            System.out.println("-> ERRO de Dinheiro: " + e.getMessage());
        }

        // 6. Verificação da Imutabilidade
        System.out.println("\n[Passo 6] Verificação da Imutabilidade:");
        System.out.println("O 'Carrinho 3' original (sem desconto) ainda existe: " + carrinho3.getTotalFinal());
        System.out.println("O 'Carrinho 5' (com desconto) tem o total: " + carrinho5.getTotalFinal());
        System.out.println("Conclusão: Nenhuma operação mudou o estado dos carrinhos anteriores.");
    }
}