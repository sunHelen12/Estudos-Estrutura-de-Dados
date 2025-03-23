package Pilhas_Estaticas.Revisando.Pilha_Estatica_Invertida;

public class PilhaEstaticaInvertidaMain {
    public static void main(String[] args) {
        //instacia
        Empilhavel pilha = new PilhaEstaticaInvertida(5);
        //empilha
        pilha.empilhar("Linkin Park");
        pilha.empilhar("Ghost");
        pilha.empilhar("Evanesce");
        pilha.empilhar("Guns N' Roses");
        pilha.empilhar(2.1);
        //desempilhar
        Object conteudo = pilha.desempilhar();
        System.out.println("Elemento Removido: " + conteudo);
        //olhar topo da pilha
        System.out.println("Elemento no Topo da Pilha: " + pilha.topo());
        //imprimir elementos
        System.out.println("Pilha: " + pilha.imprimir());
    }
}
