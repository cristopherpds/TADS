package com.mycompany.carro;

public class Banco {
    private boolean inclinado = false;
    private boolean aquecido = false;
    private boolean ventilado = false;
    private boolean massagemAtiva = false;
    private boolean lombarAjustada = false;
    private boolean alturaAjustada = false;

    public Banco(boolean inclinado, boolean aquecido, boolean ventilado, boolean massagemAtiva, boolean lombarAjustada,
            boolean alturaAjustada) {
        this.inclinado = inclinado;
        this.aquecido = aquecido;
        this.ventilado = ventilado;
        this.massagemAtiva = massagemAtiva;
        this.lombarAjustada = lombarAjustada;
        this.alturaAjustada = alturaAjustada;
    }

    public boolean isInclinado() {
        return inclinado;
    }

    public void setInclinado(boolean inclinado) {
        this.inclinado = inclinado;
    }

    public boolean isAquecido() {
        return aquecido;
    }

    public void setAquecido(boolean aquecido) {
        this.aquecido = aquecido;
    }

    public boolean isVentilado() {
        return ventilado;
    }

    public void setVentilado(boolean ventilado) {
        this.ventilado = ventilado;
    }

    public boolean isMassagemAtiva() {
        return massagemAtiva;
    }

    public void setMassagemAtiva(boolean massagemAtiva) {
        this.massagemAtiva = massagemAtiva;
    }

    public boolean isLombarAjustada() {
        return lombarAjustada;
    }

    public void setLombarAjustada(boolean lombarAjustada) {
        this.lombarAjustada = lombarAjustada;
    }

    public boolean isAlturaAjustada() {
        return alturaAjustada;
    }

    public void setAlturaAjustada(boolean alturaAjustada) {
        this.alturaAjustada = alturaAjustada;
    }

    public void inclinar() {
        if (!inclinado) {
            System.out.println("Banco inclinando nivel 5...");
            inclinado = true;
        } else {
            System.out.println("Banco já está inclinado.");
        }
    }

    public void aquecer() {
        if (!aquecido) {
            System.out.println("Banco aquecendo...");
            aquecido = true;
        } else {
            System.out.println("Banco já está aquecido.");
        }
    }

    public void ventilar() {
        if (!ventilado) {
            System.out.println("Banco ventilando...");
            ventilado = true;
        } else {
            System.out.println("Banco já está ventilado.");
        }
    }

    public void massagem() {
        if (!massagemAtiva) {
            System.out.println("Banco massagindo...");
            massagemAtiva = true;
        } else {
            System.out.println("Massagem já está ativa.");
        }
    }

    public void ajustarLombar() {
        if (!lombarAjustada) {
            System.out.println("Banco ajustando lombar...");
            lombarAjustada = true;
        } else {
            System.out.println("Lombar já está ajustada.");
        }
    }

    public void ajustarAltura() {
        if (!alturaAjustada) {
            System.out.println("Banco ajustando altura...");
            alturaAjustada = true;
        } else {
            System.out.println("Altura já está ajustada.");
        }
    }
}
