package Algoritmos_ordenacao.ordenacao_bubbleSort;

public class BubbleSort {

    int []elementos = {6, 8, 3, 1, 9, 0, 2, 5}; 
    
    public  void imprimirTela(){
        for(int elemento : elementos){
            System.out.print(elemento + " ");           
        }
    }

    public  void bubbleSort() { //para ir até o 7 e não ao 8 que não existe
        for(int j = 0; j < elementos.length - 1; j++){
            for (int i = 0; i < (elementos.length - 1) - j; i++){
                if (elementos[i] > elementos[i + 1]){
                    troca(i, i + 1);
                }
        }
        }
        
    }    
    
    private void  troca(int indice1, int indice2) {
        int temp = elementos[indice1];
        elementos[indice1] = elementos[indice2];
        elementos[indice2] = temp;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        System.out.println("Antes");
        sort.imprimirTela();
        System.out.println();

        sort.bubbleSort();

        System.out.println("Depois");
        sort.imprimirTela();
        
        System.out.println();

    }
}

