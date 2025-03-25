package Filas_Estaticas.Aula_3.Fila_Estatica;

public interface Enfileirarvel {
    void enfileirar (Object elemento);
    Object frente(); //é como espiar
    void atualizarInicio(Object elemento);
    void atualizarFim(Object elemento);
    Object desenfileirar();

    boolean estaVazia();
    boolean estaCheia();
    String imprimir();
}
