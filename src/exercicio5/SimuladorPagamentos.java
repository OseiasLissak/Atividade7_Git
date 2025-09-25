package exercicio5;

// Importa as classes do subpacote 'pagamentos'
import exercicio5.pagamentos.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimuladorPagamentos {

    public static void main(String[] args) {
        // --- Demonstração de Polimorfismo ---

        // A lista é do tipo genérico FormaPagamento (POLIMORFISMO e ABSTRAÇÃO)
        List<FormaPagamento> pagamentos = new ArrayList<>();

        // Pagamentos Válidos
        pagamentos.add(new CartaoCredito("1234567890123456", "Alice Souza", "123"));
        pagamentos.add(new Boleto("000912345678901234567890123456789012345678901234"));
        pagamentos.add(new Pix("alice.souza@email.com", "EMAIL"));

        // Pagamentos Inválidos (para testar as exceções)
        pagamentos.add(new CartaoCredito("123", "Bob Silva", "007")); // Inválido (cartão muito curto)
        pagamentos.add(new Pix("1234567890", "CPF")); // Inválido (CPF muito curto)


        // Valor da compra
        BigDecimal valorCompra = new BigDecimal("150.75");

        // --- Processamento Polimórfico ---
        System.out.println("=================================================");
        System.out.println("INICIANDO SIMULAÇÃO DE PAGAMENTOS (Valor: R$ " + valorCompra + ")");
        System.out.println("=================================================");

        for (FormaPagamento fp : pagamentos) {
            try {
                // A chamada para processarPagamento funciona para qualquer objeto na lista
                String resultado = fp.processarPagamento(valorCompra);
                System.out.println("\n[SUCESSO] " + resultado);
            } catch (PagamentoInvalidoException e) {
                // Tratamento da exceção específica
                System.out.println("\n[ERRO DE VALIDAÇÃO] Falha ao processar pagamento via "
                        + fp.getClass().getSimpleName() + ".");
                System.out.println("Detalhes: " + e.getMessage());
            } catch (Exception e) {
                // Outros erros inesperados
                System.err.println("Erro inesperado: " + e.getMessage());
            }
        }
        System.out.println("\n=================================================");
        System.out.println("SIMULAÇÃO FINALIZADA.");
    }
}