package connection;

import java.io.IOException;
import java.net.*;

public class Connection implements AutoCloseable {

  private DatagramSocket _sock;

  public Connection() {
    try {
      this._sock = new DatagramSocket();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close() throws IOException {
    if (_sock != null && !_sock.isClosed()) {
      _sock.close();
      System.out.println("Socket is closed.");
    }
  }
  public void Bind(int port) {
    if (!_sock.isClosed()) {
      _sock.close();
    }

    try {
      this._sock = new DatagramSocket(port);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public String Receive() {

    byte[] rec_data = new byte[1024];
    DatagramPacket rec_packet = new DatagramPacket(rec_data, rec_data.length);
    try {
      _sock.receive(rec_packet);
    } catch (Exception e) {
      e.printStackTrace();
    }

    String msg = new String(rec_packet.getData(), 0, rec_packet.getLength());
    return msg;
  }
  public void Send(String msg, String iname, int port) {
    try {
      byte[] data = msg.getBytes();
      InetAddress dest_ip = InetAddress.getByName(iname);
      DatagramPacket packet =
          new DatagramPacket(data, data.length, dest_ip, port);
      _sock.send(packet);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
