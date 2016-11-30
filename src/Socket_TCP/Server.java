package Socket_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by SUN on 2016/11/29.
 * 基于TCP协议socket通信，实现用户登录
 * 服务器端
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1、创建一个服务区端Socket，即ServerSocket,制定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            //2、调用accept()方法开始监听，等待客户端的连接
            System.out.println("*****服务器即将启动，等待客户端连接****");
            //等待客户端侦听
            Socket socket = serverSocket.accept();
            //3、获取输入流，并读取客户端信息
            InputStream is = socket.getInputStream();//字节输入流
            InputStreamReader isr = new InputStreamReader(is);//将字节流转换为字符流
            BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
            String info = null;
            while ((info = br.readLine()) != null){
                System.out.println("server:");
                System.out.println("client-message=>" + info);
            }
            socket.shutdownInput();
            //4、获取输出流，相应客户端请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎登陆");
            pw.flush();
            //5、关闭资源
            br.close();
            isr.close();
            is.close();
            serverSocket.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
