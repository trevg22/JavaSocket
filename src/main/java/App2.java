import java.net.*;
public class App2 {
    public String getGreeting() {
        return "Sender started.";
    }

    public static void main(String[] args) {
        try {
            // Destination address and port
            InetAddress recipientAddress = InetAddress.getByName("localhost");
            int port = 12345;

            // Data to send
            String message = "Hello, UDP!";
            byte[] sendData = message.getBytes();

            // Create a DatagramSocket
            DatagramSocket socket = new DatagramSocket();

            // Create a DatagramPacket
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, recipientAddress, port);

            // Send the packet
            socket.send(packet);

            System.out.println("Sent message: " + message);

            // Close the socket
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new App().getGreeting());
    }
}
