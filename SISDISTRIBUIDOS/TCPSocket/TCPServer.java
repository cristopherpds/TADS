/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author victormalves
 */
public class TCPServer {
    public static void main(String args[]) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Servidor");
        while(true){
            Socket socketConexao = welcomeSocket.accept();
            Thread.sleep((long)(Math.random() * 10000));
            System.out.println("Conexao realizada");
            BufferedReader doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
            DataOutputStream paraCliente = new DataOutputStream(socketConexao.getOutputStream());
            String dados = doCliente.readLine();
            System.out.println("Recebido do cliente: "+dados);
            paraCliente.writeBytes(dados.toUpperCase()+"\n");
            System.out.println("Modificacao enviada para cliente");
        }
    }
}


