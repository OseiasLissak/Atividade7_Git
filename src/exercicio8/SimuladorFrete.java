package exercicio8;

import exercicio8.frete.*;
import exercicio8.modelo.Cliente;
import exercicio8.modelo.Pedido;

import java.math.BigDecimal;

public class SimuladorFrete {

    public static void main(String[] args) {

        // 1. Definição dos Objetos de Dados
        Cliente clienteA = new Cliente("Alice", "90000001"); // CEP Válido
        Cliente clienteB = new Cliente("Bob", "99000000");   // CEP de "Difícil Acesso"
        Cliente clienteC = new Cliente("Carla", "123");      // CEP Curto/Inválido

        BigDecimal valorPedidoAlto = new BigDecimal("500.00");
        BigDecimal valorPedidoBaixo = new BigDecimal("49.99");

        // 2. Definição das Estratégias
        CalculoFreteStrategy sedex = new Sedex();
        CalculoFreteStrategy pac = new Pac();
        CalculoFreteStrategy retirada = new RetiradaNaLoja();

        // Estratégia promocional via LAMBDA: Frete Grátis se o pedido for acima de R$ 100.00
        CalculoFreteStrategy fretePromocional = (pedido) -> {
            BigDecimal limiteFreteGratis = new BigDecimal("100.00");

            // Reutiliza a validação de CEP (poderia usar qualquer outra regra)
            if (pedido.getCliente().getCep().length() != 8) {
                throw new CepInvalidoException("CEP inválido para promoção.");
            }

            if (pedido.getValorTotalItens().compareTo(limiteFreteGratis) >= 0) {
                System.out.println("-> FRETE PROMOCIONAL ATIVADO (Grátis acima de R$ 100.00)");
                return BigDecimal.ZERO;
            } else {
                // Se não se qualificar para o grátis, cobra R$ 10.00
                System.out.println("-> Frete promocional de R$ 10.00 aplicado.");
                return new BigDecimal("10.00");
            }
        };


        // --- FLUXO DE TESTE (DEMONSTRAÇÃO DE TROCA DE ESTRATÉGIA) ---

        try {
            // Pedido 1: Cliente A (CEP Válido), Valor Alto
            Pedido pedido1 = new Pedido(clienteA, valorPedidoAlto, sedex);

            // 1. Testa a estratégia inicial (Sedex)
            System.out.println("=== Pedido 1 (Sedex) ===");
            BigDecimal frete1 = pedido1.calcularFrete();
            System.out.println("Frete via Sedex: R$ " + frete1); // Deve ser 25.00 + 5.00 = 30.00

            // 2. Troca de Estratégia em Tempo de Execução (para PAC)
            pedido1.setEstrategiaFrete(pac);
            BigDecimal frete2 = pedido1.calcularFrete();
            System.out.println("Frete via PAC: R$ " + frete2); // Deve ser 15.00

            // 3. Aplica Estratégia Lambda
            pedido1.setEstrategiaFrete(fretePromocional);
            BigDecimal frete3 = pedido1.calcularFrete();
            System.out.println("Frete via Lambda (Valor Alto): R$ " + frete3); // Deve ser R$ 0.00

            // --- Pedido 2: Cliente A, Valor Baixo (para testar o Lambda) ---
            Pedido pedido2 = new Pedido(clienteA, valorPedidoBaixo, fretePromocional);
            System.out.println("\n=== Pedido 2 (Lambda, Valor Baixo) ===");
            BigDecimal frete4 = pedido2.calcularFrete();
            System.out.println("Frete via Lambda (Valor Baixo): R$ " + frete4); // Deve ser R$ 10.00

            // --- Pedido 3: Teste de Exceção (CEP Inválido para Sedex) ---
            Pedido pedido3 = new Pedido(clienteC, valorPedidoAlto, sedex);
            System.out.println("\n=== Pedido 3 (Teste de Exceção - CEP Curto) ===");
            try {
                pedido3.calcularFrete();
            } catch (CepInvalidoException e) {
                System.out.println("-> ERRO CAPTURADO: " + e.getMessage());
            }

            // --- Pedido 4: Teste de Exceção (CEP Inválido para PAC - Região) ---
            Pedido pedido4 = new Pedido(clienteB, valorPedidoAlto, pac);
            System.out.println("\n=== Pedido 4 (Teste de Exceção - PAC indisponível) ===");
            try {
                pedido4.calcularFrete();
            } catch (CepInvalidoException e) {
                System.out.println("-> ERRO CAPTURADO: " + e.getMessage());
            }

        } catch (CepInvalidoException e) {
            System.out.println("\nERRO FATAL (Não deveria ocorrer fora do bloco try interno): " + e.getMessage());
        }
    }
}