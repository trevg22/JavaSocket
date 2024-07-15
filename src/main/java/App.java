import java.net.*;

public class App {
    public String getGreeting() {
        return "Reciever started";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        try {
            // Create a DatagramSocket
            DatagramSocket socket = new DatagramSocket(12345);

            // Create a byte array to store received data
            byte[] receiveData = new byte[1024];

            // Create a DatagramPacket for receiving data
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive the packet (this will block until a packet is received)
             
            socket.receive(receivePacket);

            // Extract the received data from the packet
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Received message: " + receivedMessage);

            // Close the socket
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
