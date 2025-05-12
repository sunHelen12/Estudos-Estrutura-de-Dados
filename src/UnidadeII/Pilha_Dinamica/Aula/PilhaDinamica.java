package UnidadeII.Pilha_Dinamica.Aula;

import java.util.NoSuchElementException;

public class PilhaDinamica<T> implements Empilhavel<T> {
    private NodoDuplo<T> ponteiroTopo;
    private int quantidade;
    private int tamanho;
    
    public PilhaDinamica(int tamanho) {
        quantidade = 0;
        ponteiroTopo = null;
        this.tamanho = tamanho;
    }

    public PilhaDinamica() {
        this.(10);
    }

    @Override
    public void empilhar(T dado) {
        if (estaCheia()) {
              throw new NoSuchElementException("Pilha Cheia!");
        }
        NodoDuplo<T> novoDado = new NodoDuplo<T>(dado);
        novoDado.setAnterior(ponteiroTopo);

        if (!estaVazia()) {
            ponteiroTopo.setProximo(novoDado);
        }
        ponteiroTopo = novoDado;
        quantidade++;
    }

    @Override
    public void atualizar(T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }

        ponteiroTopo.setDado(dado);
    }

    @Override
    public T desempilhar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }
        T retorno = ponteiroTopo.getDado();
        ponteiroTopo = ponteiroTopo.getAnterior();
        ponteiroTopo.setProximo(null);
        quantidade--;
        return retorno;
    }

    @Override
    public T espiar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }
        return ponteiroTopo.getDado();
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

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
