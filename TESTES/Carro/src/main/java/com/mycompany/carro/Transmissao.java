package com.mycompany.carro;

public class Transmissao {
    private String tipo;
    private int marcha;
    private Boolean automatica;
    public Transmissao(String tipo, int marcha, Boolean automatica) {
        this.tipo = tipo;
        this.marcha = marcha;
        this.automatica = automatica;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getMarcha() {
        return marcha;
    }
    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }
    public Boolean getAutomatica() {
        return automatica;
    }
    public void setAutomatica(Boolean automatica) {
        this.automatica = automatica;
    }
    
    public void trocarMarcha(){
        System.out.println("Marcha trocada...");
    }

    public void engatarRe(){
        System.out.println("Engatando ré...");
    }

    
}
