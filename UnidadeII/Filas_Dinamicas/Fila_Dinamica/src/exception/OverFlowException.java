package exception;

/**
 * Exceção lançada quando ocorre um estouro (overflow) em uma estrutura de dados.
 * Por exemplo, ao tentar inserir um elemento em uma fila ou pilha que já está cheia.
 * @author Rocha, H.S.
 * @version 1.0
 * @since 2025-06-09
 */
public class OverFlowException extends RuntimeException {

    /**
     * Cria uma nova exceção OverFlowException com a mensagem especificada.
     *
     * @param message mensagem detalhando o motivo do estouro
     */
    public OverFlowException(String message) {
        super(message);
    }
}