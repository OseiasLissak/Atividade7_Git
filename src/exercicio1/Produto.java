package exercicio1;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null | nome.isEmpty()) {
            throw new IllegalArgumentException("O Nome não deve ser vazio ou nulo");
        }
        ;

        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a zero ");
        }

        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a zero ");
        }

        this.quantidade = quantidade;
    }

    public void exibirProduto() {
        System.out.println("Nome do produto: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade do produto: " + this.quantidade);
    }

    public static void main(String[] args) {


        try {
            Produto produto = new Produto("Produto", 1200.00, 3);
            produto.exibirProduto();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }


        try {
            Produto produtoInvalido = new Produto("", 1200.00, 3);
        } catch (IllegalArgumentException ex) {
            System.out.println("Validação com Nome vazio ==> " + ex.getMessage());
        }

        try {
            Produto precoInvalido = new Produto("Mouse", -1, 3);
        } catch (IllegalArgumentException ex) {
            System.out.println("Validação com Preço -1 ==> " + ex.getMessage());
        }

    }
}