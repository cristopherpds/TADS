/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carro;

import java.util.Date;

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

}
