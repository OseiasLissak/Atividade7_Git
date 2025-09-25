package exercicio5.pagamentos;

/**
 * Exceção personalizada para representar falhas na validação de uma forma de pagamento.
 */
public class PagamentoInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public PagamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}