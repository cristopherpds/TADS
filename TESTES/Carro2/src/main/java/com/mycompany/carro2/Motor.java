package com.mycompany.carro2;

public class Motor {
    private String tipoConbustivel;
    private int potencia;
    private int cilindrada;
    private String marca;
    private boolean desligado;
    private SistemaEletrico sistemaEletrico;
    private TanqueCombustivel tanqueCombustivel;

    
    public Motor(String tipoConbustivel, int potencia, int cilindrada, String marca, boolean desligado,
            SistemaEletrico sistemaEletrico, TanqueCombustivel tanqueCombustivel) {
        this.tipoConbustivel = tipoConbustivel;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.marca = marca;
        this.desligado = desligado;
        this.sistemaEletrico = sistemaEletrico;
        this.tanqueCombustivel = tanqueCombustivel;
    }


    public Motor() {
        this.tipoConbustivel = tipoConbustivel;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.marca = marca;

        this.sistemaEletrico = new SistemaEletrico();
        this.tanqueCombustivel = new TanqueCombustivel();
    }


    public String getTipoConbustivel() {
        return tipoConbustivel;
    }

    public void setTipoConbustive(String tipoConbustivel) {
        this.tipoConbustivel = tipoConbustivel;
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

    public boolean getDesligado() {
        return desligado;
    }

    public void setDesligado(boolean desligado) {
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
        if (nivel >= 0) {
            System.out.println("Nível de combustível: " + nivel + "%");
        } else {
            System.out.println("Tanque de combustível vazio.");
        }
    }
}
