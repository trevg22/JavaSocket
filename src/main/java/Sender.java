import cmdparser.*;
import connection.*;
import java.net.*;

public class Sender {
  public String getGreeting() { return "Sender started."; }

  public static void main(String[] args) {

    System.out.println(new Sender().getGreeting());
    int port = 12345;
    System.out.println(args.length);
    if (args.length != 1) {
      System.out.println("Invalid command line");
      return;
    }

    InetSocketAddress dest = CMDParser.argToIPV4(args[0]);
    if (dest == null) {
      System.out.println("Could not parse socket address");
      return;
    }

    System.out.println("Invalid command line");

    // Data to send
    String message = "Hello, UDP!";

    try (Connection conn = new Connection()) {

      conn.send(message, dest);
      System.out.println("Sent message: " + message);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
