package models;

public class Elemento {
    private int numero;
    private String nome;

    public Elemento(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
