package models;

import exception.OverFlowException;

import java.util.NoSuchElementException;
/**
 * Implementação de uma fila dinâmica simples
 * que permite inserções apenas no fim da fila e remoções apenas no início dela.
 *
 * @author Rocha, H.S.
 * @version 1.0
 * @since 2025-06-09
 *
 * @param <T> Tipo dos dados armazenados na fila.
 */
public class FilaDinamica <T> implements Enfileiravel<T> {
    /** Ponteiro para o Início da fila */
    private NodoDuplo<T> ponteiroInicio;
    /** Ponteiro para o fim da fila */
    private NodoDuplo<T> ponteiroFim;
    /** Quantidade de elementos da fila */
    private int quantidade;
    /** Tamanho da fila */
    private int tamanho;

    /**
     * Construtor com tamanho máximo da fila.
     *
     * @param tamanho Capacidade máxima da fila.
     */
    public FilaDinamica(int tamanho) {
        this.ponteiroInicio = null;
        this.ponteiroFim = null;
        this.quantidade = 0;
        this.tamanho = tamanho;
    }
    /**
     * Construtor com tamanho padrão (10 elementos).
    */
    public FilaDinamica(){
        this(10);
    }

    /**
     * Insere um elemento no início da fila.
     *
     * @throws UnsupportedOperationException operação não suportada para a fila simples
     */
    @Override
    public void enfileirarInicio(T dado) {
        throw new UnsupportedOperationException("Operação não suportada para esse tipo de fila!");
    }
    /**
     * Insere um elemento no final da fila.
     *
     * @param dado Elemento a ser inserido.
     * @throws OverFlowException Se a fila estiver cheia.
     */
    @Override
    public void enfileirarFim(T dado) {
        if (estaCheia()){
            throw new OverFlowException("Fila Cheia!");
        }
        NodoDuplo<T> nodoTemporario = new NodoDuplo<>(dado);

        if (!estaVazia()){
            ponteiroFim.setProximo(nodoTemporario);
            nodoTemporario.setAnterior(ponteiroFim);
        }else{
            ponteiroInicio = nodoTemporario;
        }

        ponteiroFim = nodoTemporario;
        quantidade++;
    }
    /**
     * Retorna o elemento no início da fila.
     *
     * @return Elemento da frente da fila.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    @Override
    public T frente() {
        return ponteiroInicio.getDado();
    }
    /**
     * Retorna o elemento no final da fila.
     *
     * @throws UnsupportedOperationException operação não suportada para a fila simples
     */
    @Override
    public T tras() {
        throw new UnsupportedOperationException("Operação não suportada para esse tipo de fila!");
    }

    /**
     * Atualiza o valor do primeiro elemento da fila.
     *
     * @throws UnsupportedOperationException operação não suportada para a fila simples
     */
    @Override
    public void atualizarInicio(T dado) {
        throw new UnsupportedOperationException("Operação não suportada para esse tipo de fila!");

    }

    /**
     * Atualiza o valor do último elemento da fila.
     *
     * @param dado Novo valor a ser atribuído.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    @Override
    public void atualizarFim(T dado) {
        if (estaVazia()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        ponteiroFim.setDado(dado);
    }
    /**
     * Remove e retorna o elemento do início da fila.
     *
     * @return Elemento removido.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    @Override
    public T desenfileirarFim() {
        if (estaVazia()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        T dadoDesenfilerado = ponteiroFim.getDado();
        ponteiroFim = ponteiroFim.getAnterior();

        if (ponteiroFim != null){
            ponteiroFim.setProximo(null);
        }else{
            ponteiroInicio = null;
        }
        quantidade--;
        return dadoDesenfilerado;
    }
    /**
     * Remove e retorna o elemento do final da fila.
     *
     * @throws UnsupportedOperationException operação não suportada para a fila simples
     */
    @Override
    public T desenfileirarInicio() {
        throw new UnsupportedOperationException("Operação não suportada para esse tipo de fila!");
    }
    /**
     * Verifica se a fila está cheia.
     *
     * @return retorna true se a fila estiver cheia, senão retorna false.
     */
    @Override
    public boolean estaCheia() {
        return (quantidade == tamanho);
    }
    /**
     * Verifica se a fila está vazia.
     *
     * @return retorna true se a fila estiver vazia, senão retorna false.
     */
    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }
    /**
     * Imprime os elementos da fila do início ao fim.
     *
     * @return String representando os elementos da fila.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    @Override
    public String imprimirFrente() {
        if (estaVazia()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        String resultado = "]";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++){
            resultado += ponteiroAux.getDado();
            if (i != quantidade - 1){
                resultado += ", ";
            }

            ponteiroAux = ponteiroAux.getProximo();
        }
        return resultado += "]";
    }
    /**
     * Imprime os elementos da fila do fim ao início.
     *
     * @throws UnsupportedOperationException operação não suportada para a fila simples
     */
    @Override
    public String imprimirTras() {
        throw new UnsupportedOperationException("Operação não suportada para esse tipo de fila!");
    }
}
