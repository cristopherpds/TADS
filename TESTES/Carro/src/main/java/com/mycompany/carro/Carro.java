/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carro;


/**
 *
 * @author IFSul
 */
public class Carro {
    private String modelo;
    private String marca;
    private int ano;
    private int velocidadeMax;
    private int potencia;
    private String cor;
    private Double zeroACem;
    private Pneu pneu;
    private Motor motor;
    private Banco banco;
    private Farol farol;
    private Transmissao transmissao;
    private Porta porta;
    private SistemaEletrico sistemaEletrico;
    private TanqueCombustivel tanqueCombustivel;

    public void teste(){
        System.out.println("teste");
    }

    public Carro(String modelo, String marca, int ano, int velocidadeMax, int potencia, String cor, Double zeroACem) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.velocidadeMax = velocidadeMax;
        this.potencia = potencia;
        this.cor = cor;
        this.zeroACem = zeroACem;
    }
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getZeroACem() {
        return zeroACem;
    }

    public void setZeroACem(Double zeroACem) {
        this.zeroACem = zeroACem;
    }

    public void Acelerar() {
        System.out.println("Acelerando...");
    }

    public void Frear() {
        System.out.println("Freando...");
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(int velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setPneu(Pneu p) {
        this.pneu = p;
    }

    public Object getPneu() {
        return pneu;
    }

    public void setBanco(Banco b) {
        this.banco = b;
    }

    public Object getBanco() {
        return banco;
    }

    public void setPorta(Porta p1) {
        this.porta = p1;
    }

    public Object getPorta() {
        return porta;
    }

    public void setTransmissao(Transmissao t) {
        this.transmissao = t;
    }

    public Object getTransmissao() {
        return transmissao;
    }

    public void setFarol(Farol f) {
        this.farol = f;
    }

    public Object getFarol() {
        return farol;
    }

    public void setTanqueCombustivel(TanqueCombustivel tC) {
        this.tanqueCombustivel = tC;
    }

    public Object getTanqueCombustivel() {
        return tanqueCombustivel;
    }

    public void setSistemaEletrico(SistemaEletrico sE) {
        this.sistemaEletrico = sE;
    }

    public Object getSistemaEletrico() {
        return sistemaEletrico;
    }

    public void setPainel(Pneu p) {
        this.pneu = p;
    }

    public Object getPainel() {
        return pneu;
    }

    public void setMotor(Motor m) {
        this.motor = m;
    }

    public void ligar() {
        System.out.println("Ligando...");
    }

    public boolean isLigado() {
        return true;
    }

}
