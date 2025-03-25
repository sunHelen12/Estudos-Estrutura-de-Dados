package Filas_Estaticas.Aula_3.Fila_Circular;

public class FilaEstaticaCircularMain {
    public static void main(String[] args) {
        Enfileiravel fila = new FilaEstaticaCircular(10);
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        System.out.println(fila.frente());
        fila.enfileirar(4);
        fila.enfileirar(5);
        Object elementoRemovido = fila.desenfileirar();
        System.out.println(elementoRemovido);
        fila.enfileirar(6);
        System.out.println(fila.imprimir());
    }
}
