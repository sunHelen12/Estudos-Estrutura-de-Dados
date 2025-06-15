package exception;

/**
 * Exceção lançada quando ocorre uma tentativa de inserção em uma estrutura de dados que já está cheia.
 *
 * @author Rocha, H.S.
 * @since 2025-06-09
 * @version 1.0
 */
public class OverFlowException extends RuntimeException {

    /**
     * Construtor que recebe uma mensagem descritiva para a exceção.
     *
     * @param message Mensagem detalhando o motivo da exceção.
     */
    public OverFlowException(String message) {
        super(message);
    }
}