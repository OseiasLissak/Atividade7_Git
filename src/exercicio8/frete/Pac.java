package exercicio8.frete;

import exercicio8.modelo.Pedido;
import java.math.BigDecimal;

/**
 * Estratégia de cálculo PAC.
 */
public class Pac implements CalculoFreteStrategy {

    @Override
    public BigDecimal calcular(Pedido pedido) throws CepInvalidoException {
        // Exemplo de validação: Apenas Sedex permite CEPs fora da região metropolitana (simulação)
        if (pedido.getCliente().getCep().startsWith("99")) {
            throw new CepInvalidoException("CEP em região de difícil acesso. PAC indisponível. Tente Sedex.");
        }

        // Simulação de frete PAC: Taxa fixa mais baixa
        BigDecimal taxaFixa = new BigDecimal("15.00");

        return taxaFixa;
    }
}
