package UnidadeI.Pilhas_Estaticas.Aula_2.Pilha_Estatica_Fila;

public class PilhaEstatica implements Empilhavel{
    //variaveis de instancia
    private int ponteiroTopo; //indice    
    private Object[] dados; //array
    //métodos
    //construtores

    public PilhaEstatica(int tamanho){
        dados = new Object[tamanho];
        ponteiroTopo = - 1;
    }

    public PilhaEstatica(){
        this(10); //chamamos o outro construtor, quando precisarmos mudar
                         // só mudamos o primeiro construtor evitando inconsistência
    }

    //métodos principais
    @Override
    public void empilhar(Object elemento) {        
        if(!estaCheia()){
            ponteiroTopo++;
            dados[ponteiroTopo] = elemento;
        }else{
            System.err.println("Pilha Cheia!");
        }        
    }

    @Override
    public void atualizar(Object elemento) {        
        if(!estaVazia()){            
            dados[ponteiroTopo] = elemento;
        }else{
            System.err.println("Pilha Vazia!");
        }        
    }

    @Override
    public Object desempilhar() {
        Object dadoEspiado = null;
        if(!estaVazia()){
            dadoEspiado = dados[ponteiroTopo];
            ponteiroTopo--;
        }else{
            System.out.println("Pilha Vazia!");
        }
        return dadoEspiado;
    }

    @Override
    public Object espiar() {
        Object dadoEspiado = null;
        if(!estaVazia()){
            dadoEspiado = dados[ponteiroTopo];
        }else{
            System.out.println("Pilha Vazia!");
        }
        return dadoEspiado;
    }

    //métodos auxiliares
    @Override
    public boolean estaCheia() {
        return (ponteiroTopo == dados.length - 1); //porque o tamanho é 10, mas a pilha vai de 
                                                  // 0 a 9 (por isso - 1)
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroTopo == - 1);
    }

    @Override
    public String imprimir() {
        String aux = "[";
        for (int i = ponteiroTopo; i >= 0; i++){    //vamos até o  ponteiroTopo, porque lá deve estar o último 
           if(i == 0){                              //elemento implementado
                aux += dados[i];
           }else{
                aux += dados[i] + ", ";
           }                               
        }
        return aux + "]";
    }

}
