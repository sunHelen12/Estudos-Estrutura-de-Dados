import java.util.NoSuchElementException;

public class FilaDinamica <T> implements Enfileiravel<T> {
    private NodoDuplo <T> ponteiroInicio = null;
    private NodoDuplo <T> ponteiroFim= null;
    private int quantidade;
    private int tamanho;

    public FilaDinamica(int tamanho) {
        this.quantidade = 0;
        this.ponteiroInicio = ponteiroInicio;
        this.ponteiroFim = ponteiroFim;
        this.tamanho = tamanho;
    }

    public FilaDinamica() {
        this(10);
    }

    @Override
    public void enfileirarInicio(T dado) {
        
    }

    @Override
    public void enfileirarFim(T dado) {

    }

    @Override
    public T frente() {
        return null;
    }

    @Override
    public T tras() {
        return null;
    }

    @Override
    public void atualizarInicio(T dado) {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia");
        }
        ponteiroInicio.setDado(dado);
    }

    @Override
    public void atualizarFim(T dado) {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia");
        }
        ponteiroFim.setDado(dado);
    }

    @Override
    public T desenfileirarFim() {
        return null;
    }

    @Override
    public T desenfileirarInicio() {
        return null;
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimirFrente() {
        if (!estaVazia()){
            throw new NoSuchElementException("Fila Vazia!");
        }
        String resultado = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++){
            resultado += ponteiroAux.getDado();
            if (i != quantidade - 1){
                resultado += ", ";
            }
            ponteiroAux = ponteiroAux.getProximo();
        }
        return resultado += "]";
    }

    @Override
    public String imprimirTras() {
        String resultado = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++){
            resultado += ponteiroAux.getDado();
            if (i != quantidade - 1){
                resultado += ", ";
            }
            ponteiroAux = ponteiroAux.getAnterior();
        }
        return resultado += "]";
    }
}
