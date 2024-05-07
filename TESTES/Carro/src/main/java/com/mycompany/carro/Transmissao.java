package com.mycompany.carro;

public class Transmissao {
    private String tipo;
    private int marcha;
    private Boolean automatica;

    

    public Transmissao(String tipo, int marcha, Boolean automatica) {
        this.tipo = tipo;
        this.marcha = marcha;
        this.automatica = automatica;
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

    public Boolean getAutomatica() {
        return automatica;
    }

    public void setAutomatica(Boolean automatica) {
        this.automatica = automatica;
    }

    public void aumentarMarcha() {
        if (marcha < 5) {
            marcha++;
            System.out.println("Marcha aumentada para " + marcha);
        } else {
            System.out.println("Não é possível aumentar a marcha. Já está na marcha máxima.");
        }
    }

    public void diminuirMarcha() {
        if (marcha > 0) {
            marcha--;
            System.out.println("Marcha diminuída para " + marcha);
        } else {
            System.out.println("Não é possível diminuir a marcha. Já está na marcha mínima.");
        }
    }
}