package Listas_Estaticas.Lista_Estatica_Circular;

public interface Listavel {
    void anexar(Object elemento); //vou anexar o elemento no final da lista
    void inserir(Object elemento, int posicao); // o usuário vai informar a posição que ele quer inserir o elemento
    void selecionar(int posicao); // o usuário vai informar a posição que ele quer selecionar o elemento
    Object[] selecionarTodos(); // o usuário vai informar a posição que ele quer selecionar o elemento para retornar todos os elementos
    void atualizar(int posicao, Object novoElemento); // o usuário vai informar a posição que ele quer atualizar com um novo elemento
    void remover (int posicao); // o usuário vai informar a posição que ele quer remover o elemento

    //métodos auxiliares
    boolean estaCheia(); // verificar se a lista está cheia
    boolean estaVazia(); // verificar se a lista está vazia 
    String imprimir(); // imprimir a lista

}
