package exercicio8.frete;

/**
 * Exceção personalizada para representar falhas na validação do CEP.
 */
public class CepInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public CepInvalidoException(String mensagem) {
        super(mensagem);
    }
}