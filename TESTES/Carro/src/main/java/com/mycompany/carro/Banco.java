package com.mycompany.carro;

public class Banco {
    private int inclinacao;
    private Boolean aquecimento;
    private Boolean ventilacao;
    private Boolean massageador;
    private Boolean ajusteLombar;
    private Boolean ajusteAltura;
    public Banco(int inclinacao, Boolean aquecimento, Boolean ventilacao, Boolean massageador, Boolean ajusteLombar,
            Boolean ajusteAltura) {
        this.inclinacao = inclinacao;
        this.aquecimento = aquecimento;
        this.ventilacao = ventilacao;
        this.massageador = massageador;
        this.ajusteLombar = ajusteLombar;
        this.ajusteAltura = ajusteAltura;
    }
    public int getInclinacao() {
        return inclinacao;
    }
    public void setInclinacao(int inclinacao) {
        this.inclinacao = inclinacao;
    }
    public Boolean getAquecimento() {
        return aquecimento;
    }
    public void setAquecimento(Boolean aquecimento) {
        this.aquecimento = aquecimento;
    }
    public Boolean getVentilacao() {
        return ventilacao;
    }
    public void setVentilacao(Boolean ventilacao) {
        this.ventilacao = ventilacao;
    }
    public Boolean getMassageador() {
        return massageador;
    }
    public void setMassageador(Boolean massageador) {
        this.massageador = massageador;
    }
    public Boolean getAjusteLombar() {
        return ajusteLombar;
    }
    public void setAjusteLombar(Boolean ajusteLombar) {
        this.ajusteLombar = ajusteLombar;
    }
    public Boolean getAjusteAltura() {
        return ajusteAltura;
    }
    public void setAjusteAltura(Boolean ajusteAltura) {
        this.ajusteAltura = ajusteAltura;
    }


    public void inclinar(){
        System.out.println("Banco inclinando nivel 5...");
    }

    public void aquecer(){
        System.out.println("Banco aquecendo...");
    }

    public void ventilar(){
        System.out.println("Banco ventilando...");
    }

    public void massagem(){
        System.out.println("Banco massagindo...");
    }

    public void ajustarLombar(){
        System.out.println("Banco ajustando lombar...");
    }
    
    public void ajustarAltura(){
        System.out.println("Banco ajustando altura...");
    }
}
