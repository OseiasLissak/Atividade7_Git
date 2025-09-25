package exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Funcionario gerente = new Gerente( "João", new BigDecimal(20000));
        Funcionario desenvolvedor= new Gerente( "James", new BigDecimal(1000));

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(gerente);
        funcionarios.add(desenvolvedor);

        for(Funcionario f : funcionarios){
            System.out.println("Funcionario: " + f.getNome());
            System.out.println("Salário: " + f.getSalario());
            System.out.println("Bonus: " + f.calcularSalario());
            System.out.println(("-------------"));
        }
    }

}
