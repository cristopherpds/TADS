package com.mycompany.carro2;


public class Pneu {
    private int tamanho;
    private int largura;
    private String perfil;
    private String marca;
    private boolean furado;

    public Pneu(int tamanho, int largura, String perfil, String marca, boolean furado) {
        this.tamanho = tamanho;
        this.largura = largura;
        this.perfil = perfil;
        this.marca = marca;
        this.furado = furado;
    }

    public Pneu() {
        this.tamanho = tamanho;
        this.largura = largura;
        this.perfil = perfil;
        this.marca = marca;
        this.furado = false;
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

    public boolean getFurado() {
        return furado;
    }

    public void setFurado(boolean furado) {
        this.furado = furado;
    }

    public void inflar() {
        if (furado) {
            System.out.println("Não é possível inflar o pneu. O pneu está furado.");
        } else {
            System.out.println("Inflando o pneu...");
        }
    }

    public boolean estaFurado() {
        return furado;
    }
}