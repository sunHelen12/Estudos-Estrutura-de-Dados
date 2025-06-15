/**
 * Interface que define as operações básicas para uma lista dinâmica genérica.
 *
 * @param <T> Tipo dos elementos armazenados na lista.
 *
 * @author Rocha, H.S.
 * @since 2025-06-14
 * @version 1.0
 * @since 2025-06-14
 */
public interface Listavel<T> {

    /**
     * Anexa (insere ao final) um novo elemento à lista.
     * @param dado Elemento a ser adicionado ao final da lista.
     */
    void anexar(T dado);

    /**
     * Insere um novo elemento em uma posição lógica informada.
     * @param posicao Posição onde o elemento será inserido.
     * @param dado Elemento a ser inserido.
     */
    void inserir(int posicao, T dado);

    /**
     * Retorna o elemento que está em uma posição lógica informada.
     * @param posicao Posição do elemento a ser retornado.
     * @return Elemento na posição informada.
     */
    T selecionar(int posicao);

    /**
     * Retorna todos os elementos da lista em um array.
     * @return Array contendo todos os elementos da lista.
     */
    T[] selecionarTodos();

    /**
     * Substitui o elemento de uma posição lógica informada por um novo elemento.
     * @param posicao Posição do elemento a ser substituído.
     * @param novoDado Novo elemento para substituir o antigo.
     */
    void atualizar(int posicao, T novoDado);

    /**
     * Remove e retorna o elemento de uma posição lógica informada.
     * @param posicao Posição do elemento a ser removido.
     * @return Elemento removido da posição informada.
     */
    T apagar(int posicao);

    /**
     * Verifica se a lista está cheia.
     * @return true se a lista estiver cheia, false caso contrário.
     */
    boolean estaCheia();

    /**
     * Verifica se a lista está vazia.
     * @return true se a lista estiver vazia, false caso contrário.
     */
    boolean estaVazia();

    /**
     * Retorna uma representação em string dos elementos da lista.
     * @return String com os elementos da lista.
     */
    String imprimir();
}