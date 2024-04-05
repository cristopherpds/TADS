import java.io.IOException;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            // Cria um socket UDP na porta 9876
            socket = new DatagramSocket(9876);
            
            byte[] receiveData = new byte[1024];
            
            while (true) {
                // Prepara o pacote para receber dados
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                // Aguarda pela chegada de dados
                socket.receive(receivePacket);
                
                // Obtém os dados recebidos e o endereço do remetente
                String receivedMessage = new String(receivePacket.getData());
                InetAddress senderAddress = receivePacket.getAddress();
                int senderPort = receivePacket.getPort();
                
                System.out.println("Mensagem recebida: " + receivedMessage);
                
                // Responde ao cliente
                String responseMessage = "Olá, cliente!";
                byte[] responseData = responseMessage.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, senderAddress, senderPort);
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
