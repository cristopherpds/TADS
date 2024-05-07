package com.mycompany.carro;

public class Porta {
    private Boolean fechada;
    private int numeroPortas;
    private Boolean vidroFechado;

    

    public Porta(Boolean fechada, int numeroPortas, Boolean vidroFechado) {
        this.fechada = fechada;
        this.numeroPortas = numeroPortas;
        this.vidroFechado = vidroFechado;
    }

    public Boolean getFechada() {
        return fechada;
    }

    public void setFechada(Boolean fechada) {
        this.fechada = fechada;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public Boolean getVidroFechado() {
        return vidroFechado;
    }

    public void setVidroFechado(Boolean vidroFechado) {
        this.vidroFechado = vidroFechado;
    }

    public void abrirVidro() {
        if (!vidroFechado) {
            System.out.println("O vidro já está aberto.");
        } else {
            vidroFechado = false;
            System.out.println("Vidro abrindo...");
        }
    }

    public void fecharVidro() {
        if (vidroFechado) {
            System.out.println("O vidro já está fechado.");
        } else {
            vidroFechado = true;
            System.out.println("Vidro fechando...");
        }
    }
}