package Filas_Estaticas.Revisando.Fila_Circular;

public class FilaEstaticaCircularMain {    
    public static void main(String[] args) {
        //instaciando
        Enfileiravel fila = new FilaEstaticaCircular(8);
        //enfileirar
        fila.enfileirar("Cobol");
        fila.enfileirar("Python");        
        fila.enfileirar("SQL");
        System.out.println(fila.espiar());
        // //desenfileirar
        // Object conteudo = fila.desenfileirar();
        // System.out.println("Elemento Removido: " + conteudo);
        // //enfileira
        // fila.enfileirar("Java");
        // fila.enfileirar("JavaScript");
        // fila.enfileirar("C#");        
        // System.out.println(fila.espiar());
        // //imprimir
        // System.out.println("Fila: " + fila.imprimir());
    }
}
