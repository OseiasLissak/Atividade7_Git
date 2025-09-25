package exercicio8.frete;

import exercicio8.modelo.Pedido;
import java.math.BigDecimal;

/**
 * Estratégia de cálculo Sedex.
 */
public class Sedex implements CalculoFreteStrategy {

    @Override
    public BigDecimal calcular(Pedido pedido) throws CepInvalidoException {
        // Exemplo de validação simples: CEP deve ter 8 dígitos
        if (pedido.getCliente().getCep().length() != 8 || !pedido.getCliente().getCep().matches("\\d+")) {
            throw new CepInvalidoException("CEP inválido para Sedex. Formato esperado: 8 dígitos numéricos.");
        }

        // Simulação de frete Sedex: Taxa fixa + 1% do valor do pedido
        BigDecimal taxaFixa = new BigDecimal("25.00");
        BigDecimal valorAdicional = pedido.getValorTotalItens().multiply(new BigDecimal("0.01"));

        return taxaFixa.add(valorAdicional);
    }
}