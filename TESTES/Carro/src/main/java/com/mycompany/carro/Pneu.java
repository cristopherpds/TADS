package com.mycompany.carro;

public class Pneu {
    private int tamanho;
    private int largura;
    private String perfil;
    private String marca;

    public Pneu(int tamanho, int largura, String perfil, String marca) {
        this.tamanho = tamanho;
        this.largura = largura;
        this.perfil = perfil;
        this.marca = marca;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public int getLargura() {
        return largura;
    }
    public void setLargura(int largura) {
        this.largura = largura;
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void rodar(){
        System.out.println("Pneu rodando...");
    }
    public void acelerar(){
        System.out.println("Pneu acelerando...");
    }

}
