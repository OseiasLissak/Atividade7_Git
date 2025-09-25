package exercicio5.pagamentos;

/**
 * Implementação concreta para pagamento via Boleto.
 */
public class Boleto extends FormaPagamento {
    private String linhaDigitavel;

    public Boleto(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("\n--- Validando Boleto...");
        // Exemplo de validação: formato padrão de linha digitável (48 dígitos)
        if (linhaDigitavel == null || linhaDigitavel.length() != 48 || !linhaDigitavel.matches("\\d+")) {
            throw new PagamentoInvalidoException("Linha digitável do Boleto inválida. Deve ter 48 dígitos numéricos.");
        }
        System.out.println("Boleto validado com sucesso!");
    }
}