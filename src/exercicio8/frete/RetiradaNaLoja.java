package exercicio8.frete;

import exercicio8.modelo.Pedido;
import java.math.BigDecimal;

/**
 * Estratégia de frete Grátis por Retirada na Loja.
 */
public class RetiradaNaLoja implements CalculoFreteStrategy {

    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Frete sempre zero, sem validação de CEP
        return BigDecimal.ZERO;
    }
}