package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class NetworkInterfaces {

    public static void main(String[] args) throws Exception {
        while(NetworkInterface.getNetworkInterfaces().hasMoreElements()) {
        printHardwareAddress(NetworkInterface.getNetworkInterfaces().nextElement());
        }
    }

    public static void printInetAddress(InetAddress address) {
        System.out.println(" - address: " + address);
    }

    public static void printHardwareAddress(NetworkInterface ni) {
        try {
            byte[] address = ni.getHardwareAddress();
            if (address == null) System.out.println(" - ether: null");
            else {
                StringBuilder b = new StringBuilder(" - ether: ");
                for (int i=0; i< address.length; i++) {
                    if (i>0) b.append(":");
                    b.append(Integer.toHexString(address[i]&0xFF));
                }
                System.out.println(b.toString());
            }
        } catch (IOException x) {
            System.out.println("- ether: " + x);
        }
    }
}
