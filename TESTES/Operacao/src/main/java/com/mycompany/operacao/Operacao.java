/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.operacao;

/**
 *
 * @author IFSul
 */
public class Operacao {

    public int somaDoisNumerosInteiros(int a, int b){
        return a + b;
    }
    
    public int substairDoisNumerosInteiros(int a, int b){
        return a - b;
    }
    
    public int multiplicarDoisNumerosInteiros(int a, int b){
        return a * b;
    }
    
    public int dividirDoisNumerosInteiros(int a, int b){
        return a / b;
    }
    
     public Boolean verificarNumeroPar(int x){
        return x % 2 == 0;
    }
     
     public Boolean verificarNumeroPositivo(int x){
        return x > 0;
    } 
     
    public String concatDuasSting(String s, String S){
        return s+S;
    }
    
    public String inverterString(String s){
        return new StringBuilder(s).reverse().toString();
    }
    
    public double mediaLista(double[] numeros){
        double media = 0;
        for(double numero : numeros){
            media += numero;
        }
        return media / numeros.length;
    }

}
