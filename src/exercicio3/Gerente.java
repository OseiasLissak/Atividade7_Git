package exercicio3;

import java.math.BigDecimal;

public class Gerente extends Funcionario {
    public Gerente(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    public BigDecimal calcularSalario() {
        return salario.multiply(new BigDecimal("0.20"));
    }
}
