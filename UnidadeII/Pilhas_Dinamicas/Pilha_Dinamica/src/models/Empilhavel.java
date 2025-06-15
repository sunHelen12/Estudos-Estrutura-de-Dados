package models;

/**
 * Esta interface indica as operações que uma classe que deseja ter o comportamento
 * de ser Empilhável precisa.
 *
 * @author Rocha, H.S.
 * @version 1.0
 * @since 2025-05-01
 */

// Usando Generics
public interface Empilhavel <T> {
    void empilhar(T elemento); //empilhar elementos
    void atualizar(T elemento);
    T desempilhar(); //desempilhar elementos e o retornar
    T espiar(); //verificar elemento do topo

    boolean estaCheia(); //verificar se a pilha está cheia
    boolean estaVazia(); //verificar se a pilha está vazia

    String imprimir(); //imprimir elementos da pilha;
}

// models.Empilhavel <Venda> pilha = new....
// models.Empilhavel <Paciente> pilha = new....
// models.Empilhavel <String> pilha = new....
// models.Empilhavel <Integer> pilha = new....
// O usuário escolhe o que será empilhado
