package com.mycompany.carro;

public class SistemaEletrico {
    private Boolean bateriaCarregada;
    private Boolean fusivels;
    public SistemaEletrico(Boolean bateriaCarregada, Boolean fusivels) {
        this.bateriaCarregada = bateriaCarregada;
        this.fusivels = fusivels;
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
}
