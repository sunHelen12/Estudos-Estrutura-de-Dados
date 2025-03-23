package Pilhas_Estaticas.Aula_2.PilhaInvertida;

import Pilhas_Estaticas.Aula_2.PilhaEstatica.Empilhavel;

public class PilhaEstaticaInvertidaMain {
    public static void main(String[] args) {
         //instaciar
         Empilhavel pilha = new PilhaEstaticaInvertida(10);
         //empilhar elementos
         pilha.empilhar("Tarzan Boy");
         pilha.empilhar("Slave to Love");
         pilha.empilhar("You Are the One");
         pilha.empilhar("Spending My Time");        
         pilha.empilhar("Every Breath You Take");
         pilha.empilhar("Don't Dream It's Over");
         System.out.println("Espiar: " + pilha.espiar());
         pilha.empilhar("Don't Look Back in Anger");
         pilha.empilhar("Lambada");
         pilha.empilhar("La Isla Bonita");
         pilha.empilhar(10);        
         //desempilhar 
         int conteudo = (int) pilha.desempilhar();
         System.out.println("Elemento Removido: " + conteudo);
         pilha.empilhar(pilha.desempilhar());
         pilha.empilhar(conteudo);
         System.out.println("Pilha = " + pilha.imprimir());
    }
}
