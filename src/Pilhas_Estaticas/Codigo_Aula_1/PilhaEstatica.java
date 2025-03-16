package Pilhas_Estaticas.Codigo_Aula_1;

public class PilhaEstatica implements Empilhavel {
    private int indice;
    private int tamanho;
    private Object[] dados;

    public PilhaEstatica() {
        this(10);
    }

    public PilhaEstatica(int tamanho) {
        indice = -1;
        this.tamanho = tamanho;
        dados = new Object[tamanho];
    }

    @Override
    public void empilhar(Object elemento) {
        if (!estaCheia()) {
            indice++;
            dados[indice] = elemento;
        } else {
            System.out.println("Pilha Cheia!");
        }
    }

    @Override
    public Object desempilhar() {
        Object elementoTopo = null;
        if (!estaVazia()) {
            elementoTopo = dados[indice];
            indice--;
        } else {
            System.out.println("Pilha Vazia!");
        }

        return elementoTopo; // retorna o elemento desempilhado
    }

    @Override
    public Object topo() {
        Object dadoTopo = null;
        if (!estaVazia()) {
            dadoTopo = dados[indice];
        } else {
            System.out.println("Pilha Vazia!");
        }
        return dadoTopo;
    }

    @Override
    public boolean estaCheia() {
        return (indice == tamanho - 1);
    }

    @Override
    public boolean estaVazia() {
        return (indice == -1);
    }

    @Override
    public String imprimir() {
        String resultado = "[";
        for (int i = 0; i <= indice; i++) {
            resultado += dados[i];

            if (i < indice) {
                resultado += ", ";
            }
        }

        return resultado + "]";
    }

}
