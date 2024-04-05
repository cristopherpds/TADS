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
    
    public void abastecerCarregar(){
        System.out.println("Carro pronto...");
    }

    public void vacio(){
        System.out.println("Bateria vacia...");
    }

    


    
}
