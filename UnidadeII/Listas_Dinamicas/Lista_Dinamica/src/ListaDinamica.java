import java.util.NoSuchElementException;

public class ListaDinamica <T> implements Listavel <T> {

    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    public ListaDinamica() {
        this(10);
    }

    public ListaDinamica(int tamanho) {
        ponteiroInicio = null;
        ponteiroFim = null;
        quantidade = 0;
        this.tamanho = tamanho;
    }

    @Override
    public void anexar(T dado) {
        if (estaCheia()) {
            throw new NoSuchElementException("Lista Cheia!");
        }
        NodoDuplo<T> nodoTemporario = new NodoDuplo(dado);
        nodoTemporario.setAnterior(ponteiroFim);
        if(!estaVazia()){
            ponteiroFim.setProximo(nodoTemporario);
        }else{
            ponteiroInicio = nodoTemporario; // Para não esquecermos o ponteiro Início no null quando inserir o 1º dado
        }
        ponteiroFim = nodoTemporario;
        quantidade++;
    }

    @Override
    public void inserir(int posicao, T dado) {
        if(estaVazia()){
            throw new NoSuchElementException("Lista Vazia!");
        }

        if (posicao < 0 || posicao >= quantidade){
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;

        for (int i = 0; i <= posicao; i++){
            ponteiroAux = ponteiroAux.getProximo();
        }

        NodoDuplo<T> nodoTemporario = new NodoDuplo<>(dado);
        nodoTemporario.setProximo(ponteiroAux);
        nodoTemporario.setAnterior(ponteiroAux.getAnterior());
        ponteiroAux.setAnterior(nodoTemporario);
        ponteiroAux.getProximo().setProximo(nodoTemporario);

        quantidade++;
    }

    @Override
    public T selecionar(int posicao) {
        if(estaVazia()){
            throw new NoSuchElementException("Lista Vazia!");
        }
        // não (A e B) = não A ou não B
        if (posicao < 0 || posicao >= quantidade){
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;

        for (int i = 0; i <= posicao; i++){
            ponteiroAux = ponteiroAux.getProximo();
        }
        return ponteiroAux.getDado();
    }

    @Override
    public T[] selecionarTodos() {

        if(estaVazia()){
            throw new NoSuchElementException("Lista Vazia!");
        }

        T[] dados = (T[]) new  Object[quantidade];
        NodoDuplo <T> ponteiroAux = ponteiroInicio;

        for (int i = 0; i < quantidade; i++) {
           dados[i] = ponteiroAux.getDado();
           ponteiroAux = ponteiroAux.getProximo();
        }
        return dados;
    }

    @Override
    public void atualizar(int posicao, T novoDado) {
        if(estaVazia()){
            throw new NoSuchElementException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade){
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;

        for (int i = 0; i <= posicao; i++){
            ponteiroAux = ponteiroAux.getProximo();
        }
        ponteiroAux.setDado(novoDado);
    }

    @Override
    public T apagar(int posicao) {
        if(estaVazia()){
            throw new NoSuchElementException("Lista Vazia!");
        }

        if (posicao < 0 || posicao >= quantidade){
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;

        for (int i = 0; i <= posicao; i++){
            ponteiroAux = ponteiroAux.getProximo();
        }

        T dadoRemovido = ponteiroAux.getDado();

        if (ponteiroAux.getAnterior() != null) {
            ponteiroAux.getAnterior().setProximo(ponteiroAux.getProximo());
        } else {
            ponteiroInicio = ponteiroAux.getProximo();
        }

        if (ponteiroAux.getProximo() != null) {
            ponteiroAux.getProximo().setAnterior(ponteiroAux.getAnterior());
        } else {
            ponteiroFim = ponteiroAux.getAnterior();
        }

        quantidade--;
        return dadoRemovido;
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == tamanho);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimir() {
        String resultado = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            resultado += ponteiroAux.getDado();

            if (i != quantidade - 1) {
                resultado += ", ";
            }
            ponteiroAux = ponteiroAux.getProximo();
        }
        return resultado += "]";
    }
}
