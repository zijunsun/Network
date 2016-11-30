package API;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by SUN on 2016/11/29.
 */
public class Test1 {
    public static void main(String[] args) throws UnknownHostException{
        //获取本机的InetAddress实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println( "计算机名：" + address.getHostName());
        System.out.println( "IP地址：" + address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println( "字节数组形式IP：" + Arrays.toString(bytes));
        System.out.println( address);

        //根据机器名，获取Inetaddress实例
        InetAddress address1 = InetAddress.getByName("192.168.191.13");
        System.out.println( "计算机名：" + address1.getHostName());
        System.out.println( "IP地址：" + address1.getHostAddress());
        System.out.println( address1);
    }
}
