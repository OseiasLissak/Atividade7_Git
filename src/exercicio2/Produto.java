package exercicio2;

class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

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

    public void aplicarDesconto(double porcentagem) {
        if(porcentagem < 0 || porcentagem > 50) {
            throw new  DescontoInvalidoException("A porcentagem do desconto é invalida.");
        }

        double valorDesconto = preco * (porcentagem / 100);
        this.preco -= valorDesconto;
    }

    public void exibirProduto() {
        System.out.println("Nome do produto: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade do produto: " + this.quantidade);
    }

    public static void main(String[] args) {
       try {
           Produto produto = new Produto("Chinelo", 12.50, 10);
           System.out.println("Valor sem desconto: " );
           produto.exibirProduto();

           produto.aplicarDesconto(50);
           System.out.println("Valor com desconto: ");
           produto.exibirProduto();
       } catch (DescontoInvalidoException e) {
           System.out.println(e.getMessage());
       }

    }
}