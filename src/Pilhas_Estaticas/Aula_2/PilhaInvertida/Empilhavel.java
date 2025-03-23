package Pilhas_Estaticas.Aula_2.PilhaEstatica;

public interface Empilhavel {
    void empilhar(Object elemento); //empilhar elementos
    void atualizar(Object elemento);
    Object desempilhar(); //desempilhar elementos e o retornar
    Object espiar(); //verificar elemento do topo

    boolean estaCheia(); //verificar se a pilha está cheia
    boolean estaVazia(); //verificar se a pilha está vazia

    String imprimir(); //imprimir elementos da pilha;
}
