package UnidadeI.Filas_Estaticas.Revisando.Fila_Estatica;

public class FilaEstaticaMain {
    public static void main(String[] args) {
        //instanciar
        Enfileiravel fila = new FilaEstatica(5);
        //enfileirar
        fila.enfileirar("Meu Universo é Você - Roupa Nova");
        fila.enfileirar("Só prá O Vento - Ritchie");
        fila.enfileirar("Menina Veneno - Ritchie");
        //espiar
        System.out.println(fila.espiar());
        fila.enfileirar("Casanova - Ritchie");
        fila.enfileirar("Pelo Interfone - Ritchie");        
        //desenfileirar
        Object conteudo = fila.desenfileirar(); //retira o primeiro elemento da fila
        System.out.println("Elemento Removido: " + conteudo);
        //imprimir
        System.out.println("Fila: " + fila.imprimir());
    }
}
