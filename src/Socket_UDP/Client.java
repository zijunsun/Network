package Socket_UDP;

import java.io.IOException;
import java.net.*;

/**
 * Created by SUN on 2016/11/30.
 * 客户端，实现UDP用户登陆
 */
public class Client {
    public static void main(String[] args) throws IOException {
        /*
         *向服务器发送消息
         */
        //1、定义服务器地址，服务器端口号，数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data =  "用户名：admin;密码：123".getBytes();
        //2、创建数据报，包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //3、创建DatagramPacket对象
        DatagramSocket socket = new DatagramSocket();
        //4、向服务器发送数据报
        socket.send(packet);
        /*
         *接收服务器的响应信息
         */
        //1、创建数据报，接收服务器响应信息
        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2,data2.length);
        //2、接收服务器响应数据
        socket.receive(packet1);
        //3、读取数据
        String reply = new String(data2,0,packet1.getLength());
        System.out.println("client:");
        System.out.println("server=>" + reply);
        //4、关闭资源
        socket.close();

    }
}
