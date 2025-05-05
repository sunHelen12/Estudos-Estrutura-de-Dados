package UnidadeI.Filas_Estaticas.Revisando.Fila_Estatica;

public class FilaEstatica  implements Enfileiravel{
    private int ponteiroInicio, ponteiroFim;    
    private Object[] dados;

    public FilaEstatica(int tamanho){
        ponteiroInicio = 0;
        ponteiroFim = -1;
        dados = new Object[tamanho];
    }

    public FilaEstatica(){
        this(10); //chama o construtor com um argumento de tamanho 10 
                            //para inicializar o tamanho da fila
    }

    @Override
    public void enfileirar(Object elemento) {
        if (!estaCheia()){
            ponteiroFim++;
            dados[ponteiroFim] = elemento;
        }else{
            System.err.println("Fila Cheia!");
        }
    }

    @Override
    public Object desenfileirar() {
        Object elementoDesenfileirado = null;
        if(!estaVazia()){
            elementoDesenfileirado = dados[ponteiroInicio];
            ponteiroInicio ++;
        }else{
            System.err.println("Fila Vazia!");
        }
        return elementoDesenfileirado;        
    }

    @Override
    public Object espiar() {
       Object elementoEspiado = null;
       if (!estaVazia()){
            elementoEspiado = dados[ponteiroInicio];            
       }else{
            System.err.println("Fila Vazia!");
       }
       return elementoEspiado;
    }

    @Override
    public boolean estaCheia() {
       return (ponteiroFim == dados.length - 1);
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroInicio == ponteiroFim + 1);
    }

    @Override
    public String imprimir() {
        String elementos = "[";
        if(!estaVazia()){
            for(int i = ponteiroInicio; i <= ponteiroFim; i++){
                if(i == ponteiroFim){
                    elementos += dados[i];
                }else{
                    elementos += dados[i] + ", ";
                }
            }            
        }        
        return elementos + "]";
    }

    
}
