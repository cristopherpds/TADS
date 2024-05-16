package com.mycompany.carro2;

public class SistemaEletrico {
    private boolean bateriaCarregada;
    private boolean fusivels;
    private String tipoBateria;
    private String tipoCarga;

    
public SistemaEletrico(boolean bateriaCarregada, boolean fusivels, String tipoBateria, String tipoCarga) {
        this.bateriaCarregada = bateriaCarregada;
        this.fusivels = fusivels;
        this.tipoBateria = tipoBateria;
        this.tipoCarga = tipoCarga;
    }

public SistemaEletrico() {
    this.bateriaCarregada = bateriaCarregada;
    this.fusivels = fusivels;
    this.tipoBateria = tipoBateria;
    this.tipoCarga = tipoCarga;
}

    public String getTipoBateria() {
        return tipoBateria;
    }

    public void setTipoBateria(String tipoBateria) {
        this.tipoBateria = tipoBateria;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public boolean getBateriaCarregada() {
        return bateriaCarregada;
    }

    public void setBateriaCarregada(boolean bateriaCarregada) {
        this.bateriaCarregada = bateriaCarregada;
    }

    public boolean getFusivels() {
        return fusivels;
    }

    public void setFusivels(boolean fusivels) {
        this.fusivels = fusivels;
    }

    public void ligar() {
        this.bateriaCarregada = true;
    }

    public void desligar() {
        this.bateriaCarregada = false;
    }

    public void ligarFusivels() {
        this.fusivels = true;
    }

    public void desligarFusivels() {
        this.fusivels = false;
    }

    public boolean estaFuncionando() {
        return bateriaCarregada && fusivels;
    }

}