package models;

import exception.OverFlowException;

import java.util.NoSuchElementException;

/**
* Implementação de uma pilha dinâmica utilizando nós duplamente encadeados.
* Permite operações de empilhar, desempilhar, atualizar, espiar e imprimir elementos,
* além de verificar se a pilha está cheia ou vazia.
*
* @param <T> Tipo dos elementos armazenados na pilha.
* @author Rocha, H.S.
* @version 1.0
* @since 2025-05-01
*/
public class PilhaDinamica<T> implements Empilhavel<T> {
    /** Referência para o topo da pilha. */
    private NodoDuplo<T> ponteiroTopo;
    /** Quantidade de elementos na pilha. */
    private int quantidade;
    /** Capacidade máxima da pilha. */
    private int tamanho;

    /**
     * Construtor que define o tamanho máximo da pilha.
     * @param tamanho Capacidade máxima da pilha.
     */
    public PilhaDinamica(int tamanho) {
        quantidade = 0;
        ponteiroTopo = null;
        this.tamanho = tamanho;
    }

    /**
     * Construtor padrão que define o tamanho máximo como 10.
     */
    public PilhaDinamica() {
        this(10);
    }

    /**
     * Empilha um novo elemento no topo da pilha.
     * @param dado Elemento a ser empilhado.
     * @throws NoSuchElementException se a pilha estiver cheia.
     */
    @Override
    public void empilhar(T dado) {
        if (estaCheia()) {
            throw new OverFlowException("Pilha Cheia!");
        }
        NodoDuplo<T> novoDado = new NodoDuplo<>(dado);
        novoDado.setAnterior(ponteiroTopo);

        if (!estaVazia()) {
            ponteiroTopo.setProximo(novoDado);
        }
        ponteiroTopo = novoDado;
        quantidade++;
    }

    /**
     * Atualiza o elemento do topo da pilha.
     * @param dado Novo valor para o topo.
     * @throws NoSuchElementException se a pilha estiver vazia.
     */
    @Override
    public void atualizar(T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }
        ponteiroTopo.setDado(dado);
    }

    /**
     * Remove e retorna o elemento do topo da pilha.
     * @return Elemento removido do topo.
     * @throws NoSuchElementException se a pilha estiver vazia.
     */
   @Override
   public T desempilhar() {
       if (estaVazia()) {
           throw new NoSuchElementException("Pilha Vazia!");
       }
       T retorno = ponteiroTopo.getDado();
       ponteiroTopo = ponteiroTopo.getAnterior();
       if (ponteiroTopo != null) {
           ponteiroTopo.setProximo(null);
       }
       quantidade--;
       return retorno;
   }

    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     * @return Elemento do topo.
     * @throws NoSuchElementException se a pilha estiver vazia.
     */
    @Override
    public T espiar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }
        return ponteiroTopo.getDado();
    }

    /**
     * Verifica se a pilha está cheia.
     * @return true se a pilha estiver cheia, false caso contrário.
     */
    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    /**
     * Verifica se a pilha está vazia.
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    /**
     * Retorna uma representação em string dos elementos da pilha.
     * @return String com os elementos da pilha.
     */
    @Override
    public String imprimir() {
        String retorno = "[";
        NodoDuplo<T> ponteiroAux = ponteiroTopo;
        for (int i = 0; i < quantidade; i++) {
            retorno += ponteiroAux.getDado();

            if (i != quantidade - 1) {
                retorno += ", ";
            }
            ponteiroAux = ponteiroAux.getAnterior();
        }
        return retorno += "]";
    }
}
