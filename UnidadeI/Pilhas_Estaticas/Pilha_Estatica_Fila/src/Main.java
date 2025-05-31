public class Main {

    public static void main(String[] args) {
        FilaComPilhas fila = new FilaComPilhas(5);

        System.out.println("Enfileirando elementos: 10, 20, 30");
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);

        System.out.println("Fila: " + fila.imprimir());

        System.out.println("Frente da fila: " + fila.frente());

        System.out.println("Desenfileirando: " + fila.desenfileirar());
        System.out.println("Fila após desenfileirar: " + fila.imprimir());

        System.out.println("Atualizando início para 99");
        fila.atualizarInicio(99);
        System.out.println("Fila após atualizar início: " + fila.imprimir());

        System.out.println("Atualizando fim para 77");
        fila.atualizarFim(77);
        System.out.println("Fila após atualizar fim: " + fila.imprimir());
    }
}
