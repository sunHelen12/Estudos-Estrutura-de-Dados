package Listas_Estaticas.Lista_Estatica_Circular.Aula_3.Revisando;

public interface Listavel {
    void anexar(Object elemento); //vou anexar o elemento no final da lista
    void inserir(Object elemento, int posicao); // o usuário vai informar a posição que ele quer inserir o elemento
    Object selecionar(int posicao); // o usuário vai informar a posição que ele quer selecionar o elemento
    Object[] selecionarTodos(); //selecionar o elemento para retornar 
    void atualizar(int posicao, Object novoElemento); // o usuário vai informar a posição que ele quer atualizar com um novo elemento
    Object remover (int posicao); // o usuário vai informar a posição que ele quer remover o elemento

    //métodos auxiliares
    boolean estaCheia(); // verificar se a lista está cheia
    boolean estaVazia(); // verificar se a lista está vazia 
    String imprimir(); // imprimir a lista

}
