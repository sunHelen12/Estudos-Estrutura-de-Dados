package UnidadeI.Filas_Estaticas.Aula_3.Fila_Dupla_Terminacao;

public interface Enfileiravel {
    void enfileirarIncio (Object elemento);
    void enfileirarFim (Object elemento);
    Object desenfileirarIincio();
    Object desenfileirarFim();
    Object frente(); //é como espiar
    Object tras(); //é como espiar
    void atualizarInicio(Object elemento);
    void atualizarFim(Object elemento);
    

    boolean estaCheia();
    boolean estaVazia();    
    String imprimirTras();
    String imprimirFrente();
}
