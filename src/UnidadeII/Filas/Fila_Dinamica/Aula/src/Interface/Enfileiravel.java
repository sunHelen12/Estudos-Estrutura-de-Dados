package UnidadeII.Fila_Dinamica.Aula.Interface;

public interface  Enfileiravel <T>{
    void enfileirarIncio (T dado);
    void enfileirarFim (T dado);

    T desenfileirarIincio();
    T desenfileirarFim();
    
    T frente(); //é como espiar
    T tras(); //é como espiar

    void atualizarInicio(T dado);
    void atualizarFim(T dado);    

    boolean estaCheia();
    boolean estaVazia();

    String imprimirTras();
    String imprimirFrente();
}

