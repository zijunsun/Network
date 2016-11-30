package Socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by SUN on 2016/11/30.
 * 服务器端，实现UDP用户登陆
 */
public class Server {
    public static void main(String[] args) throws IOException {
            /*
             *接收客户端发送的数据
             */
            //1、创建服务器端DatagramSocket,指定端口
            DatagramSocket socket = new DatagramSocket(8800);
            //2、创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,data.length);
            //3、接收客户端发送的数据
            System.out.println("*****服务器即将启动，等待客户端连接****");
            socket.receive(packet);//此方法在接收到数据包之前一直阻塞
            //4、读取数据
            String info = new String(data,0,packet.getLength());
            System.out.println("server:");
            System.out.println("client=>" + info);
             /*
              *响应客户端数据
              */
             //1、定义客户端的地址、端口号、数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "欢迎登陆！".getBytes();
            //2、创建数据报，包含响应数据信息
            DatagramPacket packet1 = new DatagramPacket(data2,data2.length,address,port);
            //3、响应客户端
            socket.send(packet1);
            //4、关闭资源
            socket.close();

    }
}
