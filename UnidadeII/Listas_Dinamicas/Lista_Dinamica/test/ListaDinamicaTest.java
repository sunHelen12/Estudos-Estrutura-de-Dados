
import exception.OverFlowException;
import exception.UnderFlowException;
import models.ListaDinamica;
import models.Listavel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaDinamicaTest {

    private ListaDinamica<String> lista;

    @Before
    public void setUp() {
        lista = new ListaDinamica<>(3);
    }

    @Test
    public void testAnexar() {
        Listavel<String> lista = new ListaDinamica<>(3);
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        assertEquals("A", lista.selecionar(0));
        assertEquals("B", lista.selecionar(1));
        assertEquals("C", lista.selecionar(2));
    }

    @Test(expected = OverFlowException.class)
    public void testAnexarQuandoCheia() {
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        lista.anexar("D"); // Deve lançar exceção
    }

    @Test
    public void testInserir() {
        lista.anexar("A");
        lista.anexar("C");
        lista.inserir(1, "B");
        assertEquals("B", lista.selecionar(1));
    }

    @Test(expected = OverFlowException.class)
    public void testInserirEmListaCheia() {
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        lista.inserir(0, "X"); // Agora a lista está cheia
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInserirEmPosicaoInvalida() {
        lista.anexar("A");
        lista.inserir(5, "X"); // Índice fora
    }

    @Test
    public void testSelecionar() {
        lista.anexar("A");
        lista.anexar("B");
        assertEquals("A", lista.selecionar(0));
        assertEquals("B", lista.selecionar(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSelecionarPosicaoInvalida() {
        lista.anexar("A");
        lista.selecionar(5); // Índice inválido
    }

    @Test
    public void testSelecionarTodos() {
        lista.anexar("X");
        lista.anexar("Y");
        String[] esperado = {"X", "Y"};
        assertArrayEquals(esperado, lista.selecionarTodos());
    }

    @Test
    public void testAtualizar() {
        lista.anexar("Velho");
        lista.atualizar(0, "Novo");
        assertEquals("Novo", lista.selecionar(0));
    }

    @Test(expected = UnderFlowException.class)
    public void testAtualizarEmListaVazia() {
        lista.atualizar(0, "Qualquer");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAtualizarPosicaoInvalida() {
        lista.anexar("A");
        lista.atualizar(3, "X");
    }

    @Test
    public void testApagar() {
        lista.anexar("A");
        lista.anexar("B");
        String removido = lista.apagar(0);
        assertEquals("A", removido);
        assertEquals("B", lista.selecionar(0));
    }

    @Test(expected = UnderFlowException.class)
    public void testApagarEmListaVazia() {
        lista.apagar(0);
    }

    @Test
    public void testEstaCheiaEVazia() {
        assertTrue(lista.estaVazia());
        lista.anexar("1");
        assertFalse(lista.estaVazia());
        lista.anexar("2");
        lista.anexar("3");
        assertTrue(lista.estaCheia());
    }

    @Test
    public void testImprimir() {
        lista.anexar("X");
        lista.anexar("Y");
        assertEquals("[X, Y]", lista.imprimir());
    }
}