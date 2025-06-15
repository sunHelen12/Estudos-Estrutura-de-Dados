import java.util.NoSuchElementException;

/**
 * Classe que representa uma Lista Dinâmica utilizando encadeamento duplo (lista duplamente ligada).
 * Permite inserção, remoção, atualização, impressão de elementos, seleção de elementos em posições específicas e
 * seleção de elementos por um array.
 *
 * @author Rocha, H.S.
 * @date 2023-06-14
 * @version 1.0
 *
 * @param <T> Tipo de dado armazenado na lista.
 */
public class ListaDinamica<T> implements Listavel<T> {

    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor padrão. Cria uma lista com capacidade máxima de 10 elementos.
     */
    public ListaDinamica() {
        this(10);
    }

    /**
     * Construtor que permite definir a capacidade máxima da lista.
     *
     * @param tamanho Capacidade máxima da lista.
     */
    public ListaDinamica(int tamanho) {
        ponteiroInicio = null;
        ponteiroFim = null;
        quantidade = 0;
        this.tamanho = tamanho;
    }

    /**
     * Adiciona um novo elemento ao final da lista.
     *
     * @param dado Elemento a ser adicionado.
     * @throws NoSuchElementException Caso a lista esteja cheia.
     */
    @Override
    public void anexar(T dado) {
        if (estaCheia()) {
            throw new NoSuchElementException("Lista Cheia!");
        }
        NodoDuplo<T> nodoTemporario = new NodoDuplo<>(dado);
        nodoTemporario.setAnterior(ponteiroFim);
        if (!estaVazia()) {
            ponteiroFim.setProximo(nodoTemporario);
        } else {
            ponteiroInicio = nodoTemporario; // Primeiro elemento da lista
        }
        ponteiroFim = nodoTemporario;
        quantidade++;
    }

    /**
     * Insere um elemento em uma posição específica da lista.
     *
     * @param posicao Posição onde o novo elemento será inserido (começando de 0).
     * @param dado    Elemento a ser inserido.
     * @throws NoSuchElementException  Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
    @Override
    public void inserir(int posicao, T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAux = ponteiroAux.getProximo();
        }

        NodoDuplo<T> nodoTemporario = new NodoDuplo<>(dado);
        nodoTemporario.setProximo(ponteiroAux);
        nodoTemporario.setAnterior(ponteiroAux.getAnterior());
        ponteiroAux.setAnterior(nodoTemporario);
        ponteiroAux.getProximo().setProximo(nodoTemporario);

        quantidade++;
    }

    /**
     * Retorna o elemento presente na posição especificada.
     *
     * @param posicao Posição do elemento desejado (começando de 0).
     * @return O elemento na posição especificada.
     * @throws NoSuchElementException  Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
    @Override
    public T selecionar(int posicao) {
        if (estaVazia()) {
            throw new NoSuchElementException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAux = ponteiroAux.getProximo();
        }
        return ponteiroAux.getDado();
    }

    /**
     * Retorna todos os elementos da lista em forma de array.
     *
     * @return Array contendo todos os elementos da lista.
     * @throws NoSuchElementException Se a lista estiver vazia.
     */
    @Override
    public T[] selecionarTodos() {
        if (estaVazia()) {
            throw new NoSuchElementException("Lista Vazia!");
        }

        T[] dados = (T[]) new Object[quantidade];
        NodoDuplo<T> ponteiroAux = ponteiroInicio;

        for (int i = 0; i < quantidade; i++) {
            dados[i] = ponteiroAux.getDado();
            ponteiroAux = ponteiroAux.getProximo();
        }
        return dados;
    }

    /**
     * Atualiza o elemento na posição especificada com um novo valor.
     *
     * @param posicao  Posição do elemento a ser atualizado (começando de 0).
     * @param novoDado Novo valor para o elemento.
     * @throws NoSuchElementException  Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
    @Override
    public void atualizar(int posicao, T novoDado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAux = ponteiroAux.getProximo();
        }
        ponteiroAux.setDado(novoDado);
    }

    /**
     * Remove e retorna o elemento da posição especificada.
     *
     * @param posicao Posição do elemento a ser removido (começando de 0).
     * @return O elemento que foi removido.
     * @throws NoSuchElementException  Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
    @Override
    public T apagar(int posicao) {
        if (estaVazia()) {
            throw new NoSuchElementException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new IndexOutOfBoundsException("Índice fora dos Limites");
        }

        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
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

    /**
     * Verifica se a lista está cheia.
     *
     * @return {@code true} se a quantidade de elementos for igual à capacidade máxima, senão {@code false}.
     */
    @Override
    public boolean estaCheia() {
        return (quantidade == tamanho);
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return {@code true} se a lista não tiver nenhum elemento, senão {@code false}.
     */
    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    /**
     * Retorna uma representação em String da lista, mostrando os elementos entre colchetes.
     *
     * @return String com os elementos da lista separados por vírgula.
     */
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
