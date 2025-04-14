package Provas.Provas_unidade_I.Prova_I;

public interface Listavel(){
    //Falta terminar
    void anexar(Object elemento);
    void inserir(Object elemento, int indice);
    Object selecionar (int posicao);
    Object[] selecionarTodos();
    void atualizar(int posicao, Object elemento);
}