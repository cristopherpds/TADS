import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            // Cria um socket UDP
            socket = new DatagramSocket();
            
            // Prepara os dados a serem enviados
            String message = "Olá, servidor!";
            byte[] sendData = message.getBytes();
            
            // Obtém o endereço IP do servidor
            InetAddress serverAddress = InetAddress.getByName("localhost");
            
            // Cria um pacote UDP com os dados e o endereço do servidor
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            
            // Envia o pacote
            socket.send(sendPacket);
            
            // Aguarda pela resposta do servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            
            // Exibe a resposta do servidor
            String responseMessage = new String(receivePacket.getData());
            System.out.println("Resposta do servidor: " + responseMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
