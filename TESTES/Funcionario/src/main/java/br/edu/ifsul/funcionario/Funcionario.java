/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifsul.funcionario;

/**
 *
 * @author IFSul
 */
public class Funcionario {
    public static void main(String[] args) {
        
    }

    private double salario;
    private String nome;
    
    public void reajustar(int nota){
        if(nota > 8){
            salario = salario * 1.5;
        }else{
            salario = salario * 1.1;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
