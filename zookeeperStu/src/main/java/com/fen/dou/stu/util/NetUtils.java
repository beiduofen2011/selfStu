package com.fen.dou.stu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * Created by 落叶 on 2019/12/2.
 */
public class NetUtils {

  private static Logger logger = LoggerFactory.getLogger(NetUtils.class);

  private static String LOCALHOST = "127.0.0.1";

  private static String ANYHOST = "0.0.0.0";

  private static Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

  public static boolean isValidAddress(InetAddress address) {
    if (address == null || address.isLoopbackAddress()) {
      return false;
    } else {
      String name = address.getHostAddress();
      return name != null && !(ANYHOST.equals(name)) && !LOCALHOST.equals(name)
          && IP_PATTERN.matcher(name).matches();
    }
  }

  public static InetAddress getLocalAddressByNetworkInterface() {
    try {
      Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
      if (interfaces != null) {
        while ((interfaces.hasMoreElements())) {
          NetworkInterface networkInterface = interfaces.nextElement();
          Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
          while (addresses.hasMoreElements()) {
            InetAddress address = addresses.nextElement();
            if (isValidAddress(address)) {
              return address;
            }
          }
        }
      }
    } catch (Exception e) {
      logger.warn("Failed to retriving ip address, " + e.getMessage(), e);
    }
    return null;
  }
}
