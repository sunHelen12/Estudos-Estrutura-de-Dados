package UnidadeI.Pilhas_Estaticas.Aula_2.Pilha_Estatica_Fila;

import UnidadeI.Pilhas_Estaticas.Aula_2.PilhaEstatica.Empilhavel;
import UnidadeI.Pilhas_Estaticas.Aula_2.PilhaEstatica.PilhaEstatica;

public class FilaComPilhas implements  Enfileiravel {

    Empilhavel p1;
    Empilhavel p2;

    public FilaComPilhas(int tamanho){
        p1 = new PilhaEstatica(tamanho);
        p2 = new PilhaEstatica(tamanho);
    }

    @Override
    public void enfileirar(Object elemento) {
        if (!estaCheia()){
            p1.empilhar(elemento);
        }        
    }

    @Override
    public Object frente() {
        Object dadoInicio = null;
        if(!estaVazia()){
            while (!p1.estaVazia()){
                p2.empilhar(p1.desempilhar());            
            }
             dadoInicio = p2.espiar();
            while(!p2.estaVazia()){
                p1.empilhar(p2.desempilhar());
            }
        }
       
        return dadoInicio;
    }

    @Override
    public void atualizarInicio(Object elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarInicio'");
    }

    @Override
    public void atualizarFim(Object elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarFim'");
    }

    @Override
    public Object desenfileirar() {
        Object dadoInicio = null;
        while (!p1.estaVazia()){
            p2.empilhar(p1.desempilhar());            
        }
         dadoInicio = p2.espiar();
        while(!p2.estaVazia()){
            p1.empilhar(p2.desempilhar());
        }
        return dadoInicio;
    }

    @Override
    public boolean estaCheia() {
        return p1.estaCheia();
    }

    @Override
    public boolean estaVazia() {
       return p1.estaCheia();
    }

    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }
    
}
