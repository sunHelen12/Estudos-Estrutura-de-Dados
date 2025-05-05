package UnidadeII.Heap.Revisando;

public class HeapSort {
    public static void main(String[] args) {
        int []numeros = new int [10];
        int n = numeros.length;

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = (int) Math.floor(Math.random() * numeros.length);
        }

        System.out.println("---Números Desordenados---");
        for(int i = 0; i < numeros.length; i++){
            System.out.print(numeros[i] + " ");
        }

        //Aplicando o Heap
        for(int i = n / 2 -1; i >= 0; i--){
            aplicarHeap(numeros, n, i);
        }

        System.out.println("\n\n---Números Quase Ordenados---");
        for(int i = 0; i < numeros.length; i++){
            System.out.print(numeros[i] + " ");
        }

        //Ordenando por ordem crescente
        for(int j = n - 1; j > 0; j--){
            int aux = numeros[0];
            numeros[0] = numeros[j];
            numeros[j] = aux;

            aplicarHeap(numeros, j, 0);
        }

        System.out.println("\n\n---Números Ordenados---");
        for(int i = 0; i < numeros.length; i++){
            System.out.print(numeros[i] + " ");
        }

        System.out.println();
    }

    private static void aplicarHeap(int[] numeros, int tamanhoVetor, int indice) {
        int raiz = indice;
        int esquerda = 2 * indice + 1;
        int direita = 2 * indice + 2;

        if(esquerda < tamanhoVetor && numeros[esquerda] > numeros[raiz]){
            raiz = esquerda;
        }    

        if(direita < tamanhoVetor && numeros[direita] > numeros[raiz]){
            raiz = direita;
        }
        
        if(raiz != indice){
            int aux = numeros[indice];
            numeros[indice] = numeros[raiz];
            numeros[raiz] = aux;

            aplicarHeap(numeros, tamanhoVetor, raiz); //recursividade
        }
    
    }
        
}
