/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.aula2;

import javax.swing.JOptionPane;



/**
 *
 * @author IFSul
 */
public class Aula2 {

    public static void main(String[] args) {

        Termica termica; 
        termica = new Termica();
        termica.setCor("amarelo");
        termica.setMaterial("Inox");
        termica.setQuantidade(1.5);
        JOptionPane.showMessageDialog(null, "Atermica e de cor: " +termica.getCor() +"\n"+ "de material: "+termica.getMaterial() +"\n"+  "litros: "+termica.getQuantidade());
    }
}
