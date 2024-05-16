/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carro2;

/**
 *
 * @author IFSul
 */
public class Carro2 {
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

    
    public Carro2(String modelo, String marca, int ano, int velocidadeMax, int potencia, String cor, Double zeroACem,
            Pneu pneu, Motor motor, Banco banco, Farol farol, Transmissao transmissao, Porta porta,
            SistemaEletrico sistemaEletrico, TanqueCombustivel tanqueCombustivel) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.velocidadeMax = velocidadeMax;
        this.potencia = potencia;
        this.cor = cor;
        this.zeroACem = zeroACem;
        this.pneu = pneu;
        this.motor = motor;
        this.banco = banco;
        this.farol = farol;
        this.transmissao = transmissao;
        this.porta = porta;
        this.sistemaEletrico = sistemaEletrico;
        this.tanqueCombustivel = tanqueCombustivel;
    }

    public Carro2() {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.velocidadeMax = velocidadeMax;
        this.potencia = potencia;
        this.cor = cor;
        this.zeroACem = zeroACem;

        this.sistemaEletrico = new SistemaEletrico();
        this.tanqueCombustivel = new TanqueCombustivel();
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

    public Pneu getPneu() {
        return pneu;
    }

    public void setPneu(Pneu pneu) {
        this.pneu = pneu;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Farol getFarol() {
        return farol;
    }

    public void setFarol(Farol farol) {
        this.farol = farol;
    }

    public Transmissao getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(Transmissao transmissao) {
        this.transmissao = transmissao;
    }

    public Porta getPorta() {
        return porta;
    }

    public void setPorta(Porta porta) {
        this.porta = porta;
    }

    public SistemaEletrico getSistemaEletrico() {
        return sistemaEletrico;
    }

    public void setSistemaEletrico(SistemaEletrico sistemaEletrico) {
        this.sistemaEletrico = sistemaEletrico;
    }

    public TanqueCombustivel getTanqueCombustivel() {
        return tanqueCombustivel;
    }

    public void setTanqueCombustivel(TanqueCombustivel tanqueCombustivel) {
        this.tanqueCombustivel = tanqueCombustivel;
    }


    public void ligarCarro() {
        if (this.sistemaEletrico.getBateriaCarregada() && this.tanqueCombustivel.getNivelCombustivel() > 0) {
            // código para ligar o carro
            System.out.println("O carro foi ligado.");
        } else {
            if (!this.sistemaEletrico.getBateriaCarregada()) {
                System.out.println("O carro não pode ser ligado porque a bateria não está carregada.");
            }
            if (this.tanqueCombustivel.getNivelCombustivel() <= 0) {
                System.out.println("O carro não pode ser ligado porque o tanque de combustível está vazio.");
            }
        }
    }
    
    public void desligarCarro() {
        if (this.sistemaEletrico.getBateriaCarregada() == true) {
            this.sistemaEletrico.setBateriaCarregada(false);
            System.out.println("O carro foi desligado.");
        } else {
            System.out.println("O carro já está desligado.");
        }
    }
    
    public void abrirPorta() {
        if (this.porta.getFechada() == false) {
            this.porta.setFechada(true);
            System.out.println("A porta foi aberta.");
        } else {
            System.out.println("A porta já está aberta.");
        }
    }
    
    public void abastecerCarro(int quantidade) {
        int capacidade = this.tanqueCombustivel.getCapacidade();
        int combustivelAtual = this.tanqueCombustivel.getNivelCombustivel();
    
        if (combustivelAtual + quantidade <= capacidade) {
            this.tanqueCombustivel.setCapacidade(combustivelAtual + quantidade);
            System.out.println("O carro foi abastecido com " + quantidade + " x % de combustível.");
        } else {
            System.out.println("O tanque de combustível não tem capacidade suficiente.");
        }
    }

    @Override
    public String toString() {
        return "Carro [modelo=" + modelo + ", marca=" + marca + ", ano=" + ano + ", velocidadeMax=" + velocidadeMax
                + ", potencia=" + potencia + ", cor=" + cor + ", zeroACem=" + zeroACem + ", pneu=" + pneu + ", motor="
                + motor + ", banco=" + banco + ", farol=" + farol + ", transmissao=" + transmissao + ", porta=" + porta
                + ", sistemaEletrico=" + sistemaEletrico + ", tanqueCombustivel=" + tanqueCombustivel + ", getModelo()="
                + getModelo() + ", getMarca()=" + getMarca() + ", getAno()=" + getAno() + ", getClass()=" + getClass()
                + ", getVelocidadeMax()=" + getVelocidadeMax() + ", getPotencia()=" + getPotencia() + ", getCor()="
                + getCor() + ", getZeroACem()=" + getZeroACem() + ", getPneu()=" + getPneu() + ", getMotor()="
                + getMotor() + ", getBanco()=" + getBanco() + ", getFarol()=" + getFarol() + ", getTransmissao()="
                + getTransmissao() + ", getPorta()=" + getPorta() + ", getSistemaEletrico()=" + getSistemaEletrico()
                + ", hashCode()=" + hashCode() + ", getTanqueCombustivel()=" + getTanqueCombustivel() + ", toString()="
                + super.toString() + "]";
    }

    
}
