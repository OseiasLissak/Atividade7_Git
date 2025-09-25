package exercicio5.pagamentos;

import java.math.BigDecimal;

/**
 * Classe abstrata que define o esqueleto para todas as formas de pagamento.
 */
public abstract class FormaPagamento {

    /**
     * Método abstrato para validar os dados específicos de cada forma de pagamento.
     * @throws PagamentoInvalidoException se a validação falhar.
     */
    public abstract void validarPagamento() throws PagamentoInvalidoException;

    /**
     * Processa o pagamento, primeiro validando e depois simulando a transação.
     *
     * @param valor O valor a ser processado.
     * @return Uma mensagem de sucesso do processamento.
     * @throws PagamentoInvalidoException se a validação ou processamento falhar.
     */
    public String processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        // POLIMORFISMO: Chama a implementação específica da subclasse
        validarPagamento();

        System.out.println("-> Processando pagamento de R$ " + valor + "...");
        System.out.println("-> Transação enviada para o banco/adquirente...");

        return "Pagamento de R$ " + valor + " processado com SUCESSO via " + this.getClass().getSimpleName() + ".";
    }
}