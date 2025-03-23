package Pilhas_Estaticas.Revisando.Pilha_Estatica_Invertida;

public interface  Empilhavel {
    void empilhar(Object elemento);
    Object desempilhar();
    Object topo();

    boolean estaCheia();
    boolean estaVazia();
    
    String imprimir();
}
