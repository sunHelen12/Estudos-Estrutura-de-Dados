package Pilhas_Estaticas.Pilha_Dupla;

public interface EmpilhavelDupla {

    //métodos da pilha 1 - tradicional
    void empilhar1(Object elemento);
    Object desempilhar1();
    Object topo1();
    boolean estaCheia1();
    boolean estaVazia1();
    String imprimir1();

    //métodos da pilha 2 - invertida
    void empilhar2(Object elemento);
    Object desempilhar2();
    Object topo2();
    boolean estaCheia2();
    boolean estaVazia2();
    String imprimir2();
}
