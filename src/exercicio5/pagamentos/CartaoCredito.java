package exercicio5.pagamentos;

/**
 * Implementação concreta para pagamento via Cartão de Crédito.
 */
public class CartaoCredito extends FormaPagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String codigoSeguranca;

    public CartaoCredito(String numeroCartao, String nomeTitular, String codigoSeguranca) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("\n--- Validando Cartão de Crédito...");
        // Exemplo de validação
        if (numeroCartao == null || numeroCartao.length() < 13 || numeroCartao.length() > 19) {
            throw new PagamentoInvalidoException("Número do cartão inválido: deve ter entre 13 e 19 dígitos.");
        }
        if (codigoSeguranca == null || codigoSeguranca.length() != 3 && codigoSeguranca.length() != 4) {
            throw new PagamentoInvalidoException("Código de segurança (CVV) inválido.");
        }
        System.out.println("Cartão de Crédito validado com sucesso!");
    }
}