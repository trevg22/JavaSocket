package connection;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

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

  public void bindByIp(InetAddress ip, int port) {
    if (_sock != null && !_sock.isClosed()) {
      _sock.close();
    }
    try {
      InetSocketAddress sock_addr = new InetSocketAddress(ip, port);
      _sock = new DatagramSocket(sock_addr);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void bindByName(String iname, int port) {

    if (_sock != null && !_sock.isClosed()) {
      _sock.close();
    }
    try {
      InetAddress ip = getIPv4Address(iname);

      bindByIp(ip, port);
      if (ip == null) {
        System.out.println("interface of name " + iname + " does note exist");
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public String receive() {

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

  public void send(String msg, InetSocketAddress dest) {
    try {
      byte[] data = msg.getBytes();
      // InetAddress dest_ip = InetAddress.getByName(iname);
      DatagramPacket packet = new DatagramPacket(data, data.length, dest);
      _sock.send(packet);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static InetAddress getIPv4Address(String iname)
      throws SocketException {
    NetworkInterface iface = NetworkInterface.getByName(iname);

    if (iface == null) {
      return null; // Network interface not found
    }

    Enumeration<InetAddress> addresses = iface.getInetAddresses();

    while (addresses.hasMoreElements()) {
      InetAddress address = addresses.nextElement();
      if (address instanceof Inet4Address) { // Check if it's an IPv4 address
        return address;
      }
    }

    return null; // No IPv4 address found
  }
}
