package exception;

/**
 * Exceção lançada para indicar que ocorreu um underflow em uma estrutura de dados,
 * como ao tentar remover um elemento de uma lista ou pilha vazia.
 *
 * @author Rocha, H.S.
 * @since 2025-06-09
 * @version 1.0
 */
public class UnderFlowException extends RuntimeException {
    /**
     * Cria uma nova instância de UnderFlowException com a mensagem especificada.
     *
     * @param message a mensagem detalhando o motivo da exceção
     */
    public UnderFlowException(String message) {
        super(message);
    }
}