package UnidadeII.Fila_Dinamica.Aula.Fila_Dinamica;

import UnidadeII.Fila_Dinamica.Aula.Interface.Enfileiravel;
import UnidadeII.Pilha_Dinamica.Aula.NodoDuplo;
import java.util.NoSuchElementException;

public class FilaDinamica implements Enfileiravel {

    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    public FilaDinamica(int tamanho) {
        this.ponteiroInicio = null;
        this.ponteiroFim = null;
        this.quantidade = 0;
        this.tamanho = tamanho;
    }

    public FilaDinamica() {
        this(10);
    }

    @Override
    public void enfileirarIncio(T dado) {
        throw new UnsupportedOperationException("Operação não suportada para essa fila.");
    }

    @Override
    public void enfileirarFim(T dado) {
         if (estaCheia()) {
            throw new NoSuchElementException("Fila Cheia!");
        }
        NodoDuplo<T> novoNodo = new  NodoDuplo(dado);
        novoNodo.setAnterior(ponteiroFim);
        if(!estaVazia()){
            ponteiroFim.setProximo(novoNodo);
        }else{
            ponteiroInicio = novoNodo; // Para não esquecermos o ponteiro Início no null quando inserir o 1º dado
        }     
        ponteiroFim = novoNodo;
        quantidade++;

    }

    @Override
    public T desenfileirarIincio() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila Vazia!");
        }

        T dadoInicio = ponteiroInicio.getDado();
        ponteiroInicio = ponteiroInicio.getProximo();
        ponteiroInicio.setAnterior(null);
        quantidade--;
        return dadoInicio;
    }

    @Override
    public T desenfileirarFim() {
        throw new UnsupportedOperationException("Operação não suportada para essa fila.");
    }

    @Override
    public T frente() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila Vazia!");
        }
        return ponteiroInicio.getDado();
    }

    @Override
    public T tras() {
        throw new UnsupportedOperationException("Operação não suportada para essa fila.");
    }

    @Override
    public void atualizarInicio(T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila Vazia!");
        }
        ponteiroInicio.setDado(dado);
    }

    @Override
    public void atualizarFim(T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila Vazia!");
        }
        ponteiroFim.setDado(dado);
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
    public String imprimirTras() {
        throw new UnsupportedOperationException("Operação não suportada para essa fila.");

    }

    @Override
    public String imprimirFrente() {
        String retorno = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
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
