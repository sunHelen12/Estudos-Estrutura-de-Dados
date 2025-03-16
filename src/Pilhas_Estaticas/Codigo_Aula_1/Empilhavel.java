package Pilhas_Estaticas.Codigo_Aula_1;

public interface Empilhavel {
    void empilhar(Object elemento); //empilhar elementos
    Object desempilhar(); //desempilhar elementos e o retornar
    Object topo(); //verificar elemento do topo

    boolean estaCheia(); //verificar se a pilha está cheia
    boolean estaVazia(); //verificar se a pilha está vazia

    String imprimir(); //imprimir elementos da pilha;
}
