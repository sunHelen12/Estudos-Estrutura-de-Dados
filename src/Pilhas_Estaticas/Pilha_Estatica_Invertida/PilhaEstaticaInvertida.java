package Pilhas_Estaticas.Pilha_Estatica_Invertida;

public class PilhaEstaticaInvertida implements Empilhavel{
    private int indice;
    private int tamanho;
    Object[] dados;
    
    public PilhaEstaticaInvertida() {
        this(10);
    }

    public PilhaEstaticaInvertida(int tamanho){
        indice = tamanho;
        this.tamanho = tamanho;
        dados = new Object[tamanho];
    }

    @Override
    public void empilhar(Object elemento) {       
        if (!estaCheia()){
            indice--;
            dados[indice] = elemento;               
        }else{
            System.out.println("Pilha Cheia!");
        }
    }

    @Override
    public Object desempilhar() {
        Object dadoTopo = null;
        if(!estaVazia()){
            dadoTopo = dados[indice];
            indice++;
        }else{
            System.out.println("Pilha Vazia!");
        }

        return dadoTopo;
    }

    @Override
    public Object topo() {
        Object dadoTopo = null;
        if(!estaVazia()){
            dadoTopo = dados[indice];
        }else{
            System.out.println("Pilha Vazia!");
        }
        
        return dadoTopo;

    }

    @Override
    public boolean estaCheia() {
        return (indice == 0);
    }

    @Override
    public boolean estaVazia() {
        return (indice == tamanho);
    }

    @Override
    public String imprimir(){
        String resultado = "[";
        for (int i = indice; i <= tamanho - 1; i++){
            if(i == tamanho - 1){
                resultado += dados[i];
            } else {
                resultado += dados[i] + ", ";
            }
        }
        return resultado + "]";
    }

}