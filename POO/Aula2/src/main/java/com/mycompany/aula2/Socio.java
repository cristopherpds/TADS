/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula2;

import java.sql.Date;





/**
 *
 * @author IFSul
 */
public class Socio {
    private int idsocio;
    private String socio_nome;
    private Date socio_data_nacimento;

    public int getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(int idsocio) {
        this.idsocio = idsocio;
    }

    public String getSocio_nome() {
        return socio_nome;
    }

    public void setSocio_nome(String socio_nome) {
        this.socio_nome = socio_nome;
    }

    public Date getSocio_data_nacimento() {
        return socio_data_nacimento;
    }

    public void setSocio_data_nacimento(Date socio_data_nacimento) {
        this.socio_data_nacimento = socio_data_nacimento;
    }


    
}
