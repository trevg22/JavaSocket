import connection.*;
import java.net.*;

public class Receiver {
  public String getGreeting() { return "Reciever started"; }

  public static void main(String[] args) {
    System.out.println(new Receiver().getGreeting());

    try (Connection conn = new Connection()) {
      conn.Bind(12345);
      String msg = conn.Receive();
      System.out.println("Received message: " + msg);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
