import java.net.*;

public class Socket{
    private DatagramSocket sock;
    public Socket(int port)
    {
        try{
            sock=new DatagramSocket(port);
        }
        catch(Exception e)
    {
            e.printStackTrace();
        }

    }
}
