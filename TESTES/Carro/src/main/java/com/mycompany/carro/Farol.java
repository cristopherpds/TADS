package com.mycompany.carro;

public class Farol {
    private Boolean ligado;

    public Farol(Boolean ligado) {
        this.ligado = ligado;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public void ligar(){
        if (!ligado) {
            System.out.println("Farol ligado...");
            this.ligado = true;
        } else {
            System.out.println("O farol já está ligado.");
        }
    }

    public void desligar(){
        if (ligado) {
            System.out.println("Farol desligado...");
            this.ligado = false;
        } else {
            System.out.println("O farol já está desligado.");
        }
    }
}