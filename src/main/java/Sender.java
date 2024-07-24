import connection.*;
import java.net.*;

public class Sender {
  public String getGreeting() { return "Sender started."; }

  public static void main(String[] args) {

    System.out.println(new Sender().getGreeting());
    int port = 12345;
    // Data to send
    String message = "Hello, UDP!";

    try (Connection conn = new Connection()) {

      conn.Send(message, "172.27.57.82", port);

      System.out.println("Sent message: " + message);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
