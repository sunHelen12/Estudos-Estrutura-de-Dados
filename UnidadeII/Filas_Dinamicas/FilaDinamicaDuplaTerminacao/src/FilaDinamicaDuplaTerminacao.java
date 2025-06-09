import exception.OverFlowException;

import java.util.NoSuchElementException;

public class FilaDinamicaDuplaTerminacao<T> implements Enfileiravel<T> {
    private NodoDuplo <T> ponteiroInicio = null;
    private NodoDuplo <T> ponteiroFim= null;
    private int quantidade;
    private int tamanho;

    public FilaDinamicaDuplaTerminacao(int tamanho) {
        this.quantidade = 0;
        this.ponteiroInicio = ponteiroInicio;
        this.ponteiroFim = ponteiroFim;
        this.tamanho = tamanho;
    }

    public FilaDinamicaDuplaTerminacao() {
        this(10);
    }

    @Override
    public void enfileirarInicio(T dado) {
        if (estaCheia()){
            throw new OverFlowException("Fila Cheia");
        }
        // Criamos um nó temporário e já setamos o novo dado para ele
        NodoDuplo<T> nodoTemporario = new NodoDuplo<>(dado);
        if (!estaVazia()) {
            nodoTemporario.setProximo(ponteiroInicio); // O novoDado será o próximo ao ponteiroInicio
            ponteiroInicio.setAnterior(nodoTemporario); // O Anterior de ponteiroInicio será o novoDado
        }else {
            ponteiroFim = nodoTemporario; // O ponteiroInicio sai de null e avança para o novoDado adicionado
        }
        ponteiroInicio = nodoTemporario; // Agora movemos o ponteiroInicio para o novoDado
        quantidade++;
    }

    @Override
    public void enfileirarFim(T dado) {
        if (estaCheia()){
            throw new OverFlowException("Fila Cheia");
        }
        // Criamos um nó temporário e já setamos o novo dado para ele
        NodoDuplo<T> nodoTemporario = new NodoDuplo<>(dado);
        if (!estaVazia()) {
            ponteiroFim.setProximo(nodoTemporario); // O próximo de ponteiroFim será o novoDado
            nodoTemporario.setAnterior(ponteiroFim); // O anterior do novoDado será apontado para o ponteiroFim
        }else {
            ponteiroInicio = nodoTemporario; // O ponteiroInicio sai de null e avança para o novoDado adicionado
        }
        ponteiroFim = nodoTemporario; // Agora movemos o ponteiroFim para o novoDado
        quantidade++;
    }

    @Override
    public T frente() {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia");
        }
        return ponteiroInicio.getDado();
    }

    @Override
    public T tras() {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia");
        }
        return ponteiroFim.getDado();
    }

    @Override
    public void atualizarInicio(T dado) {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia");
        }
        ponteiroInicio.setDado(dado);
    }

    @Override
    public void atualizarFim(T dado) {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia");
        }
        ponteiroFim.setDado(dado);
    }

    @Override
    public T desenfileirarFim() {
        return null;
    }

    @Override
    public T desenfileirarInicio() {
        return null;
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
    public String imprimirFrente() {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        String resultado = "[";
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

    @Override
    public String imprimirTras() {
        String resultado = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++){
            resultado += ponteiroAux.getDado();
            if (i != quantidade - 1){
                resultado += ", ";
            }
            ponteiroAux = ponteiroAux.getAnterior();
        }
        return resultado += "]";
    }
}
