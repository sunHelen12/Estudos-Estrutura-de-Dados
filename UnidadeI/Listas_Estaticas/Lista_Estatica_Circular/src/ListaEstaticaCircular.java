public class ListaEstaticaCircular  implements  Listavel{

    private int ponteiroInicio, ponteiroFim, quantidade;
    private Object[] elementos;

    // Constutores
    public ListaEstaticaCircular(int tamanho) {
        this.elementos = new Object[tamanho]; // inicializamos
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        quantidade = 0;
    }

    public ListaEstaticaCircular() {
        this(10);
    }

    @Override
    public void inserir(Object elemento, int indice) {
        if(!estaCheia()){
            if(indice >= 0 && indice <= quantidade){
                int x = ponteiroFim;
                int y = avancar(x);
                int posicaoFisica = mapeamento(indice);
                for (int i = 0; i < quantidade - indice; i++){
                    elementos[x] = elementos[y];
                    x = retroceder(x);
                    y = retroceder(y);
                }
                elementos[posicaoFisica] = elemento;
                quantidade++;
                avancar(ponteiroFim);
            }
        }else{
            System.err.println("Lista Vazia!");
        }
    }

    //mesmo código de enfileirar
    @Override
    public void anexar(Object elemento) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim);
            elementos[ponteiroFim] = elemento;
            quantidade++;
        } else {
            System.out.println("Fila cheia");
        }
    }

    @Override
    public Object selecionar(int indice) {
        Object selecionado = null;
        if(!estaCheia()){
            //verificar se a posição é válida
            if(indice >= 0 && indice < quantidade){
                int  posicaoFisica = mapeamento(indice);
                selecionado = elementos[posicaoFisica];
            }
        }else{
            System.err.println("Lista está Cheia!");
        }
        return selecionado;
    }

    @Override
    public Object[] selecionarTodos() {
        Object[] todosSelecionados = null;
        if(!estaVazia()){
            todosSelecionados = new Object[quantidade];
            int recebePosicaoFisica = ponteiroInicio;
            for (int i = 0; i < quantidade; i++) {
                todosSelecionados[i] = elementos[recebePosicaoFisica];
                recebePosicaoFisica = avancar(recebePosicaoFisica);
            }
            return todosSelecionados;
        } else {
            System.err.println("Lista vazia!");
        }

        return todosSelecionados;
    }

    @Override
    public void atualizar(Object elemento, int indice) {
        if(!estaVazia()){
            if(indice >= 0 && indice < quantidade){
                int posicaoFisica = mapeamento(indice);
                elementos[posicaoFisica] = elemento;
            }else{
                System.err.println("Índice inválido!");
            }
        }else{
            System.err.println("Lista Vazia!");
        }
    }

    @Override
    public Object apagar(int indice) {
        Object elementosAux = null;
        if(!estaVazia()){
            if(indice >= 0 && indice < quantidade){
                int posicaoFisica  = mapeamento(indice);

                int x = posicaoFisica;
                int y = avancar(x);
                for(int i = 0; i < quantidade - indice - 1; i++){
                    elementos[x] = elementos[y];
                    x = avancar(x);
                    y = avancar(y);

                }
                quantidade --;
                ponteiroFim = retroceder(ponteiroFim);
            }
        }else{
            System.err.println("Lista Vazia!");
        }
        return elementosAux;
    }

    @Override
    public int primeiraOcorrencia(Object elemento){
        int aux = -1;
        if(!estaVazia()){
            int recebePosicaoFisica = ponteiroInicio;
            for(int i = 0; i < quantidade; i++){
                if(elementos[recebePosicaoFisica]  == elemento){
                    recebePosicaoFisica = avancar(recebePosicaoFisica);
                    aux = recebePosicaoFisica;
                }
            }
        }else{
            System.err.println("Lista Vazia!");
        }
        return aux;
    }

    @Override
    public boolean contem(Object elemento) {
        boolean contem = false;
        if(!estaVazia()){
            int recebePosicaoFisica = ponteiroInicio;
            for(int i = 0; i < quantidade; i++){
                if(elementos[recebePosicaoFisica] == elemento){
                    contem = true;

                }
                recebePosicaoFisica = avancar(recebePosicaoFisica);
            }
        }else{
            System.err.println("Lista Vazia!");
        }
        return contem;
    }

    @Override
    public int ultimaOcorrencia(Object elemento) {
        int aux = -1;
        if (!estaVazia()) {
            int recebePosicaoFisica = ponteiroInicio;
            for (int i = 0; i < quantidade; i++) {
                if (elementos[recebePosicaoFisica] == elemento) {
                    aux = i; // Armazena o índice lógico (não o físico!)
                }
                recebePosicaoFisica = avancar(recebePosicaoFisica);
            }
        } else {
            System.err.println("Lista Vazia!");
        }
        return aux;
    }

    @Override
    public void limpar() {
        if(!estaVazia()){
            quantidade = 0;
            ponteiroInicio = 0;
            ponteiroFim = -1;
        }
    }

    @Override
    public boolean comparador(Object elemento1, Object elemento2) {
        if (elemento1 == null && elemento2 == null) {
            return true;
        }
        if (elemento1 == null || elemento2 == null) {
            return false;
        }
        return elemento1.equals(elemento2);
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == elementos.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimir(){
        String resultado = "[";
        int ponteiroAux = ponteiroInicio;
        for(int i = 0; i < quantidade; i++){
            resultado += elementos[ponteiroAux];
            if(i != quantidade - 1){
                resultado += ", ";
            }
            ponteiroAux = avancar(ponteiroAux);
        }
        return resultado + "]";
    }

    private int avancar(int ponteiro){
        return ((ponteiro + 1) % elementos.length); //para ela não chegar ao número inválido do tamanho
    }

    private int mapeamento (int indice){
        return (indice + ponteiroInicio) % elementos.length;
    }

    // private comparador(equals()){

    // }

    private int retroceder(int ponteiro){
        return ((ponteiro -1) + elementos.length) % elementos.length;
    }

}
