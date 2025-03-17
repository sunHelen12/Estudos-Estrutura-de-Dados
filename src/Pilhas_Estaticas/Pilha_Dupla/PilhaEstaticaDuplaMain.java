package Pilhas_Estaticas.Pilha_Dupla;

public class PilhaEstaticaDuplaMain {
    public static void main(String[] args) {
        //instaciar
        EmpilhavelDupla pilha = new PilhaEstaticaDupla(12);
        //pilha 1
        pilha.empilhar1("Ubuntu");
        pilha.empilhar1("Linux Mint");
        pilha.empilhar1("Garuda");
        pilha.empilhar1("Zorin OS");
        pilha.empilhar1("Manjaro");
        pilha.empilhar1("Lubuntu");
        System.out.println("Elemento do Topo: " + pilha.topo1());
        pilha.empilhar1("Xubuntu");
        pilha.empilhar1("Kubuntu");
        pilha.empilhar1("KDE Neon");
        pilha.empilhar1("Fedora");       
        pilha.empilhar1("Windows 10");
        System.out.println("Pilha 1: " + pilha.imprimir1());
        Object conteudo = pilha.desempilhar1();
        System.out.println("Elemento Removido da Pilha 1: " + conteudo);
        System.out.println("Pilha 1: " + pilha.imprimir1());
        //pilha 2
        System.out.println("Elemento do Topo: " + pilha.topo2());
        pilha.empilhar2("Big Linux");
        pilha.empilhar2("Windows 8.1");        
        pilha.empilhar2("Elementary OS");
        System.out.println("Elemento do Topo: " + pilha.topo2());
        pilha.empilhar2("Debian");
        pilha.empilhar2("POP OS");
        pilha.empilhar2("CentOS");
        pilha.empilhar2("Kali Linux");
        pilha.empilhar2("Gentoo");
        pilha.empilhar2("Arch Linux");        
        conteudo = pilha.desempilhar2();
        pilha.empilhar2("Open Suse");
        pilha.empilhar2("Depeen");
        pilha.empilhar2("Red Hat");
        System.out.println("Elemento Removido da Pilha 2: " + conteudo);        
        System.out.println("Pilha 2: " + pilha.imprimir2());

    }
}
