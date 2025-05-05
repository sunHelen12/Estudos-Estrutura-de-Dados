package UnidadeI.Algoritmos_ordenacao.ordenacao_bubbleSort;

public class Ordenacao {

    int []elementos = {6, 8, 3, 1, 9, 0, 2, 5};    

    public  void bubbleSort() { //para ir até o 7 e não ao 8 que não existe
        for(int j = 0; j < elementos.length - 1; j++){
            for (int i = 0; i < (elementos.length - 1) - j; i++){
                if (elementos[i] > elementos[i + 1]){
                    troca(i, i + 1);
                }
            }
        }
        
    } 

    public void selectionSort(){        
        for(int j = 0; j < elementos.length; j++){
            int menor = j;
            for(int i = 1 + j; i < elementos.length; i++){
                if (elementos[menor] > elementos[i]) {
                    menor = i;
                }
            }
            troca(j, menor);
        }
    }   
    //Começa da esquerda para direita
    public void insertionSort(){
        for (int j = 1; j < elementos.length; j++){            
            for (int i = j - 1; i >= 0; i--){
                if(elementos[i + 1] < elementos[i]){
                    troca(i + 1, i);
                }else{
                    break;
                }
            }
        }
    }

    public  void imprimirTela(){
        for(int elemento : elementos){
            System.out.print(elemento + " ");           
        }
    }
    
    private void troca(int indice1, int indice2) {
        int temp = elementos[indice1];
        elementos[indice1] = elementos[indice2];
        elementos[indice2] = temp;
    }    

    public static void main(String[] args) {
        Ordenacao sort = new Ordenacao();

        System.out.println("*****BUBBLE SORT*****");
        System.out.println("Antes");
        sort.imprimirTela();
        System.out.println();

        sort.bubbleSort();

        // System.out.println("Depois");
        // sort.imprimirTela();

        // System.out.println();

        // System.out.println("*****SELECTION SORT*****");
        // sort.selectionSort();
        // sort.imprimirTela();

        // System.out.println();
        // System.out.println("*****INSERTION SORT*****");
        // sort.insertionSort();


    }
}

