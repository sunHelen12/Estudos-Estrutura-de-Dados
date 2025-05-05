package UnidadeI.Listas_Estaticas.Aula_4.Lista_Estatica;

public interface Listavel {
    void inserir(Object elemento, int indice);        //C insert
    void anexar(Object elemento);                     //C append - insere no final
    Object selecionar(int indice);                    //R select
    Object [] selecionarTodos();                      //R selectAll
    void atualizar(Object elemento, int indice);      //U update
    Object apagar(int indice);                        //D delete
    boolean contem(Object elemento);                  //S sort
    void limpar();                                    //D
    //Extra
    int primeiraOcorrencia(Object elemento);
    int ultimaOcorrencia(Object elemento);
    boolean comparador(Object elemento1, Object elemento2);

    boolean estaCheia();
    boolean estaVazia();
    String imprimir();                                                      

}
