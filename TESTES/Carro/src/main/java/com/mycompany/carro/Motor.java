package com.mycompany.carro;

public class Motor {
    private String tipoConbustive;
    private int potencia;
    private int cilindrada;
    private String marca;
    private Boolean desligado;
    private SistemaEletrico sistemaEletrico;
    private TanqueCombustivel tanqueCombustivel;

    public Motor(String tipoConbustive, int potencia, int cilindrada, String marca, SistemaEletrico sistemaEletrico,
            TanqueCombustivel tanqueCombustivel) {
        this.tipoConbustive = tipoConbustive;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.marca = marca;
        this.sistemaEletrico = sistemaEletrico;
        this.tanqueCombustivel = tanqueCombustivel;
    }

    public String getTipoConbustive() {
        return tipoConbustive;
    }

    public void setTipoConbustive(String tipoConbustive) {
        this.tipoConbustive = tipoConbustive;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getDesligado() {
        return desligado;
    }

    public void setDesligado(Boolean desligado) {
        this.desligado = desligado;
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

    public void verificarSistemaEletrico() {
        if (sistemaEletrico.estaFuncionando()) {
            System.out.println("Sistema elétrico está funcionando corretamente.");
        } else {
            System.out.println("Sistema elétrico apresenta problemas.");
        }
    }

    public void verificarNivelCombustivel() {
        int nivel = tanqueCombustivel.getNivelCombustivel();
        if (nivel > 0) {
            System.out.println("Nível de combustível: " + nivel + "%");
        } else {
            System.out.println("Tanque de combustível vazio.");
        }
    }
}
