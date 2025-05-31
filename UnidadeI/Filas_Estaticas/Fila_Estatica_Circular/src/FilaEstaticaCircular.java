public class FilaEstaticaCircular implements Enfileiravel {
    // Variáveis de instância
    private int ponteiroInicio, ponteiroFim, quantidade;
    private Object[] elementos;

    // Constutores
    public FilaEstaticaCircular(int tamanho) {
        this.elementos = new Object[tamanho]; // inicializamos
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        quantidade = 0;
    }

    public FilaEstaticaCircular() {
        this(10);
    }

    @Override
    public void enfileirar(Object elemento) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim); //para ela não chegar ao número inválido do tamanho
            elementos[ponteiroFim] = elemento;
            quantidade++;
        } else {
            System.out.println("Fila cheia");
        }
    }

    @Override
    public Object desenfileirar() {
        Object elementoRemovido = null;
        if (!estaVazia()) {
            elementoRemovido = elementos[ponteiroInicio];
            ponteiroInicio = avancar(ponteiroInicio);
            quantidade--;
        } else {
            System.out.println("Fila vazia");
        }
        return elementoRemovido;
    }


    @Override
    public Object frente() {
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
        return quantidade == elementos.length - 1;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimir() {
        String resultado = "[";
        int ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            // patch fila circular
            if (i == quantidade - 1) {
                resultado += elementos[ponteiroAux];
            }else{
                resultado += elementos[ponteiroAux] + ", ";
            }

            ponteiroAux = avancar(ponteiroAux);
        }
        return resultado + "]";
    }

    private int avancar(int ponteiro){
        return ((ponteiro + 1) % elementos.length);
    }
}
