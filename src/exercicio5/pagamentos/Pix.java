package exercicio5.pagamentos;

/**
 * Implementação concreta para pagamento via Pix.
 */
public class Pix extends FormaPagamento {
    private String chavePix;
    private String tipoChave; // ex: 'CPF', 'EMAIL', 'CELULAR'

    public Pix(String chavePix, String tipoChave) {
        this.chavePix = chavePix;
        this.tipoChave = tipoChave;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("\n--- Validando Chave Pix...");
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix não pode ser vazia.");
        }

        // Exemplo de validação específica para o tipo de chave
        if ("CPF".equalsIgnoreCase(tipoChave) && chavePix.length() != 11) {
            throw new PagamentoInvalidoException("Chave Pix do tipo CPF deve ter 11 dígitos.");
        } else if ("EMAIL".equalsIgnoreCase(tipoChave) && !chavePix.contains("@")) {
            throw new PagamentoInvalidoException("Chave Pix do tipo EMAIL está em formato inválido.");
        }

        System.out.println("Chave Pix validada com sucesso! Tipo: " + tipoChave);
    }
}