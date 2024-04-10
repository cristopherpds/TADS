package com.mycompany.carro;

public class Motor {
    private String tipoConbustive;
    private int potencia;
    private int cilindrada;
    private String marca;
    private Boolean desligado;

    public Motor(String tipoConbustive, int potencia, int cilindrada, String marca) {
        this.tipoConbustive = tipoConbustive;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.marca = marca;
    }

    
    public String getTipoConbustive() {
        return tipoConbustive;
    }
    
    public void setTipoConbustive(String tipoConbustive) {
        this.tipoConbustive = tipoConbustive;
    }
    
    public int getPotencia() {
        return potencia;
    }
    
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCilindrada() {
        return cilindrada;
    }
    
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean ligar(){
        return this.desligado = false;
    }

    public Boolean desligar(){
        return this.desligado = true;
    }

    
    
    
}
