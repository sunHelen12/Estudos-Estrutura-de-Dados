import exception.OverFlowException;
import models.FilaDinamica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

/**
 * Classe de teste para models.FilaDinamica
 * 
 * @author Rocha, H.S.
 * @version 1.0
 */
public class FilaDinamicaTest {
    
    private FilaDinamica<Integer> fila;
    private FilaDinamica<String> filaString;
    
    @BeforeEach
    void setUp() {
        fila = new FilaDinamica<>(5); // Fila com capacidade 5
        filaString = new FilaDinamica<>(); // Fila com capacidade padrão (10)
    }
    
    @Test
    void testConstrutorComTamanho() {
        FilaDinamica<Integer> filaCustom = new FilaDinamica<>(3);
        assertTrue(filaCustom.estaVazia());
        assertFalse(filaCustom.estaCheia());
    }
    
    @Test
    void testConstrutorPadrao() {
        FilaDinamica<Integer> filaPadrao = new FilaDinamica<>();
        assertTrue(filaPadrao.estaVazia());
        assertFalse(filaPadrao.estaCheia());
    }
    
    @Test
    void testEnfileirarFim() {
        assertTrue(fila.estaVazia());
        
        fila.enfileirarFim(10);
        assertFalse(fila.estaVazia());
        assertEquals(10, fila.frente());
        
        fila.enfileirarFim(20);
        fila.enfileirarFim(30);
        assertEquals(10, fila.frente());
    }
    
    @Test
    void testEnfileirarFimFilaCheia() {
        // Enche a fila
        for (int i = 1; i <= 5; i++) {
            fila.enfileirarFim(i);
        }
        
        assertTrue(fila.estaCheia());
        
        // Tenta adicionar mais um elemento
        assertThrows(OverFlowException.class, () -> {
            fila.enfileirarFim(6);
        });
    }
    
    @Test
    void testFrente() {
        assertThrows(NullPointerException.class, () -> {
            fila.frente();
        });
        
        fila.enfileirarFim(100);
        assertEquals(100, fila.frente());
        
        fila.enfileirarFim(200);
        assertEquals(100, fila.frente()); // Frente não muda
    }
    
    @Test
    void testAtualizarFim() {
        assertThrows(NoSuchElementException.class, () -> {
            fila.atualizarFim(50);
        });
        
        fila.enfileirarFim(10);
        fila.enfileirarFim(20);
        
        fila.atualizarFim(99);
        // Verificar se o último elemento foi atualizado
        fila.enfileirarFim(30);
        assertEquals(10, fila.frente());
    }
    
    @Test
    void testDesenfileirarFim() {
        assertThrows(NoSuchElementException.class, () -> {
            fila.desenfileirarFim();
        });
        
        fila.enfileirarFim(10);
        fila.enfileirarFim(20);
        fila.enfileirarFim(30);
        
        assertEquals(30, fila.desenfileirarFim());
        assertEquals(20, fila.desenfileirarFim());
        assertEquals(10, fila.desenfileirarFim());
        
        assertTrue(fila.estaVazia());
    }
    
    @Test
    void testDesenfileirarFimUmElemento() {
        fila.enfileirarFim(42);
        assertEquals(42, fila.desenfileirarFim());
        assertTrue(fila.estaVazia());
    }
    
    @Test
    void testEstaVazia() {
        assertTrue(fila.estaVazia());
        
        fila.enfileirarFim(1);
        assertFalse(fila.estaVazia());
        
        fila.desenfileirarFim();
        assertTrue(fila.estaVazia());
    }
    
    @Test
    void testEstaCheia() {
        assertFalse(fila.estaCheia());
        
        // Enche a fila
        for (int i = 1; i <= 5; i++) {
            fila.enfileirarFim(i);
        }
        
        assertTrue(fila.estaCheia());
        
        fila.desenfileirarFim();
        assertFalse(fila.estaCheia());
    }
    
    @Test
    void testImprimirFrente() {
        assertThrows(NoSuchElementException.class, () -> {
            fila.imprimirFrente();
        });
        
        fila.enfileirarFim(1);
        assertEquals("]1]", fila.imprimirFrente());
        
        fila.enfileirarFim(2);
        fila.enfileirarFim(3);
        assertEquals("]1, 2, 3]", fila.imprimirFrente());
    }
    
    @Test
    void testImprimirFrenteComStrings() {
        filaString.enfileirarFim("A");
        filaString.enfileirarFim("B");
        filaString.enfileirarFim("C");
        
        assertEquals("]A, B, C]", filaString.imprimirFrente());
    }
    
    @Test
    void testOperacoesNaoSuportadas() {
        assertThrows(UnsupportedOperationException.class, () -> {
            fila.enfileirarInicio(1);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            fila.tras();
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            fila.atualizarInicio(1);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            fila.desenfileirarInicio();
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            fila.imprimirTras();
        });
    }
    
    @Test
    void testFluxoCompleto() {
        // Teste de um fluxo completo de operações
        assertTrue(fila.estaVazia());
        
        // Adiciona elementos
        fila.enfileirarFim(1);
        fila.enfileirarFim(2);
        fila.enfileirarFim(3);
        
        assertEquals(1, fila.frente());
        assertEquals("]1, 2, 3]", fila.imprimirFrente());
        
        // Atualiza o fim
        fila.atualizarFim(99);
        assertEquals("]1, 2, 99]", fila.imprimirFrente());
        
        // Remove elementos
        assertEquals(99, fila.desenfileirarFim());
        assertEquals(2, fila.desenfileirarFim());
        assertEquals(1, fila.desenfileirarFim());
        
        assertTrue(fila.estaVazia());
    }
    
    @Test
    void testCapacidadePadrao() {
        FilaDinamica<Integer> filaPadrao = new FilaDinamica<>();
        
        // Adiciona 10 elementos (capacidade padrão)
        for (int i = 1; i <= 10; i++) {
            filaPadrao.enfileirarFim(i);
        }
        
        assertTrue(filaPadrao.estaCheia());
        
        // Tenta adicionar o 11º elemento
        assertThrows(OverFlowException.class, () -> {
            filaPadrao.enfileirarFim(11);
        });
    }
}