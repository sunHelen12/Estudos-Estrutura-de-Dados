package Pilhas_Estaticas.Pilha_Dupla;

public class PilhaEstaticaDupla implements EmpilhavelDupla {
    private  int indice1;
    private int indice2;
    private int tamanho;
    private Object[] dados;

    public PilhaEstaticaDupla(int tamanho){
        indice1 = -1; //pilha 1
        indice2 = tamanho; //pilha 2
        this.tamanho = tamanho;
        dados = new Object[tamanho];
    }

    public PilhaEstaticaDupla(){
        this(10);
    }

    //métodos para pilha 1
    @Override
    public void empilhar1(Object elemento) {
        if(!estaCheia1()){
            indice1++;
            dados[indice1] = elemento;
        } else{
           System.out.println("Pilha 1 Cheia!");
        }
    }

    @Override
    public Object desempilhar1() {
        Object elementoTopo = null;
        if(!estaVazia1()){
            elementoTopo = dados[indice1];
            indice1--;
        }else{
            System.out.println("Pilha 1 Vazia!");
        }
        return elementoTopo;
    }

    @Override
    public Object topo1() {
        Object elementoTopo = null;
        if(!estaVazia1()){
            elementoTopo = dados[indice1];
        }else{
            System.out.println("Pilha 1 Vazia!");
        }
        return elementoTopo;
    }

    @Override
    public boolean estaCheia1() {
       return (indice1 == indice2 - 1);
    }

    @Override
    public boolean estaVazia1() {
        return (indice1 == - 1);
    }

    @Override
	public String imprimir1(){
		String resultado = "[";
		for(int i = 0; i <= indice1; i++) {
			if (i == 0) {
				resultado += dados[i];
			}
			else {
				resultado += ", " + dados[i];
			}
		}
		return resultado + "]";
	}

    @Override
    public void empilhar2(Object elemento) {
       if(!estaCheia2()){
            indice2--;
            dados[indice2] = elemento;
       }else{
            System.out.println("Pilha 2 Cheia!");
       }
    }

    @Override
    public Object desempilhar2() {
       Object elementoTopo = null;
       if(!estaVazia2()){
            elementoTopo = dados[indice2];
            indice2++;
       }else{
            System.out.println("Pilha 2 Vazia!");
       }
       return elementoTopo;
    }

    @Override
    public Object topo2() {
        Object elementoTopo = null;
        if(!estaVazia2()){
             elementoTopo = dados[indice2];             
        }else{
             System.out.println("Pilha 2 Vazia!");
        }
        return elementoTopo;
    }

    @Override
    public boolean estaCheia2() {
       return estaCheia1();
    }

    @Override
    public boolean estaVazia2() {
        return (indice2 == tamanho);
    }

    @Override
    public String imprimir2() {
        String resultado = "[";
        for(int i = tamanho - 1; i >= indice2; i--){
            if (i == tamanho - 1){
                resultado += dados[i] + ", ";
            }else{
                resultado += dados[i];
            }
        }
        return resultado + "]";
    }
    
}
