/**
 * Interface que define as operações básicas para uma fila dinâmica com inserção e remoção
 * tanto no início quanto no fim da estrutura.
 *
 * @param <T> Tipo dos elementos armazenados na fila.
 * @author Rocha, H.R.
 * @version 1.0
 * @since 2025-05-01
 */
public interface Enfileiravel<T> {

    /**
     * Insere um elemento no início da fila.
     * @param dado Elemento a ser inserido.
     */
    void enfileirarInicio(T dado);

    /**
     * Insere um elemento no final da fila.
     * @param dado Elemento a ser inserido.
     */
    void enfileirarFim(T dado);

    /**
     * Retorna o elemento da frente da fila sem removê-lo.
     * @return Elemento da frente da fila.
     */
    T frente();

    /**
     * Retorna o elemento do final da fila sem removê-lo.
     * @return Elemento do final da fila.
     */
    T tras();

    /**
     * Atualiza o elemento do início da fila.
     * @param dado Novo valor para o início da fila.
     */
    void atualizarInicio(T dado);

    /**
     * Atualiza o elemento do final da fila.
     * @param dado Novo valor para o final da fila.
     */
    void atualizarFim(T dado);

    /**
     * Remove e retorna o elemento do final da fila.
     * @return Elemento removido do final da fila.
     */
    T desenfileirarFim();

    /**
     * Remove e retorna o elemento do início da fila.
     * @return Elemento removido do início da fila.
     */
    T desenfileirarInicio();

    /**
     * Verifica se a fila está cheia.
     * @return true se a fila estiver cheia, false caso contrário.
     */
    boolean estaCheia();

    /**
     * Verifica se a fila está vazia.
     * @return true se a fila estiver vazia, false caso contrário.
     */
    boolean estaVazia();

    /**
     * Retorna uma representação em string dos elementos da fila a partir da frente.
     * @return String com os elementos da fila do início ao fim.
     */
    String imprimirFrente();

    /**
     * Retorna uma representação em string dos elementos da fila a partir do final.
     * @return String com os elementos da fila do fim ao início.
     */
    String imprimirTras();
}
