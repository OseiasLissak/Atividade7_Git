package exercicio6.modelo;

public enum Moeda {
    BRL("R$"),
    USD("$");

    private final String simbolo;

    Moeda(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}