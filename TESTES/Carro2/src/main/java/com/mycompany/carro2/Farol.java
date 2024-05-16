package com.mycompany.carro2;

public class Farol {
    private boolean ligado;

    public Farol(boolean ligado) {
        this.ligado = ligado;
    }

    public Farol() {
        this.ligado = ligado;
    }

    public boolean getLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
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