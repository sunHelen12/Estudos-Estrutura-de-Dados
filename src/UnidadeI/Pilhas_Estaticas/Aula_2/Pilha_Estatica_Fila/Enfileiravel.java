package UnidadeI.Pilhas_Estaticas.Aula_2.Pilha_Estatica_Fila;

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
