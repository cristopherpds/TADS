package com.mycompany.carro;

public class TanqueCombustivel {
    private int capacidade;
    private String tipoCombustivel;
    private int nivelCombustivel;

    public TanqueCombustivel(int capacidade, String tipoCombustivel, int nivelCombustivel) {
        this.capacidade = capacidade;
        this.tipoCombustivel = tipoCombustivel;
        this.nivelCombustivel = nivelCombustivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(int nivelCombustivel) {
        this.nivelCombustivel = nivelCombustivel;
    }

    public void abastecer(int quantidade) {
        if (nivelCombustivel + quantidade <= capacidade) {
            nivelCombustivel += quantidade;
            System.out.println(
                    "Tanque abastecido com " + quantidade + " litros. Nível atual: " + nivelCombustivel + " litros.");
        } else {
            System.out.println(
                    "Não é possível abastecer essa quantidade. O tanque só pode conter " + capacidade + " litros.");
        }
    }

    public Boolean estaVazio() {
        return nivelCombustivel == 0;
    }
}
