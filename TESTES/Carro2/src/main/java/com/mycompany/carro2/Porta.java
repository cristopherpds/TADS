package com.mycompany.carro2;

public class Porta {
    private boolean fechada;
    private int numeroPortas;
    private boolean vidroFechado;


    public Porta(boolean fechada, int numeroPortas, boolean vidroFechado) {
        this.fechada = fechada;
        this.numeroPortas = numeroPortas;
        this.vidroFechado = vidroFechado;
    }

    public Porta() {
        this.fechada = fechada;
        this.numeroPortas = numeroPortas;
        this.vidroFechado = vidroFechado;
    }

    public boolean getFechada() {
        return fechada;
    }

    public void setFechada(boolean fechada) {
        this.fechada = fechada;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public boolean getVidroFechado() {
        return vidroFechado;
    }

    public void setVidroFechado(boolean vidroFechado) {
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