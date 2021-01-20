package me.sjl;

import org.junit.Test;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetWorkInterFaceTest {

    @Test
    public void networkTest() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            String name = networkInterface.getName();
            System.out.println("networkName:" + name);
            System.out.println("networkMTU:" + networkInterface.getMTU());
            System.out.println("mac 地址：" + networkInterface.getHardwareAddress());
            System.out.println();
        }
    }

}
