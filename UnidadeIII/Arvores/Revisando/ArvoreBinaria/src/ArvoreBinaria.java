public class ArvoreBinaria <T extends Comparable> {

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
            Elemento<T> atual = this.raiz;
            while (true){
                if (novoElemento.getValor().compareTo(atual.getValor()) == -1){
                    if (atual.getEsquerda() != null){
                        atual = atual.getEsquerda();
                    } else{
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                }else{
                    if (atual.getDireita() != null){
                        atual = atual.getDireita();
                    }else{
                        atual.setDireita(novoElemento);
                        break;
                    }
                }
            }
        }

    }


}
