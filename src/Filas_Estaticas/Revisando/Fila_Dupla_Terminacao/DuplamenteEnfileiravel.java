package Filas_Estaticas.Revisando.Fila_Dupla_Terminacao;

public interface DuplamenteEnfileiravel {
    void enfileirarInicio(Object elemento); //enfileirar elementos no início da fila
    void enfileirarFim(Object elemento); //enfileirar elementos no fim da fila
    Object desenfileirarInicio(); //desenfileirar elementos do início da fila e o retornar
    Object desenfileirarFim(); //desenfileirar elementos do fim da fila e o retornar

    Object espiarInicio(); //verificar elemento do início da fila
    Object espiarFim(); //verificar elemento do fim da fila

    boolean estaCheia(); //verificar se a fila está cheia
    boolean estaVazia(); //verificar se a fila está vazia
    String imprimir(); //imprimir elementos da fila
}
