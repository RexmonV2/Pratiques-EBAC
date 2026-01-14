package Carro.entity;

public class Carro {
    private String nome;
    private double preco;

    public Carro(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco(){
        return preco;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return "Carro: " + nome + "\nPreço: R$ " + preco;
    }
}
