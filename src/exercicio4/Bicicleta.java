package exercicio4;

public class Bicicleta implements IMeioTransporte {
    private int velocidade;
    private final int limiteVelocidade = 30;

    public Bicicleta() {
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidade) {
            this.velocidade += 5;
            System.out.println("Bicicleta acelerando. Velocidade atual: " + this.velocidade + " km/h");
        } else {
            throw new IllegalArgumentException("Bicicleta atingiu o limite de velocidade!");
        }
    }

    @Override
    public void desacelerar() { // Método que estava faltando
        if (this.velocidade > 0) {
            this.velocidade -= 5;
            System.out.println("Bicicleta desacelerando. Velocidade atual: " + this.velocidade + " km/h");
        } else {
            System.out.println("Bicicleta parada.");
        }
    }
}