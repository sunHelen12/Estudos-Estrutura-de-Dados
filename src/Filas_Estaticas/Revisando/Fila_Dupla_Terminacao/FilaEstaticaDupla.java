package Filas_Estaticas.Revisando.Fila_Dupla_Terminacao;

public class FilaEstaticaDupla implements DuplamenteEnfileiravel {

    private int ponteiroInicio, ponteiroFim, quantidade;
    private Object[] dados;

    public FilaEstaticaDupla(int tamanho){
        quantidade = 0;
        ponteiroInicio = -1;
        ponteiroFim = -1;
        dados = new Object[tamanho];
    }

    public FilaEstaticaDupla(){
        this(10); //chama o construtor com um argumento de tamanho 10 
                            //para inicializar o tamanho da fila
    }    

    @Override
    public void enfileirarInicio(Object elemento) {
        if(!estaCheia()){
            if(ponteiroInicio == -1){
                ponteiroInicio = dados.length - 1;
            }
            quantidade++;
            dados[ponteiroInicio] = elemento;
            ponteiroInicio--;
        }else{
            System.err.println("Fila Cheia!");
        }
    }

    @Override
    public void enfileirarFim(Object elemento) {
        if(!estaCheia()){
            if(ponteiroFim == dados.length - 1){
                ponteiroFim = -1;
            }
            quantidade++;
            ponteiroFim++;
            dados[ponteiroFim] = elemento;
        }else{
            System.err.println("Fila Cheia!");
        }
    }

    @Override
    public Object desenfileirarInicio() {
        Object elementoDesenfileirado = null;
        if(!estaVazia()){
            if(ponteiroInicio == dados.length - 1){
                ponteiroInicio = -1;
            }
            quantidade--;
            ponteiroInicio++;
            elementoDesenfileirado = dados[ponteiroInicio];
        }else{
            System.err.println("Fila Vazia!");
        }
        return elementoDesenfileirado;
    }

    @Override
    public Object desenfileirarFim() {
        Object elementoDesenfileirado = null;
        if(!estaVazia()){
            elementoDesenfileirado = dados[ponteiroFim];
            ponteiroFim--;

            if(ponteiroFim == -1){
                ponteiroInicio = dados.length - 1; //impede que o ponteiroInicio fique com valor negativo e ocorra exceção
            }
            quantidade--;
        }else{
            System.err.println("Fila Vazia!");
        }
        return elementoDesenfileirado;
    }

    @Override
    public Object espiarInicio() {
        Object elementoInicio = null;
        if (!estaVazia()){
            elementoInicio = dados[ponteiroInicio];
        }else{
            System.err.println("Fila Vazia!");
        }
        return elementoInicio;
    }

    @Override
    public Object espiarFim() {
        Object elementoFim = null;
        if (!estaVazia()){
            elementoFim = dados[ponteiroFim];
        }else{
            System.err.println("Fila Vazia!");
        }
        return elementoFim;
    }

    @Override
    public boolean estaCheia() {
       return (quantidade == dados.length); // verifica se a quantidade de elementos é igual ao tamanho do array
                                            // fila cheia
    }

    @Override
    public boolean estaVazia() {
       return (quantidade == 0); // verifica se a quantidade de elementos é igual a 0
                                // fila vazia
    }

    @Override
    public String imprimir() {
        String resultado = "[";
        int i = ponteiroInicio + 1;
        for(int auxQuantidade = 0; auxQuantidade != quantidade; auxQuantidade++){
           if( i == dados.length){
                i = 0;
           }
           if(i == ponteiroFim){
               resultado += dados[i];
           }else{
                resultado += dados[i] + ", ";
            }
            i++;
        }        
        return resultado + "]";
    }
    
}
