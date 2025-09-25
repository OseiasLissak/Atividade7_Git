package exercicio3;

import java.math.BigDecimal;

    public class Dev extends Funcionario {
        public Dev(String nome, BigDecimal salario) {
            super(nome, salario);
        }

        public BigDecimal calcularSalario() {
            return salario.multiply(new BigDecimal("0.10"));
        }
    }


