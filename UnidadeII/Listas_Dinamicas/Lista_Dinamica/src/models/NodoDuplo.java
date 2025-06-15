package models;

/**
 * Classe que representa um nó duplo utilizado em estruturas de dados dinâmicas,
 * como listas duplamente encadeadas ou pilhas dinâmicas.
 * Cada nó armazena um dado genérico e referências para o nó anterior e o próximo.
 *
 * @param <T> Tipo dos dados armazenados no nó.
 * @author Rocha, H.S.
 * @version 1.0
 * @since 2025-06-09
 */
public class NodoDuplo <T> {
    /** Referência para o nó anterior. */
    private NodoDuplo <T> anterior;
    /** Dado armazenado no nó. */
    private T dado;
    /** Referência para o próximo nó. */
    private NodoDuplo <T> proximo;

    /**
     * Construtor que inicializa o nó com o dado informado.
     * As referências anterior e próximo são inicializadas como null.
     *
     * @param dado Dado a ser armazenado no nó.
     */
    public NodoDuplo(T dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }

    /**
     * Retorna o nó anterior.
     * @return Referência para o nó anterior.
     */
    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    /**
     * Define o nó anterior.
     * @param anterior Referência para o nó anterior.
     */
    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    /**
     * Retorna o dado armazenado no nó.
     * @return Dado do tipo T.
     */
    public T getDado() {
        return dado;
    }

    /**
     * Define o dado armazenado no nó.
     * @param dado Novo dado do tipo T.
     */
    public void setDado(T dado) {
        this.dado = dado;
    }

    /**
     * Retorna o próximo nó.
     * @return Referência para o próximo nó.
     */
    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    /**
     * Define o próximo nó.
     * @param proximo Referência para o próximo nó.
     */
    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }
}
