public class PilhaEstaticaInvertida implements Empilhavel {
    // variaveis de instancia
    private int ponteiroTopo; // indice
    private Object[] dados; // array
    // métodos
    // construtores

    public PilhaEstaticaInvertida(int tamanho) {
        dados = new Object[tamanho];
        ponteiroTopo = tamanho;
    }

    public PilhaEstaticaInvertida() {
        this(10); // chamamos o outro construtor, quando precisarmos mudar
        // só mudamos o primeiro construtor evitando inconsistência
    }

    // métodos principais
    @Override
    public void empilhar(Object elemento) {
        if (!estaCheia()) {
            ponteiroTopo--;
            dados[ponteiroTopo] = elemento;
        } else {
            System.err.println("Pilha Cheia!");
        }
    }

    @Override
    public void atualizar(Object elemento) {
        if (!estaVazia()) {
            dados[ponteiroTopo] = elemento;
        } else {
            System.err.println("Pilha Vazia!");
        }
    }

    @Override
    public Object desempilhar() {
        Object dadoEspiado = null;
        if (!estaVazia()) {
            dadoEspiado = dados[ponteiroTopo];
            ponteiroTopo++;
        } else {
            System.out.println("Pilha Vazia!");
        }
        return dadoEspiado;
    }

    @Override
    public Object espiar() {
        Object dadoEspiado = null;
        if (!estaVazia()) {
            dadoEspiado = dados[ponteiroTopo];
        } else {
            System.out.println("Pilha Vazia!");
        }
        return dadoEspiado;
    }

    // métodos auxiliares
    @Override
    public boolean estaCheia() {
        return (ponteiroTopo == 0);

    }

    @Override
    public boolean estaVazia() {
        return (ponteiroTopo == dados.length);
    }

    @Override
    public String imprimir() {
        String aux = "[";
        for (int i = ponteiroTopo; i < dados.length; i++) { // vamos até o ponteiroTopo, porque lá deve estar o último
            if (i == dados.length - 1) { // elemento implementado
                aux += dados[i];
            } else {
                aux += dados[i] + ", ";
            }
        }
        return aux + "]";
    }

}
