import models.FilaDinamicaDuplaTerminacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exception.OverFlowException;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FilaDinamicaDuplaTerminacaoTest {
    private FilaDinamicaDuplaTerminacao<Integer> fila;

    @BeforeEach
    void setUp() {
        fila = new FilaDinamicaDuplaTerminacao<>(3);
    }

    @Test
    void testEnfileirarInicioEFim() {
        fila.enfileirarInicio(1);
        fila.enfileirarFim(2);
        fila.enfileirarInicio(0);
        assertEquals("[0, 1, 2]", fila.imprimirFrente());
        assertEquals("[2, 1, 0]", fila.imprimirTras());
    }

    @Test
    void testOverflow() {
        fila.enfileirarFim(1);
        fila.enfileirarFim(2);
        fila.enfileirarFim(3);
        assertThrows(OverFlowException.class, () -> fila.enfileirarFim(4));
    }

    @Test
    void testDesenfileirarInicio() {
        fila.enfileirarFim(1);
        fila.enfileirarFim(2);
        assertEquals(1, fila.desenfileirarInicio());
        assertEquals(2, fila.frente());
    }

    @Test
    void testDesenfileirarFim() {
        fila.enfileirarFim(1);
        fila.enfileirarFim(2);
        assertEquals(2, fila.desenfileirarFim());
        assertEquals(1, fila.tras());
    }

    @Test
    void testAtualizarInicioEFim() {
        fila.enfileirarFim(1);
        fila.enfileirarFim(2);
        fila.atualizarInicio(10);
        fila.atualizarFim(20);
        assertEquals(10, fila.frente());
        assertEquals(20, fila.tras());
    }

    @Test
    void testEstaVaziaECheia() {
        assertTrue(fila.estaVazia());
        fila.enfileirarFim(1);
        fila.enfileirarFim(2);
        fila.enfileirarFim(3);
        assertTrue(fila.estaCheia());
    }

    @Test
    void testExcecaoFilaVazia() {
        assertThrows(NoSuchElementException.class, () -> fila.frente());
        assertThrows(NoSuchElementException.class, () -> fila.tras());
        assertThrows(NoSuchElementException.class, () -> fila.desenfileirarInicio());
        assertThrows(NoSuchElementException.class, () -> fila.desenfileirarFim());
        assertThrows(NoSuchElementException.class, () -> fila.imprimirFrente());
        assertThrows(NoSuchElementException.class, () -> fila.imprimirTras());
        assertThrows(NoSuchElementException.class, () -> fila.atualizarInicio(1));
        assertThrows(NoSuchElementException.class, () -> fila.atualizarFim(1));
    }
}