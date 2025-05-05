package UnidadeI.Listas_Estaticas.Lista_Estatica_Circular.Aula_3.Revisando;

public class ListaEstaticaCircularMain {
    public static void main(String[] args) {
        Listavel lista = new ListaEstaticaCircular(7);
        lista.anexar("La Isla Bonita - Madonna");
        lista.anexar("Slave to Love- Bryan Ferry");
        System.out.println(lista.selecionar(1));
        lista.anexar("Eyes without a face - Billy Idol");
        lista.anexar("Take on me - A-ha");
        lista.anexar("Cheia de Charme - Guilherme Arantes");
        System.out.println("Removendo: " + lista.remover(4));
        System.out.println("Lista: " + lista.imprimir());
        lista.inserir("Careless Whisper - George Michael", 4);        
        lista.atualizar(2, "Don't you (Forget about me) - Simple Minds");
        System.out.println("Lista após atualização: " + lista.imprimir());

        Object conteudo = lista.selecionarTodos();
        System.out.println("Conteúdo da lista: " + java.util.Arrays.toString((Object[]) conteudo));
        

    }
}
