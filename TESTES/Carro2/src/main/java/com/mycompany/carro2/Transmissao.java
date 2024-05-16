package com.mycompany.carro2;

public class Transmissao {
    private String tipo;
    private int marcha;
    private boolean automatica;

    private Motor motor;

    
    public Transmissao(String tipo, int marcha, boolean automatica, Motor motor) {
        this.tipo = tipo;
        this.marcha = marcha;
        this.automatica = automatica;
        this.motor = motor;
    }

    public Transmissao() {
        this.tipo = tipo;
        this.marcha = marcha;
        this.automatica = automatica;

        this.motor = new Motor();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public boolean getAutomatica() {
        return automatica;
    }

    public void setAutomatica(boolean automatica) {
        this.automatica = automatica;
    }

    public void aumentarMarcha() {
        String tipoCombustivel = motor.getTipoConbustivel();
        if (tipoCombustivel != null && !tipoCombustivel.equals("Eletrico")) {
            if (marcha < 5) {
                marcha++;
                System.out.println("Marcha aumentada para " + marcha);
            } else {
                System.out.println("Não é possível aumentar a marcha. Já está na marcha máxima.");
            }
        }else {
            System.out.println("Carro elétrico não possui mais de uma marcha.");
        }
    }

    public void diminuirMarcha() {
        String tipoCombustivel = motor.getTipoConbustivel();
        
        if (tipoCombustivel != null && !tipoCombustivel.equals("Eletrico")) {
            if (marcha > 0) {
                marcha--;
                System.out.println("Marcha diminuída para " + marcha);
            } else {
                System.out.println("Não é possível diminuir a marcha. Já está na marcha mínima.");
            }
        } else {
            System.out.println("Carro elétrico possui uma unica marcha.");
        }
    }
}