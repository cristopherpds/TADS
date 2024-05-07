package com.mycompany.carro;


public class Painel{
    Carro carro = new Carro(null, null, 0, 0, 0, null, null);
    Banco banco = new Banco(false, false, false, false, false, false);
    Farol farol = new Farol(null);
    Pneu pneu = new Pneu(0, 0, null, null);
    Porta porta = new Porta(null, 0, null);
    SistemaEletrico sistemaEletrico = new SistemaEletrico(null, null, null, null);
    TanqueCombustivel tanqueCombustivel = new TanqueCombustivel(0, null, 0);
    Motor motor = new Motor(null, 0, 0, null, sistemaEletrico, tanqueCombustivel);
    Transmissao transmissao = new Transmissao(null, 0, null);

    public void configurarCarro(String marca, String modelo, int ano, int velocidadeMax, int potencia, String cor, double zeroACem){
        carro.setMarca(marca);
        carro.setModelo(modelo);
        carro.setAno(ano);
        carro.setVelocidadeMax(velocidadeMax);
        carro.setPotencia(potencia);
        carro.setCor(cor);
        carro.setZeroACem(zeroACem);
    }

    public void configurarBanco(int inclinacao, boolean aquecimento, boolean ventilacao, boolean massageador, boolean ajusteLombar, boolean ajusteAltura){
        banco.setInclinado(true);
        banco.setAquecido(aquecimento);
        banco.setVentilado(ventilacao);
        banco.setMassagemAtiva(massageador);
    }

    public void ligarFarol(boolean ligado){
        farol.setLigado(ligado);
    }

    public void configurarMotor(String tipoCombustivel, int potencia, int cilindradas){
        motor.setTipoConbustive(tipoCombustivel);
        motor.setPotencia(potencia);
        motor.setCilindrada(cilindradas);
    }

    public void configurarPneu(int tamanho,int largura, String perfil, String marca){
        pneu.setTamanho(tamanho);
        pneu.setLargura(largura);
        pneu.setPerfil(perfil);
        pneu.setMarca(marca);   
    }

    public void configurarPorta(Boolean fechada, int numeroPortas, Boolean vidroFechado){
        porta.setFechada(fechada);
        porta.setNumeroPortas(numeroPortas);
        porta.setVidroFechado(vidroFechado);
    }

    public void configurarSistemaEletrico(String tipoBateria, String tipoCarga){
        sistemaEletrico.setTipoBateria(tipoBateria);
        sistemaEletrico.setTipoCarga(tipoCarga);
    }

    public void configurarTanqueCombustivel(int capacidade, String tipoCombustivel, int nivelAtual){
        tanqueCombustivel.setCapacidade(capacidade);
        tanqueCombustivel.setTipoCombustivel(tipoCombustivel);
        tanqueCombustivel.setNivelCombustivel(nivelAtual);
    }

    public void configurarTransmissao(String tipo, int numeroMarchas, String tipoEmbreagem){
        transmissao.setTipo(tipo);
        transmissao.setMarcha(numeroMarchas);
        transmissao.setTipo(tipoEmbreagem);
    }
    public void exibirInformacoes() {
        System.out.println("Carro: " + carro.getMarca() + " " + carro.getModelo() + ", " + carro.getAno());
        System.out.println("Cor: " + carro.getCor());
        System.out.println("Motor: " + motor.getMarca() + ", " + motor.getPotencia() + " HP");
        System.out.println("Pneus: " + pneu.getMarca() + ", " + pneu.getPerfil());
        System.out.println("Sistema Elétrico: Bateria " + sistemaEletrico.getTipoBateria() + ", Carga " + sistemaEletrico.getTipoCarga());
        System.out.println("Tanque de Combustível: " + tanqueCombustivel.getTipoCombustivel() + ", Capacidade " + tanqueCombustivel.getCapacidade());
        System.out.println("Transmissão: " + transmissao.getTipo() + ", " + transmissao.getMarcha() + " marchas");
    }
    
    public void teste(){
        exibirInformacoes();
    }
}