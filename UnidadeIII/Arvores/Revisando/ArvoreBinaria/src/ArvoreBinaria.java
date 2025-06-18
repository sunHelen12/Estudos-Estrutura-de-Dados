public class ArvoreBinaria <T>{

    private Elemento<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void adicionarElemento(T valor){
        // Criamos um elemento a ser adicionado
        Elemento<T> novoElemento = new Elemento<>(valor);
        // Caso a raíz esteja vazia:
        if(raiz == null){
            this.raiz = novoElemento;
        }else{
            //Se a árvore não estiver nula
        }

    }

}
