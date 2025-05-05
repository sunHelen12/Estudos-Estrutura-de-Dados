package UnidadeI.Filas_Estaticas.Revisando.Fila_Estatica;

public interface Enfileiravel {
    void enfileirar(Object elemento); //enfileirar elementos
    Object desenfileirar(); //desenfileirar elementos e o retornar
    Object espiar(); //verificar elemento que está na frente da fila

    boolean estaCheia(); //verificar se a fila está cheia
    boolean estaVazia(); //verificar se a fila está vazia
    String imprimir(); //imprimir elementos da fila
}
