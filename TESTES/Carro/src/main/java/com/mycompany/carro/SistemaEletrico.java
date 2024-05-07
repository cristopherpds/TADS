package com.mycompany.carro;

public class SistemaEletrico {
    private Boolean bateriaCarregada;
    private Boolean fusivels;
    private String tipoBateria;
    private String tipoCarga;

    
    public SistemaEletrico(Boolean bateriaCarregada, Boolean fusivels, String tipoBateria, String tipoCarga) {
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


    public Boolean getBateriaCarregada() {
        return bateriaCarregada;
    }

    public void setBateriaCarregada(Boolean bateriaCarregada) {
        this.bateriaCarregada = bateriaCarregada;
    }

    public Boolean getFusivels() {
        return fusivels;
    }

    public void setFusivels(Boolean fusivels) {
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

    public Boolean estaFuncionando() {
        return bateriaCarregada && fusivels;
    }

}