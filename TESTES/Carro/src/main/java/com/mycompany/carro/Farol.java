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
        System.out.println("Farol ligado...");
    }
    
}
