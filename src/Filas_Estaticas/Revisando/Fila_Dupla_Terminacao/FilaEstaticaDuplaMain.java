package Filas_Estaticas.Revisando.Fila_Dupla_Terminacao;

public class FilaEstaticaDuplaMain {
    public static void main(String[] args) {
        //instaciando
        DuplamenteEnfileiravel fila = new FilaEstaticaDupla(8);
        //enfileirar no início
        fila.enfileirarInicio("Sinônimos - Zé Ramalho");
        fila.enfileirarInicio("Meu Universo é Você - Roupa Nova");        
        fila.enfileirarFim("Metamorfose Ambulante - Raul Seixas");
        System.out.println(fila.tras());
        //desenfileirar no início
        Object conteudo = fila.desenfileirarInicio();
        System.out.println("Elemento Removido do início: " + conteudo);
        //enfileira no fim
        fila.enfileirarFim("Chão de Giz - Zé Ramalho");
        fila.enfileirarFim("Dois Corações e uma História - Zezé Di Camargo & Luciano");
        System.out.println(fila.frente());
        fila.enfileirarInicio("Sexy Yemanjá - Pepeu Gomes");
        //desenfileirar no fim
        conteudo = fila.desenfileirarFim();
        System.out.println("Elemento Removido do fim: " + conteudo);
        //imprimir
        System.out.println("Fila: " + fila.imprimir());
    }
}
