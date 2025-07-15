package models;

public class NoTriplo <T>{
    private NoTriplo <T> esq; // Valores menores
    private NoTriplo <T> dir; // Valores maiores
    private final int id; //
    private final T dados; //
    public char lado;

    public NoTriplo(int id, T dados) {
        this.id = id;
        this.dados = dados;
    }

    public NoTriplo getEsq() {
        return esq;
    }

    public void setEsq(NoTriplo esq) {
        this.esq = esq;
    }

    public NoTriplo getDir() {
        return dir;
    }

    public void setDir(NoTriplo dir) {
        this.dir = dir;
    }

    public int getId() {
        return id;
    }

    public T getDados() {
        return dados;
    }
}
