package Listas_Estaticas.Aula_4.Lista_Estatica;

public class ListaEstaticaCircular  implements  Listavel{

    private int ponteiroInicio, ponteiroFim, quantidade;
     private Object[] elementos;

     // Constutores
     public ListaEstaticaCircular(int tamanho) {
        this.elementos = new Object[tamanho]; // inicializamos
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        quantidade = 0;
   }

    public ListaEstaticaCircular() {
        this(10);
    }

    @Override
    public void inserir(Object elemento, int indice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }
    //mesmo código de enfileirar
    @Override
    public void anexar(Object elemento) {        
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim); 
            elementos[ponteiroFim] = elemento;            
            quantidade++;
        } else {
            System.out.println("Fila cheia");
        }
    }

    @Override
    public Object selecionar(int indice) {
        if(!estaCheia()){
            //verificar se a posição é válida
            if(indice >= 0 && indice < quantidade){
               int  posicaoFisica = mapeamento(indice);
               
            }
        }
    }

    @Override
    public Object[] selecionarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecionarTodos'");
    }

    @Override
    public void atualizar(Object elemento, int indice) {
        if(!estaVazia()){
            if(indice >= 0 && indice < quantidade){
                int posicaoFisica = mapeamento(indice);
                elementos[posicaoFisica] = elemento;
            }else{
                System.err.println("Índice inválido!");
            }
        }else{
            System.err.println("Lista Vazia!");
        }
    }

    @Override
    public Object apagar(int indice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apagar'");
    }

    @Override
    public boolean contem(Object elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contem'");
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

    private int avancar(int ponteiro){
        return ((ponteiro + 1) % elementos.length); //para ela não chegar ao número inválido do tamanho
    }

    private int mapeamento (int indice){
        return (indice + ponteiroInicio) % elementos.length;
    }
    
}
