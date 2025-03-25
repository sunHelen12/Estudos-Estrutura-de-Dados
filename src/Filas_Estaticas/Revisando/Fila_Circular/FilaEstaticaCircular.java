package Filas_Estaticas.Revisando.Fila_Circular;

public class FilaEstaticaCircular implements Enfileiravel {
    private int ponteiroInicio, ponteiroFim, quantidade;
    private Object[] dados;

    public FilaEstaticaCircular(int tamanho) {
        quantidade = 0;
        ponteiroInicio = -1;
        ponteiroFim = -1;
        dados = new Object[tamanho];
    }

    public FilaEstaticaCircular() {
        this(10);
    }

    @Override
    public void enfileirar(Object elemento) {
        if (!estaCheia()) {
            ponteiroFim++;
            // patch fila circular
            if (ponteiroFim == dados.length - 1) {
                ponteiroFim = -1;
            }
            quantidade++;
            // fim do patch
            dados[ponteiroFim] = dados;
        } else {
            System.err.println("Fila cheia");
        }
    }

    @Override
    public Object desenfileirar() {
        Object elementoInicio = null;
        if (!estaVazia()) {
            // patch fila circular
            if (ponteiroInicio == dados.length - 1) {
                ponteiroInicio = -1;
            }
            quantidade--;
            // fim do patch
            ponteiroInicio++;
            elementoInicio = dados[ponteiroInicio];
        } else {
            System.err.println("Fila vazia");
        }
        return elementoInicio;
    }

    @Override
    public Object espiar() {
        Object elementoInicio = null;
        int ponteiroAux = ponteiroInicio;
        if (!estaVazia()) {
            // patch fila circular
            if (ponteiroAux == dados.length - 1) {
                ponteiroAux = -1;
            }
            // fim do patch
            elementoInicio = dados[ponteiroAux + 1];
        } else {
            System.err.println("Fila vazia");
        }
        return elementoInicio;
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimir() {
        String resultado = "[";
        int i = ponteiroInicio + 1;
        for (int auxQuantidade = 0; auxQuantidade != quantidade; auxQuantidade++) {
            // patch fila circular
            if (i == dados.length) {
                i = 0;
            }
            // fim do patch
            if (i == ponteiroFim) {
                resultado += dados[i];
            } else {
                resultado += dados[i] + ", ";
            }
            i++;
        }
        return resultado + "]";
    }

}
