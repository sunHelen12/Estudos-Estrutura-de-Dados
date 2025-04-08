package Listas_Estaticas.Lista_Estatica_Circular.Aula_3.Revisando;

public class ListaEstaticaCircular implements Listavel {
    //Variáveis de instância
    private int ponteiroInicio, ponteiroFim, quantidade;
    Object [] elementos;

    //Constutores
    public ListaEstaticaCircular(int tamanho) {
        this.elementos = new Object[tamanho]; //inicializamos
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        quantidade = 0;
    }

    public ListaEstaticaCircular() {
        this(10);
    }

    @Override
    public void anexar(Object elemento) {
        if(!estaCheia()){
            ponteiroFim ++; //ponteiroFim avança para a próxima posição para não sobrescrever o elemento atual
            if(ponteiroFim == elementos.length){ //se o ponteiroFim chegar no final do vetor, ele volta para o início
                ponteiroFim = 0; //se o ponteiroFim chegar no final do vetor, ele volta para o início
            }
            quantidade++; //quando há inserções aumentamos a quantidade de  inserções
            elementos[ponteiroFim] = elemento; //adicionamos o elemento na posição do ponteiroFim
        } else {
            System.err.println("Fila cheia");
        }
    }

    //Método para que o usuário possa inserir um elemento em uma posição específica
    @Override
    public void inserir(Object elemento, int posicao) {
        if(!estaCheia()){
            //verificar se a posição está dentro do limite do vetor
            if(posicao >= 0 && posicao <= quantidade){
                int pontoManipulacao = (ponteiroInicio + posicao) % elementos.length; //calcular a posição do elemento que será inserido
            
                for (int i = ponteiroFim + 1; i != pontoManipulacao; i--){
                    int anterior = i - 1;
                    
                    if (i == elementos.length){
                        i = 0; //se o i chegar no final do vetor, ele volta para o início
                    }

                    int atual = i;
                    elementos[atual] = elementos[anterior]; //deslocar os elementos para a direita
                }

                elementos[pontoManipulacao] = elemento; //adicionamos o elemento na posição do ponteiroFim
                ponteiroFim++; //ponteiroFim avança para a próxima posição para não sobrescrever o elemento atual
                //para manter a lista circular, se o ponteiroFim chegar no final do vetor, ele volta para o início
                if(ponteiroFim == elementos.length){ 
                    ponteiroFim = 0; //se o ponteiroFim chegar no final do vetor, ele volta para o início
                }
                quantidade++; //quando há inserções aumentamos a quantidade de  inserções   
            }else{
                System.err.println("Posição inválida");
            }
        } else {
            System.err.println("Lista cheia");
        }
    }

    @Override
    public Object selecionar(int posicao) {
       Object elementoSelecionado = null;
       if(!estaVazia()){
        //verificar se a posição está dentro do limite do vetor
            if(posicao>= 0 && posicao < quantidade){
                int pontoManipulacao = (ponteiroInicio + posicao) % elementos.length; //calcular a posição do elemento que será selecionado 
                elementoSelecionado = elementos[pontoManipulacao]; //adicionamos o elemento da posicao ao elementoSelecionado                    
            }else{
                System.err.println("Posição inválida");
            }
        } else {
            System.err.println("Lista vazia");
        }
       return elementoSelecionado;
    }

    @Override
    public Object[] selecionarTodos() {
        Object[] elementoSelecionado = new Object[quantidade];
        if(!estaVazia()){
            int recebePosicaoFisica = ponteiroInicio;            
            for(int i = 0; i < quantidade; i++){
                elementoSelecionado[i] = elementos[recebePosicaoFisica + i % elementos.length];                 
            } 
        }else{
            System.err.println("Lista vazia!");
        }
        return elementoSelecionado;
    }

    @Override
    public void atualizar(int posicao, Object novoElemento) {
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                int pontoManipulacao = (ponteiroInicio + posicao) % elementos.length; //calcular a posição do elemento que será selecionado
                elementos[pontoManipulacao] = novoElemento; //adicionamos o elemento da posicao ao elementoSelecionado
            } else {
                System.err.println("Posição inválida");
            }
        } else {
            System.err.println("Lista vazia");
        }
    }

    @Override
    public Object remover(int posicao) {
        Object elementoSelecionado = null;
        if(!estaVazia()){
            //verificar se a posição está dentro do limite do vetor
            if(posicao>= 0 && posicao < quantidade){
                int pontoManipulacao = (ponteiroInicio + posicao) % elementos.length; //calcular a posição do elemento que será selecionado 
                elementoSelecionado = elementos[pontoManipulacao]; //adicionamos o elemento da posicao ao elementoSelecionado
                for (int i = pontoManipulacao; i != ponteiroFim; i++){
                    int atual = i;
                    if (i == elementos.length - 1){
                        i = -1; //se o i chegar no final do vetor, ele volta para o início
                    }
                    int proximo = i + 1;
                    elementos[atual] = elementos[proximo]; //deslocar os elementos para a esquerda
                } 
                ponteiroFim--; //ponteiroFim avança para a próxima posição para não sobrescrever o elemento atual
                if(ponteiroFim == -1){
                    ponteiroFim = elementos.length - 1; //se o ponteiroFim chegar no final do vetor, ele volta para o início
                }
                quantidade--; //diminuimos a quantidade de  inserções
                    
            }else{
                System.err.println("Posição inválida");
            }
        } else {
            System.err.println("Lista vazia");
        }
        return elementoSelecionado;
    }

    @Override
    public boolean estaCheia() {
       return (quantidade == elementos.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimir() {
        //Mesma configuração da fila circular
        String resultado = "[";
        for (int i = 0, ponteiroAux = ponteiroInicio; i < quantidade; i++, ponteiroAux++){
            if(i == quantidade - 1){
                resultado += elementos[ponteiroAux % elementos.length];
            } else {
                resultado += elementos[ponteiroAux % elementos.length] + ", ";
            }
        }
        return resultado + "]";
    }


}
