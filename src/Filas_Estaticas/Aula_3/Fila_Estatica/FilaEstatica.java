package Filas_Estaticas.Aula_3.Fila_Estatica;

public class FilaEstatica implements Enfileirarvel {
    // Variáveis de instância
    private int ponteiroInicio, ponteiroFim;
    private Object[] elementos;

    // Constutores
    public FilaEstatica(int tamanho) {
        this.elementos = new Object[tamanho]; // inicializamos
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
    }

    @Override
    public void enfileirar(Object elemento) {
        if (!estaCheia()) {
            ponteiroFim++;
            elementos[ponteiroFim] = elemento;
        } else {
            System.out.println("Fila cheia");
        }
    }

    @Override
    public Object desenfileirar() {
        Object elementoRemovido = null;
        if (!estaVazia()) {
            elementoRemovido = elementos[ponteiroInicio];
            ponteiroInicio++;
        } else {
            System.out.println("Fila vazia");
        }
        return elementoRemovido;
    }

    @Override
    public Object frente() { // espiar
        Object elementoFrente = null;
        if (!estaVazia()) {
            return elementos[ponteiroInicio];
        } else {
            System.out.println("Fila vazia");
        }
        return elementoFrente;
    }

    @Override
    public void atualizarInicio(Object elemento) {
        if (!estaVazia()) {
            elementos[ponteiroInicio] = elemento;
        } else {
            System.out.println("Fila vazia");
        }
    }

    @Override
    public void atualizarFim(Object elemento) {
        if (!estaVazia()) {
            elementos[ponteiroFim] = elemento;
        } else {
            System.out.println("Fila vazia");
        }
    }

    @Override
    public boolean estaCheia() {
        return (ponteiroFim == elementos.length - 1);
        // return (ponteiroFim < ponteiroInicio);
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroFim == ponteiroInicio - 1);
    }

    @Override
    public String imprimir() {
        String retorno = "[";
        for (int i = ponteiroInicio; i <= ponteiroFim; i++) {
            if (i == ponteiroFim) {
                retorno += elementos[i];
            } else {
                retorno += elementos[i] + ", ";
            }
        }
        return retorno + "]";
    }

}
