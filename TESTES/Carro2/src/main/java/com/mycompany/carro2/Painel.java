package com.mycompany.carro2;


public class Painel{
    Carro2 carro = new Carro2();
    Banco banco = new Banco();
    Farol farol = new Farol();
    Pneu pneu = new Pneu();
    Porta porta = new Porta();
    TanqueCombustivel tanqueCombustivel = new TanqueCombustivel();
    SistemaEletrico sistemaEletrico = new SistemaEletrico();
    Motor motor = new Motor();
    Transmissao transmissao = new Transmissao();

    
    public void configurarCarro(String marca, String modelo, int ano, int velocidadeMax, int potencia, String cor, double zeroACem){
        carro.setMarca(marca);
        carro.setModelo(modelo);
        carro.setAno(ano);
        carro.setVelocidadeMax(velocidadeMax);
        carro.setPotencia(potencia);
        carro.setCor(cor);
        carro.setZeroACem(zeroACem);

        carro.setSistemaEletrico(sistemaEletrico);
        carro.setTanqueCombustivel(tanqueCombustivel);
    }

    public void configurarBanco(boolean inclinacao, boolean aquecimento, boolean ventilacao, boolean massageador, boolean ajusteLombar, boolean ajusteAltura){
        banco.setInclinado(inclinacao);
        banco.setAquecido(aquecimento);
        banco.setVentilado(ventilacao);
        banco.setMassagemAtiva(massageador);
    }

    public void ligarFarol(boolean ligado){
        farol.setLigado(ligado);
    }

    public void configurarPneu(int tamanho,int largura, String perfil, String marca){
        pneu.setTamanho(tamanho);
        pneu.setLargura(largura);
        pneu.setPerfil(perfil);
        pneu.setMarca(marca);   
    }

    public void configurarPorta(boolean fechada, int numeroPortas, boolean vidroFechado){
        porta.setFechada(fechada);
        porta.setNumeroPortas(numeroPortas);
        porta.setVidroFechado(vidroFechado);
    }

    public void configurarSistemaEletrico(boolean bateriaCarregada, boolean fusivels, String tipoBateria, String tipoCarga){
        sistemaEletrico.setBateriaCarregada(bateriaCarregada);
        sistemaEletrico.setFusivels(fusivels);
        sistemaEletrico.setTipoBateria(tipoBateria);
        sistemaEletrico.setTipoCarga(tipoCarga);
    }

    public void configurarTanqueCombustivel(int capacidade, String tipoCombustivel, int nivelAtual){
        tanqueCombustivel.setCapacidade(capacidade);
        tanqueCombustivel.setTipoCombustivel(tipoCombustivel);
        tanqueCombustivel.setNivelCombustivel(nivelAtual);
    }

    public void configurarMotor(String tipoCombustivel, int potencia, int cilindradas, String marca){
        motor.setTipoConbustive(tipoCombustivel);
        motor.setPotencia(potencia);
        motor.setCilindrada(cilindradas);
        motor.setMarca(marca);
        motor.setSistemaEletrico(sistemaEletrico);
        motor.setTanqueCombustivel(tanqueCombustivel);
    }

    public void configurarTransmissao(String tipo, int marcha, boolean automatica){
        transmissao.setTipo(tipo);
        transmissao.setMarcha(marcha);
        transmissao.setAutomatica(automatica);
    }
    public void exibirInformacoes() {
        System.out.println("Carro: " + carro.getMarca() + " " + carro.getModelo() + " " + carro.getCor() + ", " + carro.getAno());
        System.out.println("Motor: " + motor.getMarca() + ", " + motor.getPotencia() + " HP");
        System.out.println("Pneus: " + pneu.getMarca() + ", Tamanho: " + pneu.getTamanho() + " Largura: " + pneu.getLargura() + " Perfil: " + pneu.getPerfil());
        System.out.println("Sistema Elétrico: Bateria " + sistemaEletrico.getTipoBateria() + ", Carga " + sistemaEletrico.getTipoCarga());
        System.out.println("Tanque de Combustível: " + tanqueCombustivel.getTipoCombustivel() + ", Capacidade " + tanqueCombustivel.getCapacidade());
        System.out.println("Transmissão: " + transmissao.getTipo() + ", " + transmissao.getMarcha() + " marchas");

        //chamar todos os methodos das classes

        System.out.println("\n Methodos das classes");
        motor.verificarSistemaEletrico();
        motor.verificarNivelCombustivel();
        carro.ligarCarro();
        

        porta.abrirVidro();
        porta.fecharVidro();

        sistemaEletrico.desligarFusivels();
        sistemaEletrico.ligar();
        sistemaEletrico.desligar();
        sistemaEletrico.ligarFusivels();
        sistemaEletrico.estaFuncionando();

        //tanqueCombustivel.abastecer(10);
        //tanqueCombustivel.estaVazio();

        transmissao.aumentarMarcha();
        transmissao.diminuirMarcha();

        banco.inclinar();
        banco.aquecer();
        banco.ventilar();
        banco.massagem();
        banco.ajustarLombar();
        banco.ajustarAltura();


    }
    
    public void teste(){
        exibirInformacoes();
    }
}