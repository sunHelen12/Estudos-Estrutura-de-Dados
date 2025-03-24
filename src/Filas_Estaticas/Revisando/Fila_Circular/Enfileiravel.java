package Filas_Estaticas.Revisando.Fila_Circular;

public interface Enfileiravel {
    void enfileirar(Object elemento); // Adiciona um elemento na fila
    Object desenfileirar(); // Remove um elemento da fila
    Object espiar(); // Retorna o primeiro elemento da fila

    boolean estaCheia(); // Verifica se a fila está cheia
    boolean estaVazia(); // Verifica se a fila está vazia
    String imprimir(); // Imprime a fila
}
