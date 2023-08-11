/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.aula2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author IFSul
 */
public class Execicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here

        List<Socio> socios = new ArrayList<>();

        while (true) {
            int id = 0;
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do sócio (ou 0 para sair):"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID inválido. Por favor, tente novamente.");
                e.printStackTrace();
                continue;
            }

            if (id == 0) {
                break;
            }

            String socio_nome = JOptionPane.showInputDialog("Digite o nome do sócio:");
            Date data_nascimento = Date.valueOf(JOptionPane.showInputDialog("Digite a data de nascimento do sócio (AAAA-MM-DD):"));

            Socio novoSocio = new Socio();
            novoSocio.setIdsocio(id);
            novoSocio.setSocio_nome(socio_nome);
            novoSocio.setSocio_data_nacimento(data_nascimento);

            socios.add(novoSocio);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("Lista de Sócios:\n\n");
        for (Socio socio : socios) {
            sb.append("ID: ").append(socio.getIdsocio()).append("\n");
            sb.append("Nome: ").append(socio.getSocio_nome()).append("\n");
            sb.append("Data de Nascimento: ").append(socio.getSocio_data_nacimento()).append("\n");
            sb.append("-----------------------------\n");
            JOptionPane.showMessageDialog(null, sb.toString());
        }

    }
}
