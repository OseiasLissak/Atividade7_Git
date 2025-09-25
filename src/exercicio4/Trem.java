package exercicio4;

public class Trem implements IMeioTransporte {
    private int velocidade;
    private final int limiteVelocidade = 200;

    public Trem() {
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidade) {
            this.velocidade += 20;
            System.out.println("Trem acelerando. Velocidade atual: " + this.velocidade + " km/h");
        } else {
            throw new IllegalArgumentException("Trem atingiu o limite de velocidade!");
        }
    }

    @Override
    public void desacelerar() { // Método que estava faltando
        if (this.velocidade > 0) {
            this.velocidade -= 20;
            System.out.println("Trem desacelerando. Velocidade atual: " + this.velocidade + " km/h");
        } else {
            System.out.println("Trem parado.");
        }
    }
}