import models.PilhaDinamica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PilhaDinamicaTest {

    @Test
    void testEmpilharEDesempilhar() {
        PilhaDinamica<Integer> pilha = new PilhaDinamica<>(3);
        pilha.empilhar(10);
        pilha.empilhar(20);
        pilha.empilhar(30);
        assertEquals(30, pilha.desempilhar());
        assertEquals(20, pilha.desempilhar());
        assertEquals(10, pilha.desempilhar());
        assertTrue(pilha.estaVazia());
    }

    @Test
    void testAtualizar() {
        PilhaDinamica<String> pilha = new PilhaDinamica<>();
        pilha.empilhar("A");
        pilha.atualizar("B");
        assertEquals("B", pilha.espiar());
    }

    @Test
    void testEspiar() {
        PilhaDinamica<Double> pilha = new PilhaDinamica<>();
        pilha.empilhar(1.5);
        assertEquals(1.5, pilha.espiar());
    }

    @Test
    void testEstaCheia() {
        PilhaDinamica<Integer> pilha = new PilhaDinamica<>(2);
        pilha.empilhar(1);
        pilha.empilhar(2);
        assertTrue(pilha.estaCheia());
    }

    @Test
    void testImprimir() {
        PilhaDinamica<Integer> pilha = new PilhaDinamica<>(3);
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        assertEquals("[3, 2, 1]", pilha.imprimir());
    }

    @Test
    void testExcecaoDesempilharVazia() {
        PilhaDinamica<Integer> pilha = new PilhaDinamica<>();
        assertThrows(java.util.NoSuchElementException.class, pilha::desempilhar);
    }

    @Test
    void testExcecaoEmpilharCheia() {
        PilhaDinamica<Integer> pilha = new PilhaDinamica<>(1);
        pilha.empilhar(1);
        assertThrows(exception.OverFlowException.class, () -> pilha.empilhar(2));
    }
}