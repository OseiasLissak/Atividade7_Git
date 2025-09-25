package exercicio8.frete;

import exercicio8.modelo.Pedido;
import java.math.BigDecimal;

/**
 * Interface Funcional que define o contrato para qualquer estratégia de cálculo de frete.
 * O método 'calcular' recebe o Pedido e retorna o valor do frete.
 */
@FunctionalInterface
public interface CalculoFreteStrategy {

    BigDecimal calcular(Pedido pedido) throws CepInvalidoException;

}