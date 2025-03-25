package Filas_Estaticas.Aula_3.Fila_Circular;

public interface Enfileiravel {
    void enfileirar (Object elemento);
    Object frente(); //é como espiar
    void atualizarInicio(Object elemento);
    void atualizarFim(Object elemento);
    Object desenfileirar();

    boolean estaCheia();
    boolean estaVazia();    
    String imprimir();
}
