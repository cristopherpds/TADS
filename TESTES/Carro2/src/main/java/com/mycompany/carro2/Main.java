package com.mycompany.carro2;

public class Main {
    public static void main(String[] args) {
        Painel painel = new Painel();

        painel.configurarCarro("Tesla", "Model S Plaid", 2024, 322, 1020, "Preto", 4.1);
        painel.configurarBanco(true, true, true, true, true, true);
        painel.ligarFarol(true);
        painel.configurarMotor("Eletrico", 1020, 0, "Tesla");
        painel.configurarPneu(235, 45, "Radial", "Michelin");
        painel.configurarPorta(false, 4,false);
        painel.configurarSistemaEletrico(true, true,"Lítio", "Supercharger");
        painel.configurarTanqueCombustivel(100, "Eletrico", 0);
        painel.configurarTransmissao("Automatica", 1, true);
        
        //painel.sistemaEletrico.ligar();
        painel.teste();
    }
}
