package exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<IMeioTransporte> meiosDeTransporte = new ArrayList<>();

        meiosDeTransporte.add(new Carro());
        meiosDeTransporte.add(new Bicicleta());
        meiosDeTransporte.add(new Trem());

        // Acelerando os meios de transporte
        System.out.println("--- ACELERANDO ---");
        for (IMeioTransporte meioTransporte : meiosDeTransporte) {
            try {
                // Acelerando 5 vezes para demonstrar o polimorfismo e o limite
                for (int i = 0; i < 5; i++) {
                    meioTransporte.acelerar();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao acelerar: " + e.getMessage());
            }
        }

        System.out.println("\n--- DESACELERANDO ---");
        // Desacelerando os meios de transporte
        for (IMeioTransporte meioTransporte : meiosDeTransporte) {
            try {
                // Desacelerando 5 vezes
                for (int i = 0; i < 5; i++) {
                    meioTransporte.desacelerar(); // Chamada corrigida
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao desacelerar: " + e.getMessage());
            }
        }
    }
}