public class Elemento<T> {
    //Elemento seriam o que representa o que está dentro dos nós da árvore.
    private T valor; //Será do tipo genérico.
    private Elemento<T> esquerda;
    private Elemento<T> direita;

    public Elemento(T novoValor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Elemento<T> getDireita() {
        return direita;
    }

    public void setDireita(Elemento<T> direita) {
        this.direita = direita;
    }

    public Elemento<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento<T> esquerda) {
        this.esquerda = esquerda;
    }
}

/**
 * Um elemento também possui filhos a esquerda e filhos a direita
 */