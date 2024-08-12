import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CMDParser {
  InetSocketAddress argToIPV4(String arg) {
    String regex =
        "^([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}):([0-9]{1,5})$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(arg);

    try {
      if (matcher.matches()) {
        String ip = matcher.group(1);
        int port = Integer.parseInt(matcher.group(2));
        return new InetSocketAddress(ip, port);
      } else {
        return null;
      }

    } catch (Exception e) {
      System.out.println("Invalid ip " + e.getMessage());
    }
    // InetSocketAddress
    return null;
  }
}
